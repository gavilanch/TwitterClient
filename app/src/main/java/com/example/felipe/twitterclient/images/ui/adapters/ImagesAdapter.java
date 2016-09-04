package com.example.felipe.twitterclient.images.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.felipe.twitterclient.R;
import com.example.felipe.twitterclient.entities.Image;
import com.example.felipe.twitterclient.lib.base.ImageLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Felipe on 04-Sep-16.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private List<Image> dateset;
    private ImageLoader imageLoader;
    private OnItemClickListener clickListener;

    public ImagesAdapter(List<Image> dateset, ImageLoader imageLoader, OnItemClickListener clickListener) {
        this.dateset = dateset;
        this.imageLoader = imageLoader;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_images, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Image imageTweet = dateset.get(position);
        holder.setOnClickListener(imageTweet, clickListener);
        holder.txtTweet.setText(imageTweet.getTweetText());
        imageLoader.load(holder.imgMedia, imageTweet.getImageURL());
    }

private void setItems(List<Image> newItems){
    dateset.addAll(newItems);
    notifyDataSetChanged();
}
    @Override
    public int getItemCount() {
        return dateset.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.txtTweet)
        TextView txtTweet;
        @Bind(R.id.imgMedia)
        ImageView imgMedia;

        private View view;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;
        }

        public void setOnClickListener(final Image image, final OnItemClickListener listener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(image);
                }
            });

        }
    }
}
