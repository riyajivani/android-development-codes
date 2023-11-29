package com.example.msgandemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MsgActivity extends AppCompatActivity {

    EditText contact,msg;
    Button send,back;
    String phoneNo,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);

        contact = (EditText) findViewById(R.id.contact);
        msg = (EditText) findViewById(R.id.msg);
        send = (Button) findViewById(R.id.msgsend);
        back = (Button) findViewById(R.id.back);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms to: "));
                intent.setType("vnd.android-dir/mms-sms");
                intent.putExtra("contact",new String[]{contact.getText().toString()});
                intent.putExtra("msg",new String[]{msg.getText().toString()});
                startActivity(Intent.createChooser(intent,"send sms via: "));
//                phoneNo = contact.getText().toString();
//                message = msg.getText().toString();
//                SmsManager smsManager = SmsManager.getDefault();
//                smsManager.sendTextMessage(phoneNo, null, message, null, null);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MsgActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}