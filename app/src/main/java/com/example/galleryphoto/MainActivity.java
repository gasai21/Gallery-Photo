package com.example.galleryphoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //----- set variable view
    RecyclerView recyclerView;

    //----- set variable data
    List<PhotoModel> data = new ArrayList<>();
    ListPhotoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.lv_content);
        getData();
    }

    //----- set connection
    private void getData(){
        data.clear();
        data.add(new PhotoModel("Kucing 1", "https://cdn.shopify.com/s/files/1/0235/1965/8061/files/British_short_hair_cat_russain_blue_amber_eyes_grande.jpeg?v=1572429896"));
        data.add(new PhotoModel("Kucing 2", "https://cdn.shopify.com/s/files/1/0997/4496/articles/Capture_600x.PNG?v=1536262439"));
        data.add(new PhotoModel("Kucing 3", "https://cdn.britannica.com/44/186844-131-B1D36671/Scottish-fold-cat.jpg"));
        data.add(new PhotoModel("Kucing 4", "https://cdn.shopify.com/s/files/1/0235/1965/8061/files/British_short_hair_cat_russain_blue_amber_eyes_grande.jpeg?v=1572429896"));
        setAdapter(data);
    }

    //----- set adapter
    private void setAdapter(final List<PhotoModel> data){
        adapter = new ListPhotoAdapter(data, this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);

        adapter.setClickItemPhoto(new ListPhotoAdapter.ClickItemPhoto() {
            @Override
            public void clickPhotoListener(PhotoModel model) {
                Intent i = new Intent(MainActivity.this, DetailPhotoActivity.class);
                i.putExtra("data", model);
                startActivity(i);
            }
        });
    }
}
