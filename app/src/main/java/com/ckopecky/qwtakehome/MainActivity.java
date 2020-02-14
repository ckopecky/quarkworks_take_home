package com.ckopecky.qwtakehome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import com.google.gson.Gson;

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

public class MainActivity extends AppCompatActivity implements  AlbumAdapter.OnPicListener {
    //instantiate variables to be used in file.
    private String myResponse;
    //This list extends from AlbumModel
    private final List<AlbumModel> albumList = new ArrayList<>();
    private AlbumAdapter albumAdapter;
    private int ranking;

    @Override
    //this is basically the equivalent of ComponentDidMount or the useEffect hook in React.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this sets our content view to the matching xml file below.
        setContentView(R.layout.activity_main);

        //utilize a Recycler View to output a list to the UI.
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //This is a custom adapter to allow for our results array to be passed to the recycler view.
        albumAdapter = new AlbumAdapter(albumList,  this);

        LinearLayoutManager albumLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(albumLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(albumAdapter);


        //this invokes our prep album data function below.
        prepareAlbumData();

    }
        private void prepareAlbumData() {

            //prepare network call using OkHttp

            OkHttpClient client = new OkHttpClient();

            String url = "https://rss.itunes.apple.com/api/v1/us/apple-music/top-albums/all/25/non-explicit.json";

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            //this actually makes the call
            client.newCall(request).enqueue(new Callback() {
                @Override
                //on failure it'll print a trace
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                // if there is a response it will hit this block of code.
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        //this is our response from the network call
                        myResponse = response.body().string();
                        //we use runOnUiThread to literally run on the UI thread. This is the logic for getting what we see on screen.
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    //pull the JSON Array from the response
                                    JSONArray jsonArray = new JSONObject(myResponse).getJSONObject("feed").getJSONArray("results");
                                    //loop through array and add JSON Album Object to albumsList. We use GSON to get the array to a type
                                    //that can be used here to loop through.
                                    Gson gson = new Gson();

                                    for(int i = 0; i < jsonArray.length(); i++) {
                                        String jsonAlbum;
                                        jsonAlbum = jsonArray.getString(i);
                                        final AlbumModel album = gson.fromJson(jsonAlbum, AlbumModel.class);
                                        ranking = i + 1;
                                        //I use the index to obtain a ranking so that we don't have just a bunch of objects floating on page. So that there is order
                                        String strRanking = Integer.toString(ranking);
                                        //add ranking to album instance
                                        album.setRanking(strRanking);
                                        //add album to our list that will be displayed.
                                        albumList.add(album);

                                    }
                                    //this is essentially a next() --> so we can go on to the next thing.
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

        public void onPicClick(int position) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("ALBUM_TITLE", albumList.get(position).getName());
            intent.putExtra("ARTIST_NAME", albumList.get(position).getArtistName());
            intent.putExtra("RELEASE_DATE", albumList.get(position).getReleaseDate());
            intent.putExtra("COPYRIGHT", albumList.get(position).getCopyright());
            intent.putExtra("URL", albumList.get(position).getUrl());
            intent.putExtra("ARTIST_URL", albumList.get(position).getArtistUrl());
            intent.putExtra("IMAGE", albumList.get(position).getArtworkUrl100());
            startActivity(intent);

        }
}

