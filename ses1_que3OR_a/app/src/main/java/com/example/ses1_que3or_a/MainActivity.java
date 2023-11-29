package com.example.ses1_que3or_a;

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

public class MainActivity extends AppCompatActivity {

    EditText name,email,skill;
    Button submit;
    FileOutputStream fos;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.nameET);
        email=(EditText) findViewById(R.id.emailET);
        skill=(EditText) findViewById(R.id.skillET);
        submit=(Button) findViewById(R.id.submitB);

    submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namein=name.getText().toString()+"\n";
                String emailin=email.getText().toString()+"\n";
                String skillin=skill.getText().toString();

                try {
                    fos=openFileOutput("demo1",MODE_PRIVATE);
                    fos.write(namein.getBytes());
                    fos.write(emailin.getBytes());
                    fos.write(skillin.getBytes());
                    fos.close();

                    Toast.makeText(getApplicationContext(), "Detail saved Successfully",Toast.LENGTH_SHORT).show();
                    intent=new Intent(MainActivity.this,details.class);
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