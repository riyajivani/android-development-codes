package com.example.sneakbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a Snackbar when you click button
                Snackbar snk = Snackbar.make(button,"Deleted",Snackbar.LENGTH_LONG);

                snk.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Code to execute when the action is clicked
                        // ex. you can undo an action

                        Toast.makeText(MainActivity.this,"action performed",Toast.LENGTH_SHORT).show();

                        //snk.dismiss(); --> Dismiss the Snackbar
                    }
                });

                snk.show();

                // Allow the Snackbar to be dismissed by swiping or displaying a new Snackbar
//                snk.addCallback(new Snackbar.Callback() {
//                    @Override
//                    public void onDismissed(Snackbar snackbar, int event) {
//                        if (event == Snackbar.Callback.DISMISS_EVENT_SWIPE || event == Snackbar.Callback.DISMISS_EVENT_ACTION) {
//                            // Snackbar was dismissed by swiping or clicking the action
//                            // You can display a new Snackbar here if needed
//                            //showNewSnackbar();
//                            snk.dismiss();
//                        }
//                    }
//                });

            }
        });
    }

//    private void showNewSnackbar() {
//        // Create and show a new Snackbar
//        Snackbar.make(button, "New Snackbar", Snackbar.LENGTH_SHORT).show();
//    }
}