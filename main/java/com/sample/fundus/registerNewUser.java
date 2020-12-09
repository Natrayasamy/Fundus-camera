package com.sample.fundus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class registerNewUser extends AppCompatActivity {

    public EditText name;
    public EditText age;
    public EditText phone;
    public EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_user);

    }

    public void addNewUser(View view) {
        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        try {
            FileOutputStream fileout=openFileOutput("mrnumber.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write("Name :" + name.getText().toString() + "/n" +
                    "Age :" + age.getText().toString() + "/n" +
                    "Phone Number :" + phone.getText().toString() + "/n" +
                    "E-Mail :" + email.getText().toString() + "/n");
            outputWriter.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this,camera.class);
        startActivity(intent);

    }

}