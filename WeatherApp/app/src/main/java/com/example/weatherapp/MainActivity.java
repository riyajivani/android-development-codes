package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout homeRL;
    private ProgressBar loadingPB;
    private TextView cityNameTV,tempratureTV,conditionTV;
    private RecyclerView weatherRV;
    private TextInputEditText cityEdit;
    private ImageView backIV,iconIV,searchIV;
    private ArrayList<WeatherRVModel> weatherRVModelArrayList;
    private WeatherRVAdapter weatherRVAdapter;

    private LocationManager locationManager;
    private int PERMISSON_CODE=1;
    String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN ); // for full screen

        setContentView(R.layout.activity_main);

        homeRL = findViewById(R.id.idRLHome);
        loadingPB = findViewById(R.id.idPBLoading);
        cityNameTV = findViewById(R.id.idTVCityName);
        tempratureTV = findViewById(R.id.idTVTemprature);
        conditionTV = findViewById(R.id.idTVCondition);
        weatherRV = findViewById(R.id.idRVWeather);
        cityEdit = findViewById(R.id.idEditCity);
        backIV = findViewById(R.id.idIVBack);
        iconIV = findViewById(R.id.idIVIcon);
        searchIV = findViewById(R.id.idIVSearch);

        weatherRVModelArrayList = new ArrayList<>();

        weatherRVAdapter = new WeatherRVAdapter(this,weatherRVModelArrayList);
        weatherRV.setAdapter(weatherRVAdapter);

        locationManager=(LocationManager)  getSystemService(Context.LOCATION_SERVICE);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},PERMISSON_CODE);
        }

        Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        cityName=getCityName(location.getLongitude(),location.getLatitude());
        getWeatherInfo(cityName);

//        if (location != null)
//        {
//            cityName = getCityName(location.getLongitude(), location.getLatitude());
//            getWeatherInfo(cityName);
//        }
//        else
//        {
//            Toast.makeText(this, "Unable to determine location", Toast.LENGTH_SHORT).show();
//        }

        searchIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city =  cityEdit.getText().toString();

                if(city.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"please enter city name",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    cityNameTV.setText(cityName);
                    getWeatherInfo(city);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==PERMISSON_CODE)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this,"permission granted",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,"please provide permissions",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private String getCityName(double longitude, double latitude)
    {
        String cityName="Not Found";
        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());

        try
        {
            List<Address> addresses = gcd.getFromLocation(latitude,longitude,10);

            for(Address adr : addresses)
            {
                if(adr!=null)
                {
                    String city = adr.getLocality();

                    if(city!=null && !city.equals(""))
                    {
                        cityName = city;
                    }
                    else
                    {
                        Log.d("TAG","CITY NOT FOUND");
                        Toast.makeText(this, "USER CITY NOT FOUND", Toast.LENGTH_SHORT).show();
                    }
                    
                }
            }

        }catch (IOException i){
            i.printStackTrace();
        }

        return cityName;
    }

    private void getWeatherInfo(String cityName)
    {
        String url = "http://api.weatherapi.com/v1/forecast.json?key=e8db012013fe4dd5a2670705233009&q="+cityName+"&days=1&aqi=yes&alerts=yes";
        cityNameTV.setText(cityName);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                loadingPB.setVisibility(View.GONE);
                homeRL.setVisibility(View.VISIBLE);

                weatherRVModelArrayList.clear();

                try {
                    String temprature = response.getJSONObject("current").getString("temp_c");
                    tempratureTV.setText(temprature+"°C");
                    int isDay = response.getJSONObject("current").getInt("is_day");
                    String condition = response.getJSONObject("current").getJSONObject("condition").getString("text");
                    String conditionIcon = response.getJSONObject("current").getJSONObject("condition").getString("icon");
                    Picasso.get().load("http:".concat(conditionIcon)).into(iconIV);
                    conditionTV.setText(condition);

                    if(isDay==1)
                    {
                        //morning
                        Picasso.get().load("https://images.unsplash.com/photo-1514897275838-55c3ed3ee738?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OTJ8fHNreXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=600&q=60").into(backIV);
                    }
                    else
                    {
                        Picasso.get().load("https://images.unsplash.com/photo-1590418606746-018840f9cd0f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=387&q=80").into(backIV);
                    }

                    JSONObject forecastObj = response.getJSONObject("forecast");
                    JSONObject forecast0 = forecastObj.getJSONArray("forecastday").getJSONObject(0);
                    JSONArray hourArray = forecast0.getJSONArray("hour");

                    for(int i=0; i<hourArray.length(); i++)
                    {
                        JSONObject hourobj = hourArray.getJSONObject(i);
                        String time = hourobj.getString("time");
                        String temper = hourobj.getString("temp_c");
                        String img = hourobj.getJSONObject("condition").getString("icon");
                        String wind = hourobj.getString("wind_kph");
                        weatherRVModelArrayList.add(new WeatherRVModel(time,temper,img,wind));
                    }

                    weatherRVAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("WeatherAPIError", "API Request Error: " + error.getMessage(), error);
                Toast.makeText(MainActivity.this,"Please enter valid city name",Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}