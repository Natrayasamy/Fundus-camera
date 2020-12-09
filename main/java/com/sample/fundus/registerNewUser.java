package com.sample.fundus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class registerNewUser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_user);

    }

    public void addNewUser(View view) {
       EditText name=findViewById(R.id.name);
        EditText age=findViewById(R.id.age);
        EditText phone=findViewById(R.id.phone);
        EditText email=findViewById(R.id.email);
        File file= null;
        String Name = name.getText().toString() + "/n";
        String Age = age.getText().toString()+"/n";
        String Phone = phone.getText().toString()+"/n";
        String Email = email.getText().toString()+"/n";

        FileOutputStream fileOutputStream = null;
        try {
            Name = name + " ";
            file = getFilesDir();
            fileOutputStream = openFileOutput("201209001.txt", Context.MODE_PRIVATE); //MODE PRIVATE
            fileOutputStream.write(Name.getBytes());
            fileOutputStream.write(Age.getBytes());
            fileOutputStream.write(Phone.getBytes());
            fileOutputStream.write(Email.getBytes());
            Toast.makeText(this, "Successfully Saved \n" + "Path --" + file + "\tCode.txt", Toast.LENGTH_SHORT).show();
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(this,camera.class);
        startActivity(intent);

    }

}