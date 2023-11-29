package com.example.ses_1_que_2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,email,pass,repass;
    Button signup;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.inname);
        email=(EditText) findViewById(R.id.inemail);
        pass=(EditText) findViewById(R.id.inpass);
        repass=(EditText) findViewById(R.id.inrepass);
        signup=(Button) findViewById(R.id.button);

        pref=getSharedPreferences("user_detail",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getname = name.getText().toString();
                String getemail = email.getText().toString();
                String password = pass.getText().toString();
                String repeat_pass = repass.getText().toString();

                boolean isFieldsEmpty = getemail.isEmpty() || password.isEmpty() || repeat_pass.isEmpty();
                boolean isPasswordMatch = password.equals(repeat_pass);

                String errorMessage = isFieldsEmpty ? "Field/s are empty: " +
                        (getname.isEmpty() ? "name, " : "")+
                        (getemail.isEmpty() ? "Email, " : "") +
                        (password.isEmpty() ? "Password, " : "") +
                        (repeat_pass.isEmpty() ? "Repeat Password, " : "") : "";

                errorMessage += isFieldsEmpty && !isPasswordMatch ? "\n" : "";
                errorMessage += !isPasswordMatch ? "Passwords do not match" : "";

                if (isFieldsEmpty || !isPasswordMatch) {
                    Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                } else {
                    // Store credentials in SharedPreferences
                    editor.putString("email", getemail);
                    editor.putString("password", password);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}