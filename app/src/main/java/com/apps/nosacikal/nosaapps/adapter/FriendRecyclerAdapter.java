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
import com.apps.nosacikal.nosaapps.model.FriendModel;

import java.util.List;


/*
 * Senin 29 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class FriendRecyclerAdapter extends RecyclerView.Adapter<FriendRecyclerAdapter.ViewHolder> {

    private List<FriendModel> friendList;
    private OnCallbackListener listener;

    public FriendRecyclerAdapter(List<FriendModel> friendList) {
        this.friendList = friendList;
    }

    @NonNull
    @Override
    public FriendRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FriendModel friend = friendList.get(position);

        holder.textViewTitle.setText(friend.getTitle());
        holder.imageViewDaily.setImageResource(friend.getImage());
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewTitle;
        ImageView imageViewDaily;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewTitle = itemView.findViewById(R.id.friend_title);
            imageViewDaily = itemView.findViewById(R.id.friend_image);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(friendList.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(FriendModel user);
    }


}
