package com.example.vivapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText name,city;
    Button submit;
    FileOutputStream fos;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.etuname);
        city=(EditText) findViewById(R.id.etucity);
        submit=(Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = name.getText().toString()+"\n";
                String usercity = city.getText().toString();

                try {
                    fos=openFileOutput("vivademo",MODE_PRIVATE);
                    fos.write(username.getBytes());
                    fos.write(usercity.getBytes());
                    fos.close();

                    Toast.makeText(getApplicationContext(), "User Detail saved Successfully",Toast.LENGTH_SHORT).show();
                    intent=new Intent(MainActivity.this,UserData.class);
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