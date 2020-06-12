package com.example.mvvmproject.viewmodels;

import android.app.Application;

import androidx.room.Room;

import com.example.mvvmproject.dao.AppDatabase;
import com.example.mvvmproject.dao.DatabaseDaerah;
import com.example.mvvmproject.dao.MahasiswaDao;

public class MyApp extends Application {

    public static AppDatabase dbApp;
    public static DatabaseDaerah dbDaerah;

    @Override
    public void onCreate() {
        super.onCreate();

        dbApp = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();
        dbDaerah = Room.databaseBuilder(getApplicationContext(),DatabaseDaerah.class, "daerah").allowMainThreadQueries().build();
    }
}
