package com.sample.fundus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class patientDetails extends AppCompatActivity {

    static final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        TextView display = findViewById(R.id.Display);

        try {
            FileInputStream fileInputStream = openFileInput("201209001.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1) {
                buffer.append((char) read);
            }
            Log.d("201209001", buffer.toString());
            String details = buffer.substring(0, buffer.indexOf(" "));
            display.setText(details);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}