package com.example.thirdexp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
     EditText uname,pwd;
     Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //by default this page is visible to you
        uname=(EditText) findViewById(R.id.username);
        pwd=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.loginbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=uname.getText().toString();
                String password=pwd.getText().toString();

                if(username.equals("riya") && password.equals("riya"))
                {
                    Toast toast=Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 10, 20);
                    toast.show();
                }
                else {
                    Toast toast=Toast.makeText(MainActivity.this,"credential not valid",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();
                }
            }
        }

    );
    }
}