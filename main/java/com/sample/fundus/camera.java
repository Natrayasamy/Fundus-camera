package com.sample.fundus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class camera extends AppCompatActivity {

    private int CAMERA_RESULT;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    final static int CAMERA_OUTPUT = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ImageView image1=findViewById(R.id.image1);
    }
    public void startCamera (View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, CAMERA_RESULT);

    }
       public void onActivityResult(int requestCode,int resultCode, Intent intent) {
            super.onActivityResult(requestCode, resultCode, intent);

            if (resultCode == RESULT_OK)
            {
                Bundle extras = intent.getExtras();
                Bitmap bmp = (Bitmap) extras.get("data");
                image1.setImageBitmap(bmp);
            }
        }

        public void onClickSave(View view){
            File file= null;
            FileOutputStream fileOutputStream = null;
            file = getFilesDir();
            try {
                fileOutputStream = openFileOutput("201209001.txt", Context.MODE_APPEND);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

    }
}