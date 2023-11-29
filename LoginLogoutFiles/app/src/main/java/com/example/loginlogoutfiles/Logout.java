package com.example.loginlogoutfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Logout extends AppCompatActivity {

    FileInputStream fis;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout2);

        TextView result=(TextView) findViewById(R.id.logouttext);
        Button back=(Button) findViewById(R.id.logoutbutton);

        try {
            fis=openFileInput("demo");
            StringBuffer sb=new StringBuffer();
            int i;

            while ((i=fis.read())!=-1)
            {
                sb.append((char)i);
            }

            fis.close();

            String detail[]=sb.toString().split("\n");

            result.setText("NAME: "+detail[0]+"\nPASSWORD: "+detail[1]);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Logout.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}






