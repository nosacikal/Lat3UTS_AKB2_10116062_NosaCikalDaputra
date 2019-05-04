package com.apps.nosacikal.nosaapps.presenter;

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.GalleryModel;
import com.apps.nosacikal.nosaapps.view.GalleryView;

import java.util.ArrayList;
import java.util.List;

/*
 * Selasa 23 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class GalleryPresenterImpl implements GalleryPresenter {
    private GalleryView galleryView;
    private List<GalleryModel> galleryList = new ArrayList<>();


    public GalleryPresenterImpl(GalleryView galleryView) {
        this.galleryView = galleryView;
        setData();
    }

    private void setData() {
        GalleryModel gallery = new GalleryModel();
        gallery.setImage(R.drawable.gallery_1);
        gallery.setTitle("Burangrang");
        gallery.setDesc("Ketinggian 2050 mdpl");
        galleryList.add(gallery);

        GalleryModel gallery2 = new GalleryModel();
        gallery2.setImage(R.drawable.gallery_2);
        gallery2.setTitle("Braga");
        gallery2.setDesc("Bandung Jawa Barat");
        galleryList.add(gallery2);

        GalleryModel gallery3 = new GalleryModel();
        gallery3.setImage(R.drawable.gallery_7);
        gallery3.setTitle("Hutan Pinus");
        gallery3.setDesc("Menuju Curug Layung");
        galleryList.add(gallery3);

        GalleryModel gallery4 = new GalleryModel();
        gallery4.setImage(R.drawable.gallery_3);
        gallery4.setTitle("Nosa Cikal");
        gallery4.setDesc("Kumpul Bareng");
        galleryList.add(gallery4);
    }

    @Override
    public void load() {
        galleryView.onLoad(galleryList);
    }

}
