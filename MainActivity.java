package com.example.bulbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CameraManager cameraManager;
    private String cameraID;

    ImageButton on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        on = (ImageButton) findViewById(R.id.btnon);


        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{

            cameraID = cameraManager.getCameraIdList()[0];

        }catch(Exception e){
            e.printStackTrace();

        }



    }

    public void turnOnLight(View view) {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraID, true);
                Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.lightoff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }





    }


    public void turnOffLight(View view) {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode(cameraID, false);
                Toast.makeText(this, "OFF", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_main);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}