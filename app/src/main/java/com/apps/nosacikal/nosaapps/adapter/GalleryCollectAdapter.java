package com.apps.nosacikal.nosaapps.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.GalleryCollectModel;
import com.apps.nosacikal.nosaapps.model.GalleryModel;

import java.util.List;


/*
 * Rabu 24 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class GalleryCollectAdapter extends RecyclerView.Adapter<GalleryCollectAdapter.ViewHolder> {

    private List<GalleryCollectModel> galleryList;
    private OnCallbackListener listener;

    public GalleryCollectAdapter(List<GalleryCollectModel> galleries) {
        this.galleryList = galleries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery_collect, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GalleryCollectModel gallery = galleryList.get(position);

        holder.textViewTitle.setText(gallery.getTitle());
        holder.textViewDesc.setText(gallery.getDesc());
        holder.imageViewGallery.setImageResource(gallery.getImage());
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }


    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewTitle;
        TextView textViewDesc;
        ImageView imageViewGallery;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewTitle = itemView.findViewById(R.id.gallery_collect_title);
            textViewDesc = itemView.findViewById(R.id.gallery_collect_desc);
            imageViewGallery = itemView.findViewById(R.id.gallery_collect_image);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(galleryList.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(GalleryCollectModel user);
    }
}

