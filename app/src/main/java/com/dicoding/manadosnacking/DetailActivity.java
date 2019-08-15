package com.dicoding.manadosnacking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;


public class DetailActivity extends AppCompatActivity {
    ImageView imgReceived;
    TextView txtNameReceived,txtKetReceived;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        String receivedImg = getIntent().getStringExtra("IMAGES_KEY");
        String receivedName = getIntent().getStringExtra("TITLE_KEY");
        String receivedKet = getIntent().getStringExtra("ISI_KEY");

        txtNameReceived = findViewById(R.id.tv_detail_kuliner);
        txtNameReceived.setText(receivedName);
        txtKetReceived = findViewById(R.id.tv_detail_keterangan);
        txtKetReceived.setText(receivedKet);
        imgReceived = findViewById(R.id.iv_detail_kuliner);

        /*txtNameReceived.setText(receivedName);
        txtKetReceived.setText(receivedKet);
        imgReceived.setImageURI(Uri.parse(receivedImg));
        */
        Glide.with(this)
                .asBitmap()
                .load(receivedImg)
                .into(imgReceived);







    }

}
