package com.example.mvvmproject.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mvvmproject.models.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 1)//export schema is not mandatory
public abstract class AppDatabase extends RoomDatabase {
    public abstract MahasiswaDao userDao();
}
