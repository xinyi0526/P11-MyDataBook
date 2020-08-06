package com.myapplicationdev.android.p12_mydatabook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    TextView tvAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tvAbout = findViewById(R.id.tvAbout);

        tvAbout.setText("C347 Android Programming || \n Republic Polytechnic");
    }
}
