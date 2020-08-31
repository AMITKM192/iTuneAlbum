package com.learntodroid.mvvmrestapi.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learntodroid.mvvmrestapi.R;
import com.learntodroid.mvvmrestapi.models.AlbumResponse;

import java.util.ArrayList;
import java.util.List;

public class AlbumSearchResultsAdapter extends RecyclerView.Adapter<AlbumSearchResultsAdapter.AlbumSearchResultHolder> {
    private List<AlbumResponse.Result> results = new ArrayList<>();

    @NonNull
    @Override
    public AlbumSearchResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        return new AlbumSearchResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumSearchResultHolder holder, int position) {
        AlbumResponse.Result album = results.get(position);

        holder.txt_artist_name.setText(album.getArtistName());
        holder.txt_collection_name.setText(album.getCollectionName());

      /*  if (volume.getVolumeInfo().getImageLinks() != null) {
            String imageUrl = volume.getVolumeInfo().getImageLinks().getSmallThumbnail()
                    .replace("http://", "https://");

            Glide.with(holder.itemView)
                    .load(imageUrl)
                    .into(holder.img_album);
        }*/

        holder.txt_artist_name.setText(album.getCollectionPrice() + "");
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setResults(List<AlbumResponse.Result> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    class AlbumSearchResultHolder extends RecyclerView.ViewHolder {
        private TextView txt_artist_name;
        private TextView txt_collection_name;
        private TextView txt_collection_price;
        private ImageView img_album;

        public AlbumSearchResultHolder(@NonNull View itemView) {
            super(itemView);

            txt_artist_name = itemView.findViewById(R.id.txt_artist_name);
            txt_collection_name = itemView.findViewById(R.id.txt_collection_name);
            txt_collection_price = itemView.findViewById(R.id.txt_collection_price);
            img_album = itemView.findViewById(R.id.img_album);
        }
    }
}