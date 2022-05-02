










package com.ui.projectdatestracture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.media.MediaPlayer;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity  {

    Button btn_login;
    View v;
    private final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoActivity = new Intent(MainActivity.this, activity_2.class);
                startActivity(GoActivity);
            }
        });

        MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.music_1);
        player.setLooping(true); // Set looping
        player.setVolume(100, 100);


        if (ContextCompat.checkSelfPermission(MainActivity.this, READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestREAD_EXTERNAL_STORAGEPermission();
        } else {
            Toast.makeText(MainActivity.this, "مجوز قبلا دریافت شده", Toast.LENGTH_SHORT).show();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        player.start();
    }

    private void requestREAD_EXTERNAL_STORAGEPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("درخواست مجوز")
                    .setMessage("برای دسترسی به فایل ها باید مجوز را تایید کنید")
                    .setPositiveButton("موافقم", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            reqPermission();
                        }
                    })
                    .setNegativeButton("لغو", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    })
                    .create()
                    .show();
        } else {
            reqPermission();
        }
    }

    private void reqPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == READ_EXTERNAL_STORAGE_REQUEST_CODE) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "مجوز تایید شد", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "مجوز رد شد", Toast.LENGTH_SHORT).show();

            }

        }

    }
}
