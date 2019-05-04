package com.apps.nosacikal.nosaapps.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.adapter.DailyRecyclerAdapter;
import com.apps.nosacikal.nosaapps.adapter.FriendRecyclerAdapter;
import com.apps.nosacikal.nosaapps.model.DailyModel;
import com.apps.nosacikal.nosaapps.model.FriendModel;
import com.apps.nosacikal.nosaapps.presenter.DailyPresenterImpl;
import com.apps.nosacikal.nosaapps.presenter.FriendPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/*
 * Senin 29 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class DailyActivityFragment extends Fragment implements DailyView, FriendView{

    private RecyclerView recyclerDaily;
    private RecyclerView recyclerFriend;
    private DailyRecyclerAdapter dailyRecyclerAdapter;
    private FriendRecyclerAdapter friendRecyclerAdapter;
    private List<DailyModel> dailyList = new ArrayList<>();
    private List<FriendModel> friendList = new ArrayList<>();
    private DailyPresenterImpl dailypresenter;
    private FriendPresenterImpl friendPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.daily_fragment, container, false);

        dailypresenter = new DailyPresenterImpl(this);
        friendPresenter = new FriendPresenterImpl(this);

        recyclerDaily = view.findViewById(R.id.recycler_daily);
        recyclerFriend = view.findViewById(R.id.recycler_friend);

        recyclerDaily.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerFriend.setLayoutManager(new GridLayoutManager(this.getContext(), 1, LinearLayoutManager.HORIZONTAL, false));

        dailyRecyclerAdapter = new DailyRecyclerAdapter(dailyList);
        friendRecyclerAdapter = new FriendRecyclerAdapter(friendList);

        recyclerDaily.setAdapter(dailyRecyclerAdapter);
        recyclerFriend.setAdapter(friendRecyclerAdapter);

        dailypresenter.loadDaily();
        friendPresenter.loadFriend();

        return view;
    }


    @Override
    public void onLoadDaily(List<DailyModel> daily) {
        dailyList.clear();
        dailyList.addAll(daily);

        dailyRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFriend(List<FriendModel> friend) {
        friendList.clear();
        friendList.addAll(friend);

        friendRecyclerAdapter.notifyDataSetChanged();
    }
}
