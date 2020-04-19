package com.example.galleryphoto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailPhotoActivity extends AppCompatActivity {

    //----- set variable view
    ImageView img;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_photo);
        img = findViewById(R.id.img);
        txtTitle = findViewById(R.id.txtTitle);

        //----- get data
        PhotoModel data = getIntent().getParcelableExtra("data");
        Glide.with(this)
                .load(data.url_img)
                .into(img);
        txtTitle.setText(data.title);
    }
}
