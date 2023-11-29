package com.example.loginlogoutfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    EditText uname,pwd;
    Button button;
    FileOutputStream fos;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=(EditText)findViewById(R.id.username);
        pwd=(EditText)findViewById(R.id.password);
        button=(Button) findViewById(R.id.loginbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = uname.getText().toString()+"\n";
                String password = pwd.getText().toString();

                try {
                    fos=openFileOutput("demo",MODE_PRIVATE);
                    fos.write(username.getBytes());
                    fos.write(password.getBytes());
                    fos.close();

                    Toast.makeText(getApplicationContext(), "Detail saved Successfully",Toast.LENGTH_SHORT).show();
                    intent=new Intent(MainActivity.this,Logout.class);
                    startActivity(intent);

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
    }
}