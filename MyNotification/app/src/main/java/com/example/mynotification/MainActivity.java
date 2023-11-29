package com.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String CHANNEL_ID="notification_channel";
    public static final int NOTIFICATION_ID=1;
    EditText editTextMessage;
    Button buttonToSendNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage =(EditText) findViewById(R.id.enter_notification);
        buttonToSendNotification = (Button) findViewById(R.id.button);

        buttonToSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editTextMessage.getText().toString();
                sendNotification(message);
            }
        });
    }

    private void sendNotification(String message)
    {
        createMyNotificationChannel();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message",message); //put our edittext message in intent
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        //Intent.FLAG_ACTIVITY_NEW_TASK: This flag is typically used when you want to start a new task (a new instance of the activity) even if the activity already exists in the current task. It's commonly used when you want to launch an activity from outside of an existing task.

        //FLAG_ACTIVITY_CLEAR_TASK: This flag is used to clear the current task (remove all activities from the stack) before starting the new activity. This is often used when you want to start a new task and remove any existing activities in the back stack.

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_MUTABLE);

        Notification.Builder builder = new Notification.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Notification demo")
                .setContentText(message)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true); //dismiss on touch

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.notify(NOTIFICATION_ID,builder.build()); // for this you have to add permission of post notification in menifest file.

    }

    private void createMyNotificationChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)    //o is for oreo which is name of version 8
        {
            CharSequence channelname="Message channel";
            String channnelDiscription="this is message channel";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;  //set priority

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,channelname,importance);

            notificationChannel.enableVibration(false);
            notificationChannel.setDescription(channnelDiscription);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}