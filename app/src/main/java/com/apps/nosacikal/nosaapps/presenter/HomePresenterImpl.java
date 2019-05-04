package com.apps.nosacikal.nosaapps.presenter;

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.HomeModel;
import com.apps.nosacikal.nosaapps.view.HomeView;

import java.util.ArrayList;
import java.util.List;

/*
 * Selasa 23 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class HomePresenterImpl implements HomePresenter{

    private HomeView homeView;
    private List<HomeModel> homeList = new ArrayList<>();


    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        setData();
    }

    private void setData() {
        HomeModel home = new HomeModel();
        home.setGambar(R.drawable.profile);
        home.setNama("Nosa Cikal Daputra");
        home.setKota("Cimahi, ID");
//        home.setDesc("watching football and design. Fried rice and Coffee. Interested in casual dress. Become a designer. Get in touch: nosacikal@gmail.com");
        home.setDesc("Anak Pertama dari 2 Bersaudara. Suka nonton bola dan desain. Suka Nasi Goreng dan Kopi. Tertarik kepada Persib Bandung dan Photoshop. Menjadi Desainer. Lebih Dekat : nosacikal@gmail.com");
        homeList.add(home);
    }

    @Override
    public void load() {
        homeView.onLoad(homeList);
    }
}
