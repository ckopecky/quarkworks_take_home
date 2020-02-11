package com.ckopecky.qwtakehome;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private String myResponse;
    private String image_url;
    private ImageView imgView;
    private View view;
    private List<AlbumModel> albumList = new ArrayList<>();
    private AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        albumAdapter = new AlbumAdapter(albumList);

        LinearLayoutManager albumLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(albumLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(albumAdapter);
        prepareAlbumData();
    }



        private void prepareAlbumData() {
            OkHttpClient client = new OkHttpClient();
            String url = "https://rss.itunes.apple.com/api/v1/us/apple-music/top-albums/all/25/non-explicit.json";
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        myResponse = response.body().string();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONArray jsonArray = new JSONObject(myResponse).getJSONObject("feed").getJSONArray("results");
                                    //loop through array and add JSON Album Object to albumsList.
                                    Gson gson = new Gson();

                                    for(int i = 0; i < jsonArray.length(); i++) {
                                        String jsonAlbum;
                                        jsonAlbum = jsonArray.getString(i);
                                        AlbumModel album = gson.fromJson(jsonAlbum, AlbumModel.class);
                                        albumList.add(album);
                                        image_url = album.getArtworkUrl100();

                                    }
                                    Log.d("albumList", albumList.toString());
                                    albumAdapter.notifyDataSetChanged();

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                    }
                }
            });
        }
}

