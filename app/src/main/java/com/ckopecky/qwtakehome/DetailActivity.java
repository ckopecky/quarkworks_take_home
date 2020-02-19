package com.ckopecky.qwtakehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.Serializable;

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

        //saving into a quick disc cache.
        AlbumModel album = (AlbumModel) getIntent().getSerializableExtra("ALBUM");


        artist_name.setText(album.getArtistName());
        album_title.setText(album.getName());
        release_date.setText(album.getReleaseDate());
        detail_copyright.setText(album.getCopyright());
        Picasso.get().load(album.getArtworkUrl100()).resize(1000,1000).into(album_image);
        setTitle(album.getName() + " - " + album.getArtistName());


    }
}
