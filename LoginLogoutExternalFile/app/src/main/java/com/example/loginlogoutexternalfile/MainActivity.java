package com.example.loginlogoutexternalfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText uname,pwd;
    Button button;
    FileOutputStream fos;
    Intent intent;
    private String filename="file.txt";
    private String folder="files";
    File externalFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=(EditText)findViewById(R.id.username);
        pwd=(EditText)findViewById(R.id.password);
        button=(Button) findViewById(R.id.loginbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = uname.getText().toString()+"\n";
                String password = pwd.getText().toString();

                try {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 23);

                    if (!Methods.isExternalStorageAvailable() || Methods.isExternalStorageReadOnly()) {
                        Toast.makeText(MainActivity.this, "External storage not available on the device..", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "External storage is available on the device..", Toast.LENGTH_SHORT).show();
                    }

                    externalFile = new File(getExternalFilesDir(folder), filename);

                    fos = new FileOutputStream(externalFile);
                    fos.write(username.getBytes());
                    fos.write(password.getBytes());
                    fos.close();

                    Toast.makeText(getApplicationContext(), "Details Saved in "+externalFile.getAbsolutePath(),Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, LogoutFile.class);
                    startActivity(intent);

                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}