package com.example.loginlogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OutLog extends AppCompatActivity {

    TextView result;
    Button logoutbutton;
    SharedPreferences prf;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_log);

        result=(TextView)findViewById(R.id.logouttext);
        logoutbutton=(Button)findViewById(R.id.logoutbutton);

        prf=getSharedPreferences("user_detail",MODE_PRIVATE);
        intent=new Intent(OutLog.this,MainActivity.class);

        result.setText("Hello,"+prf.getString("username",null));

        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=prf.edit();
                editor.clear();
                editor.commit();
                startActivity(intent);
            }
        });
    }
}