package com.example.loginlogout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText uname,pwd;
    Button button;
    SharedPreferences pref;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //by default this page is visible to you
        uname=(EditText) findViewById(R.id.username);
        pwd=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.loginbutton);

        pref=getSharedPreferences("user_detail",MODE_PRIVATE);
        intent=new Intent(MainActivity.this,OutLog.class);

        if(pref.contains("username") && pref.contains("password")){
            startActivity(intent);
        }

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String username = uname.getText().toString();
                String password = pwd.getText().toString();

                if (username.equals("reeaa") && password.equals("reeaa")) {
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.commit();

                    Toast.makeText(getApplicationContext(), "Login Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Credentials are not valid",Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}