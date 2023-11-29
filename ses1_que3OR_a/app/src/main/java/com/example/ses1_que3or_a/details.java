package com.example.ses1_que3or_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class details extends AppCompatActivity {

    TextView result;
    Button reset;
    FileInputStream fis;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        result=(TextView)findViewById(R.id.result);

        reset=(Button) findViewById(R.id.resetB);

        try {
            fis=openFileInput("demo1");
            StringBuffer sb=new StringBuffer();
            int i;

            while ((i=fis.read())!=-1)
            {
                sb.append((char)i);
            }

            fis.close();

            String detail[]=sb.toString().split("\n");

            result.setText("NAME: "+detail[0]+"\nEMAIL: "+detail[1]+"\nSKILL: "+detail[2]);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(details.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}