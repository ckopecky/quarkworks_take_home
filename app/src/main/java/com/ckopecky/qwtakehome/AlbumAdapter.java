package com.ckopecky.qwtakehome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;


//basic adapter that extends from RecyclerView.Adapter. We need to specify the custom viewholder which gives
// us access to our views.

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {

    //member var for albumList

    private List<AlbumModel> albumList;
    private OnPicListener onPicListener;

    //this provides a reference to each of the views with a album instance.
    class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        //this is the info we will use on the entire list
        TextView artistName, name, ranking;
        ImageView imageView;
        String url;
        //OnPicListener contains the intent that will pass the info needed to the detailActivity so that
        //we can use it on the detailed view of the indiv item.
        OnPicListener onPicListener;

        //this is a constructor that will accept the entire item row and does view lookups to find each subview

        public MyViewHolder(@NonNull View view, OnPicListener onPicListener) {

            super(view);
            ranking = view.findViewById(R.id.ranking);
            artistName = view.findViewById(R.id.artist_name);
            name = view.findViewById(R.id.name);
            imageView = (ImageView) view.findViewById(R.id.album_image_url);
            this.onPicListener = onPicListener;

            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onPicListener.onPicClick(getAdapterPosition());
        }
    }

    //deferring responsibility to MainActivity
    public interface  OnPicListener {
        void onPicClick(int position);
    }

    //pass in the member var albumList that we instantiated above to the AlbumAdapter constructor
    public AlbumAdapter(List<AlbumModel> albumList, OnPicListener onPicListener) {

        this.albumList = albumList;
        this.onPicListener = onPicListener;
    }
    @NonNull
    @Override

    //inflates item layout and creates the holder
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the custom layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_listview, parent, false);
                // return a new holder instance
                Log.i("Run!", "Adapter run!");
                return new MyViewHolder(itemView, onPicListener);
    }

    // populates data into the item through the holder
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //get data model based on position
        final AlbumModel album = albumList.get(position);
        //assigns info to the given position
        holder.artistName.setText(album.getArtistName());
        holder.name.setText(album.getName());
        holder.ranking.setText(album.getRanking() + ".");
        String url = album.getArtworkUrl100();
        //use Picasso to render the image to the screen
        Picasso.get().load(url).resize(700, 700).into(holder.imageView);
        Log.i("Run!", "Bind run!");

    }

    //returns the total count of items in the list.
    @Override
    public int getItemCount() {
        return albumList.size();
    }


}
