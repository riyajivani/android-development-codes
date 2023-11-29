package com.example.exam_constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView person1, person2,name1,name2;
    Button button1, button2;
    static  int count = 0;
    static int count1 = 0;
    StoreVote store,store1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person1 = (TextView) findViewById(R.id.vote1);
        person2 = (TextView) findViewById(R.id.vote2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        name1 = (TextView) findViewById(R.id.textview1);
        name2 = (TextView) findViewById(R.id.textview2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count + 1;
                String vote = Integer.toString(count);
                person1.setText(vote);
                Toast.makeText(getApplicationContext(), "candidate 1 received the vote", Toast.LENGTH_SHORT).show();
                store = new StoreVote(name1.getText().toString(),count);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1 = count1 + 1;
                String vote1 = Integer.toString(count1);
                person2.setText(vote1);
                Toast.makeText(getApplicationContext(), "candidate 2 received the vote", Toast.LENGTH_SHORT).show();
                store1 = new StoreVote(name2.getText().toString(),count1);
            }
        });
    }


}