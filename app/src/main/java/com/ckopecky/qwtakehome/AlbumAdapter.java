package com.ckopecky.qwtakehome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
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



public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {
    private List<AlbumModel> albumList;
    private OnPicListener onPicListener;

    class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView artistName, name, ranking;
        ImageView imageView;
        String url;

        OnPicListener onPicListener;

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

    public interface  OnPicListener {
        void onPicClick(int position);
    }

    public AlbumAdapter(List<AlbumModel> albumList, OnPicListener onPicListener) {

        this.albumList = albumList;
        this.onPicListener = onPicListener;
    }
    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_listview, parent, false);
                return new MyViewHolder(itemView, onPicListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final AlbumModel album = albumList.get(position);
        //this is basically the equivalennt of the render method -- gives us a visual representation of our layout.
        holder.artistName.setText(album.getArtistName());
        holder.name.setText(album.getName());
        holder.ranking.setText(album.getRanking() + ".");
        String url = album.getArtworkUrl100();
        //use Picasso to render the image to the screen
        Picasso.get().load(url).resize(500, 500).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


}
