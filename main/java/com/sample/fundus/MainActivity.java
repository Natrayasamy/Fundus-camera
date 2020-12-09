package com.sample.fundus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public EditText mrnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mrnumber=findViewById(R.id.mr_number);
    }
    public void details(View view){
        Button next=findViewById(R.id.next);

    }
    public void newUser(View view){
        Button new_user=findViewById(R.id.new_user);
        Intent intent=new Intent(this,registerNewUser.class);
        startActivity(intent);

    }
}