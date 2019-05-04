package com.apps.nosacikal.nosaapps.view;

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

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.adapter.GalleryCollectAdapter;
import com.apps.nosacikal.nosaapps.adapter.GalleryRecyclerAdapter;
import com.apps.nosacikal.nosaapps.model.GalleryCollectModel;
import com.apps.nosacikal.nosaapps.model.GalleryModel;
import com.apps.nosacikal.nosaapps.presenter.GalleryCollectPresenterImpl;
import com.apps.nosacikal.nosaapps.presenter.GalleryPresenterImpl;

import java.util.ArrayList;
import java.util.List;

/*
 * Selasa 23 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class GalleryFragment extends Fragment implements GalleryView, GalleryCollectView {

    private RecyclerView recyclerView;
    private RecyclerView recyclerViewCollection;
    private GalleryRecyclerAdapter adapter;
    private GalleryCollectAdapter adapterCollection;
    private List<GalleryModel> galleryList = new ArrayList<>();
    private List<GalleryCollectModel> galleryCollectList = new ArrayList<>();
    private GalleryPresenterImpl presenter;
    private GalleryCollectPresenterImpl presenterCollect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gallery_fragment, container, false);

        presenter = new GalleryPresenterImpl(this);
        presenterCollect = new GalleryCollectPresenterImpl(this);

        recyclerView = view.findViewById(R.id.recycler_gallery);
        recyclerViewCollection = view.findViewById(R.id.recycler_gallery_collection);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));

        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 1, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewCollection.setLayoutManager(new LinearLayoutManager(this.getContext()));

        adapter = new GalleryRecyclerAdapter(galleryList);
        adapterCollection = new GalleryCollectAdapter(galleryCollectList);

        recyclerView.setAdapter(adapter);
        recyclerViewCollection.setAdapter(adapterCollection);

        presenter.load();
        presenterCollect.loadCollect();


        return view;
    }



    @Override
    public void onLoad(List<GalleryModel> gallery) {
        galleryList.clear();
        galleryList.addAll(gallery);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadCollect(List<GalleryCollectModel> galleryList) {
        galleryCollectList.clear();
        galleryCollectList.addAll(galleryList);

        adapterCollection.notifyDataSetChanged();
    }


}
