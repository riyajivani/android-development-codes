package com.example.asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText takeTime;
    Button proceed;
    TextView goingOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proceed = (Button) findViewById(R.id.button);
        takeTime = (EditText) findViewById(R.id.input);
        goingOn = (TextView) findViewById(R.id.processedTV);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsynkTaskRunner runner = new MyAsynkTaskRunner();
                String sleeptime = takeTime.getText().toString();
                //noinspection deprecation
                runner.execute(sleeptime);
            }
        });
    }

    private class MyAsynkTaskRunner extends AsyncTask<String,String,String>
    {

        private String response;
        ProgressDialog progressDialog;

        @SuppressWarnings("deprecation")
        @Override
        protected void onPreExecute()
        {
            progressDialog = ProgressDialog.show(MainActivity.this,"progress dialouge ","wait for "+takeTime.getText().toString()+" seconds");
        }

        @SuppressWarnings("deprecation")
        @Override
        protected void onProgressUpdate(String... progress) {
            goingOn.setText(progress[0]);
        }

        @SuppressWarnings("deprecation")
        @Override
        protected String doInBackground(String... params) {
            publishProgress("sleeping...");

            try{
                int Time = Integer.parseInt(params[0]);
                for(int i=0;i<Time;i++)
                {
                    Thread.sleep(1000);
                    response = "slept for "+(i+1)+" of "+Time+" seconds";
                    publishProgress(response);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            return response;
        }
        @SuppressWarnings("deprecation")
        @Override
        protected void onPostExecute(String result)
        {
            progressDialog.dismiss();
            goingOn.setText(result);
        }

    }

}
