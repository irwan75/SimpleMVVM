package com.example.mvvmproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mvvmproject.models.Daerah;
import com.example.mvvmproject.models.Mahasiswa;

import java.util.List;

@Dao
public interface DaerahDao {

    @Query("SELECT * FROM daerah")
    List<Daerah> getAll();

    //Example Custum Query
//    @Query("SELECT * FROM daerah WHERE provinsi LIKE :provinsi ")
//    Daerah findByName(String provinsi);

    @Insert
    void insertAll(Daerah... daerah);

//    @Delete
//    public void deleteUsers(Daerah... daerah);

}
