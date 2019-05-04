package com.apps.nosacikal.nosaapps.presenter;

/*
 * Rabu 24 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.MusicModel;
import com.apps.nosacikal.nosaapps.view.MusicView;

import java.util.ArrayList;
import java.util.List;

public class MusicPresenterImpl implements MusicPresenter{

    private MusicView musicView;
    private List<MusicModel> songs = new ArrayList<>();

    public MusicPresenterImpl(MusicView musicView) {
        this.musicView = musicView;
        setData();
    }

    private void setData() {
        MusicModel song = new MusicModel();
        song.setMusic(R.raw.song);
        song.setImage(R.drawable.music);
        song.setTitle("Morning In Japan");
        song.setArtist("Fakear");
        songs.add(song);

        MusicModel song2 = new MusicModel();
        song2.setMusic(R.raw.song2);
        song2.setImage(R.drawable.music2);
        song2.setTitle("Santeria");
        song2.setArtist("Sublime");
        songs.add(song2);
    }


    @Override
    public void load() {
        musicView.onLoad(songs);
    }

}
