package com.example.msgandemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    EditText to,sub,msg;
    Button send,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        to = (EditText) findViewById(R.id.to);
        sub = (EditText) findViewById(R.id.sub);
        msg = (EditText) findViewById(R.id.msg);
        send = (Button) findViewById(R.id.emailsend);
        back = (Button) findViewById(R.id.back);

        String recipientEmail = to.getText().toString();
        String emailSubject = sub.getText().toString();
        String emailMessage = msg.getText().toString();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));//only email app should handle this
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{recipientEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT,emailSubject);
                intent.putExtra(Intent.EXTRA_TEXT,emailMessage);
                startActivity(Intent.createChooser(intent,"choose mail app: "));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(EmailActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}