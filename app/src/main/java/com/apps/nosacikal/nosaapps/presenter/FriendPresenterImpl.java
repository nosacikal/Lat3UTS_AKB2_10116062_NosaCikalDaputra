package com.apps.nosacikal.nosaapps.presenter;


/*
 * Senin 29 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.FriendModel;
import com.apps.nosacikal.nosaapps.view.FriendView;

import java.util.ArrayList;
import java.util.List;

public class FriendPresenterImpl implements FriendPresenter {
    private FriendView friendView;
    private List<FriendModel> friendList = new ArrayList<>();

    public FriendPresenterImpl(FriendView friendView) {
        this.friendView = friendView;
        setData();
    }

    public void setData() {
        FriendModel friend = new FriendModel();
        friend.setImage(R.drawable.friend_1);
        friend.setTitle("Andhika C");
        friendList.add(friend);

        FriendModel friend2 = new FriendModel();
        friend2.setImage(R.drawable.friend_2);
        friend2.setTitle("A. Sidiik");
        friendList.add(friend2);

        FriendModel friend3 = new FriendModel();
        friend3.setImage(R.drawable.friend_3);
        friend3.setTitle("Riyadi");
        friendList.add(friend3);

        FriendModel friend4 = new FriendModel();
        friend4.setImage(R.drawable.friend_4);
        friend4.setTitle("Imam S");
        friendList.add(friend4);

        FriendModel friend5 = new FriendModel();
        friend5.setImage(R.drawable.friend_5);
        friend5.setTitle("Fritson");
        friendList.add(friend5);

        FriendModel friend6 = new FriendModel();
        friend6.setImage(R.drawable.friend_6);
        friend6.setTitle("Sutantio");
        friendList.add(friend6);

    }

    @Override
    public void loadFriend() {
        friendView.onLoadFriend(friendList);
    }
}
