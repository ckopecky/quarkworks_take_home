package com.ckopecky.qwtakehome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;



public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {
    private List<AlbumModel> albumList;
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView artistName, name, ranking;
        ImageView imageView;
        String url;
        MyViewHolder(View view) {
            super(view);
            ranking = view.findViewById(R.id.ranking);
            artistName = view.findViewById(R.id.artist_name);
            name = view.findViewById(R.id.name);
            imageView = (ImageView) view.findViewById(R.id.album_image_url);
        }
    }

    public AlbumAdapter(List<AlbumModel> albumList) {
        this.albumList = albumList;
    }
    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_listview, parent, false);
                return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AlbumModel album = albumList.get(position);
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
