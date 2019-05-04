package com.apps.nosacikal.nosaapps.presenter;

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.GalleryCollectModel;
import com.apps.nosacikal.nosaapps.model.GalleryModel;
import com.apps.nosacikal.nosaapps.view.GalleryCollectView;
import com.apps.nosacikal.nosaapps.view.GalleryView;

import java.util.ArrayList;
import java.util.List;

/*
 * Rabu 24 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class GalleryCollectPresenterImpl implements GalleryCollectPresenter {
    private GalleryCollectView galleryCollectView;
    private List<GalleryCollectModel> galleryList = new ArrayList<>();


    public GalleryCollectPresenterImpl(GalleryCollectView galleryCollectView) {
        this.galleryCollectView = galleryCollectView;
        setData();
    }

    private void setData() {
        GalleryCollectModel gallery = new GalleryCollectModel();
        gallery.setImage(R.drawable.gallery_5);
        gallery.setTitle("Pangandaran");
        gallery.setDesc("Selatan Jawa Barat");
        galleryList.add(gallery);

        GalleryCollectModel gallery2 = new GalleryCollectModel();
        gallery2.setImage(R.drawable.gallery_6);
        gallery2.setTitle("Si Jalak Harupat");
        gallery2.setDesc("Soreang Kab Bandung");
        galleryList.add(gallery2);

        GalleryCollectModel gallery3 = new GalleryCollectModel();
        gallery3.setImage(R.drawable.gallery_8);
        gallery3.setTitle("Burangrang");
        gallery3.setDesc("Ketinggian 2050 mdpl");
        galleryList.add(gallery3);

        GalleryCollectModel gallery4 = new GalleryCollectModel();
        gallery4.setImage(R.drawable.gallery_4);
        gallery4.setTitle("Pangandaran");
        gallery4.setDesc("Selatan Jawa Barat");
        galleryList.add(gallery4);
    }


    @Override
    public void loadCollect() {
        galleryCollectView.onLoadCollect(galleryList);
    }
}
