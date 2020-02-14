package com.ckopecky.qwtakehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        TextView artist_name = findViewById(R.id.detail_artist_name);
        TextView album_title = findViewById(R.id.detail_album_name);
        TextView release_date = findViewById(R.id.detail_release_date);
        TextView detail_copyright = findViewById(R.id.detail_copyright);
        ImageView album_image = findViewById(R.id.detail_album_image_url);
        //get Intent

        Intent startIntent = getIntent();
        String albumImage = startIntent.getStringExtra("IMAGE");
        String artistName = startIntent.getStringExtra("ARTIST_NAME");
        String albumTitle = startIntent.getStringExtra("ALBUM_TITLE");
        String releaseDate = startIntent.getStringExtra("RELEASE_DATE");
        String copyright = startIntent.getStringExtra("COPYRIGHT");

        artist_name.setText(artistName);
        Log.d("albumtitle", " is it null? " + albumTitle);
        album_title.setText(albumTitle);
        release_date.setText(releaseDate);
        detail_copyright.setText(copyright);
        Picasso.get().load(albumImage).resize(1000,1000).into(album_image);

    }
}
