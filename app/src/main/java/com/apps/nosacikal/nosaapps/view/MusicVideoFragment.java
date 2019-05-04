package com.apps.nosacikal.nosaapps.view;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.MusicModel;
import com.apps.nosacikal.nosaapps.presenter.MusicPresenter;
import com.apps.nosacikal.nosaapps.presenter.MusicPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/*
 * Rabu 24 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class MusicVideoFragment extends Fragment implements MusicView{

    private boolean isPlaying = false;

    private ImageView musicImage;
    private ImageView musicImage2;

    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;

    private ImageButton btnPlay;
    private ImageButton btnPlay2;

    private TextView musicTitle;
    private TextView musicTitle2;

    private TextView musicArtist;
    private TextView musicArtist2;
    private VideoView videoView;

    private List<MusicModel> musicList = new ArrayList<>();
    private MusicPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.music_video_fragment, container, false);

        musicImage = view.findViewById(R.id.music_img);
        musicImage2 = view.findViewById(R.id.music_img2);

        btnPlay = view.findViewById(R.id.play);
        btnPlay2 = view.findViewById(R.id.play2);

        musicTitle = view.findViewById(R.id.music_title);
        musicTitle2 = view.findViewById(R.id.music_title2);

        musicArtist = view.findViewById(R.id.music_artist);
        musicArtist2 = view.findViewById(R.id.music_artist2);

        MediaController mc= new MediaController(getActivity());
        videoView = view.findViewById(R.id.video);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video;
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(mc);
        mc.setAnchorView(videoView);


        presenter = new MusicPresenterImpl(this);

        presenter.load();
        return view;
    }

    @Override
    public void onLoad(List<MusicModel> song) {
        musicList.clear();
        musicList.addAll(song);

        musicImage.setImageResource(song.get(0).getImage());
        musicImage2.setImageResource(song.get(1).getImage());

        musicTitle.setText(song.get(0).getTitle());
        musicArtist.setText(song.get(0).getArtist());

        musicTitle2.setText(song.get(1).getTitle());
        musicArtist2.setText(song.get(1).getArtist());

        if (mediaPlayer == null && mediaPlayer2 == null) {
            mediaPlayer = MediaPlayer.create(this.getContext(), song.get(0).getMusic());
            mediaPlayer2 = MediaPlayer.create(this.getContext(), song.get(1).getMusic());
        }


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying == false) {
                    isPlaying = true;
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.ic_pause);
                } else {
                    if (mediaPlayer != null) {
                        isPlaying = false;
                        mediaPlayer.pause();
                        btnPlay.setImageResource(R.drawable.ic_play);
                    }
                }
            }
        });

        btnPlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying == false) {
                    isPlaying = true;
                    mediaPlayer2.start();
                    btnPlay2.setImageResource(R.drawable.ic_pause);
                } else {
                    if (mediaPlayer2 != null) {
                        isPlaying = false;
                        mediaPlayer2.pause();
                        btnPlay2.setImageResource(R.drawable.ic_play);
                    }
                }
            }
        });
    }
}
