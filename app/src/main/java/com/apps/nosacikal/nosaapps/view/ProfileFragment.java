package com.apps.nosacikal.nosaapps.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.HomeModel;
import com.apps.nosacikal.nosaapps.presenter.HomePresenter;
import com.apps.nosacikal.nosaapps.presenter.HomePresenterImpl;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/*
 * Kamis 25 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

public class ProfileFragment extends Fragment implements OnMapReadyCallback, HomeView {

    private ImageButton btnPhone;
    private ImageButton btnEmail;
    private ImageButton btnTwitter;
    private TextView nama;
    private TextView desc;
    private TextView kota;
    private Button btnDialog;

    private GoogleMap map;
    private MapView mapView;
    private View view;
    private AppCompatDialog dialog;

    private List<HomeModel> homeList = new ArrayList<>();
    private HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.profile_fragment, container, false);

        presenter = new HomePresenterImpl(this);

        btnPhone = view.findViewById(R.id.profile_phone);
        btnEmail = view.findViewById(R.id.profile_email);
        btnTwitter = view.findViewById(R.id.profile_twitter);
        nama = view.findViewById(R.id.profile_nama);
        desc = view.findViewById(R.id.profile_desc);
        kota = view.findViewById(R.id.profile_kota);
        btnDialog = view.findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:08995001549"));
                startActivity(phoneIntent);
                Animatoo.animateCard(getContext());
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "nosacikal@gmail.com";
                String[] e = email.split(",");
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, e);
                startActivity(Intent.createChooser(emailIntent, "Choose Email"));
                Animatoo.animateCard(getContext());
            }
        });

        btnTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/nosacikal"));
                startActivity(twitterIntent);
                Animatoo.animateCard(getContext());
            }
        });

        presenter.load();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) view.findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        map.addMarker(new MarkerOptions().position(new LatLng(-6.902373, 107.540071)).
                title("Rumah Saya").snippet("Jl Maharmarta negara no 131, Cimahi"));

        CameraPosition home = CameraPosition.builder().target(new LatLng(-6.902249, 107.540029)).zoom(16).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(home));
    }

    @Override
    public void onLoad(List<HomeModel> home) {
        homeList.clear();
        homeList.addAll(home);
        nama.setText(home.get(0).getNama());
        kota.setText(home.get(0).getKota());
        desc.setText(home.get(0).getDesc());
    }

    public void showDialog() {
        ImageView closeDialog;
        dialog = new AppCompatDialog(getContext());
        dialog.setContentView(R.layout.profile_dialog);

        closeDialog = dialog.findViewById(R.id.dialog_close);
        closeDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        if (!dialog.isShowing()) {
            dialog.show();
        }
    }
}
