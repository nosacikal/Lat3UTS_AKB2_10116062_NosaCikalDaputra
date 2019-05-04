package com.apps.nosacikal.nosaapps.presenter;


/*
 * Senin 29 April 2019
 * 10116062
 * Nosa Cikal Daputra
 * AKB-2
 * */

import com.apps.nosacikal.nosaapps.R;
import com.apps.nosacikal.nosaapps.model.DailyModel;
import com.apps.nosacikal.nosaapps.view.DailyView;

import java.util.ArrayList;
import java.util.List;

public class DailyPresenterImpl implements DailyPresenter {
    private DailyView dailyView;
    private List<DailyModel> dailyList = new ArrayList<>();

    public DailyPresenterImpl(DailyView dailyView) {
        this.dailyView = dailyView;
        setData();
    }

    public void setData() {
        DailyModel daily = new DailyModel();
        daily.setImage(R.drawable.daily_1);
        daily.setJam("04:30 AM");
        daily.setTitle("Bangun Tidur");
        daily.setDesc("Bangun Tidur, Menyiapkan Barang-Barang Keperluan Kampus");
        dailyList.add(daily);

        DailyModel daily2 = new DailyModel();
        daily2.setImage(R.drawable.daily_2);
        daily2.setJam("05:00 AM");
        daily2.setTitle("Mandi Pagi");
        daily2.setDesc("Mandi Pagi, Setelah Itu Sholat Shubuh");
        dailyList.add(daily2);

        DailyModel daily3 = new DailyModel();
        daily3.setImage(R.drawable.daily_3);
        daily3.setJam("05:30 AM");
        daily3.setTitle("Sarapan");
        daily3.setDesc("Sarapan, Setelah Sarapan lalu Bersiap-siap untuk ke kampus");
        dailyList.add(daily3);

        DailyModel daily4 = new DailyModel();
        daily4.setImage(R.drawable.daily_4);
        daily4.setJam("07:00 AM");
        daily4.setTitle("Kuliah");
        daily4.setDesc("Kuliah Setiap Hari Senin-Rabu dan Jumat");
        dailyList.add(daily4);

        DailyModel daily5 = new DailyModel();
        daily5.setImage(R.drawable.daily_5);
        daily5.setJam("12:00 PM");
        daily5.setTitle("Sholat Dzuhur");
        daily5.setDesc("Sholat Dzuhur, Setelah Itu Lanjut Kuliah");
        dailyList.add(daily5);

        DailyModel daily6 = new DailyModel();
        daily6.setImage(R.drawable.daily_6);
        daily6.setJam("3:15 PM");
        daily6.setTitle("Pulang");
        daily6.setDesc("Sebelum Pulang, Sholat Ashar");
        dailyList.add(daily6);

        DailyModel daily7 = new DailyModel();
        daily7.setImage(R.drawable.daily_5);
        daily7.setJam("06:00 PM");
        daily7.setTitle("Sholat Maghrib");
        daily7.setDesc("Sholat Maghrib, Setelah Itu Mengerjakan Tugas");
        dailyList.add(daily7);

        DailyModel daily8 = new DailyModel();
        daily8.setImage(R.drawable.daily_7);
        daily8.setJam("07:00 PM");
        daily8.setTitle("Makan Malam");
        daily8.setDesc("Makan Malam, Setelah Itu Sholat Isya");
        dailyList.add(daily8);

        DailyModel daily9 = new DailyModel();
        daily9.setImage(R.drawable.daily_8);
        daily9.setJam("10:00 PM");
        daily9.setTitle("Tidur");
        daily9.setDesc("Tidur Setelah Beraktivitas Seharian");
        dailyList.add(daily9);


    }

    @Override
    public void loadDaily() {
        dailyView.onLoadDaily(dailyList);
    }
}
