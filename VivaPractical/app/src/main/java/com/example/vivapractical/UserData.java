package com.example.vivapractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserData extends AppCompatActivity {

    FileInputStream fis;
    Button logout;
    TextView userdetail;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

         userdetail=(TextView) findViewById(R.id.uname);
         logout=(Button) findViewById(R.id.logout);

        try {
            fis=openFileInput("vivademo");
            StringBuffer sb=new StringBuffer();
            int i;

            while ((i=fis.read())!=-1)
            {
                sb.append((char)i);
            }

            fis.close();

            String detail[]=sb.toString().split("\n");

            userdetail.setText("USERNAME: "+detail[0]+"\nUSERCITY: "+detail[1]);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(UserData.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}