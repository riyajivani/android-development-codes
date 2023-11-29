package com.example.loginlogoutexternalfile;

import static com.example.loginlogoutexternalfile.R.id.username;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LogoutFile extends AppCompatActivity {

    FileInputStream fis;
    private String filename = "file.txt";
    private String folder = "files";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_file);

        TextView result=(TextView) findViewById(R.id.logouttext);
        Button back=(Button) findViewById(R.id.logoutbutton);

        try {
            File myFile = new File(getExternalFilesDir(folder), filename);
            fis = new FileInputStream(myFile);
            StringBuffer sbuffer = new StringBuffer();
            int i;

            while ((i = fis.read())!= -1){
                sbuffer.append((char)i);
            }

            fis.close();

            String details[] = sbuffer.toString().split("\n");

            result.setText("Name: "+ details[0]+"\nPassword: "+details[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(LogoutFile.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}