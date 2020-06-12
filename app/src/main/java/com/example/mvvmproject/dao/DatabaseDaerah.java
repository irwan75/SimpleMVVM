package com.example.mvvmproject.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mvvmproject.models.Daerah;
import com.example.mvvmproject.models.Mahasiswa;

@Database(entities = {Daerah.class}, version = 1)//export schema is not mandatory
public abstract class DatabaseDaerah extends RoomDatabase {
    public abstract DaerahDao daerahDao();
}
