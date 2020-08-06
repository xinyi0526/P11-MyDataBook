package com.myapplicationdev.android.p12_mydatabook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AboutUsActivity extends AppCompatActivity {

    TextView tvAbout,tvAuthor;
    ImageView iv;
    Boolean success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tvAbout = findViewById(R.id.tvAbout);
        tvAuthor = findViewById(R.id.tvAuthor);
        iv = findViewById(R.id.ivAbout);

        tvAuthor.setText("Created by : Ah Chong, Peter, Mary");
        String url = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.with(this).load(url).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(iv);

        tvAbout.setText("C347 Android Programming || \n Republic Polytechnic");
    }
}
