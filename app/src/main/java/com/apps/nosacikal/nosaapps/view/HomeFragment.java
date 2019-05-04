package com.apps.nosacikal.nosaapps.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.HomeModel;
import com.apps.nosacikal.nosaapps.presenter.HomePresenter;
import com.apps.nosacikal.nosaapps.presenter.HomePresenterImpl;

import java.util.ArrayList;
import java.util.List;

/*
 * Selasa 23 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class HomeFragment extends Fragment implements HomeView{

    private List<HomeModel> homeList = new ArrayList<>();
    private HomePresenter presenter;
    private TextView textViewNama;
    private TextView textViewKota;
    private TextView textViewDesc;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        presenter = new HomePresenterImpl(this);
        textViewNama = view.findViewById(R.id.home_nama);
        textViewKota = view.findViewById(R.id.home_kota);
        textViewDesc = view.findViewById(R.id.home_desc);
        imageView = view.findViewById(R.id.image);

        presenter.load();

        return view;
    }

    @Override
    public void onLoad(List<HomeModel> home) {
        homeList.clear();
        homeList.addAll(home);
        imageView.setImageResource(home.get(0).getGambar());
        textViewNama.setText(home.get(0).getNama());
        textViewKota.setText(home.get(0).getKota());
        textViewDesc.setText(home.get(0).getDesc());
    }
}
