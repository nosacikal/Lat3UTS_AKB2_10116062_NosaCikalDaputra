package com.apps.nosacikal.nosaapps.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.DailyModel;

import java.util.List;


/*
 * Senin 29 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class DailyRecyclerAdapter extends RecyclerView.Adapter<DailyRecyclerAdapter.ViewHolder> {

    private List<DailyModel> dailyList;
    private OnCallbackListener listener;

    public DailyRecyclerAdapter(List<DailyModel> dailyList) {
        this.dailyList = dailyList;
    }

    @NonNull
    @Override
    public DailyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DailyModel daily = dailyList.get(position);

        holder.textViewJam.setText(daily.getJam());
        holder.textViewTitle.setText(daily.getTitle());
        holder.textViewDesc.setText(daily.getDesc());
        holder.imageViewDaily.setImageResource(daily.getImage());
    }

    @Override
    public int getItemCount() {
        return dailyList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewJam;
        TextView textViewTitle;
        TextView textViewDesc;
        ImageView imageViewDaily;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewJam = itemView.findViewById(R.id.daily_jam);
            textViewTitle = itemView.findViewById(R.id.daily_title);
            textViewDesc = itemView.findViewById(R.id.daily_desc);
            imageViewDaily = itemView.findViewById(R.id.daily_image);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(dailyList.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(DailyModel user);
    }


}
