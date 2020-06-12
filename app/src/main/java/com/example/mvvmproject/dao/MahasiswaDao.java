package com.example.mvvmproject.dao;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomDatabase;

import com.example.mvvmproject.models.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    //Example Custum Query
//    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :nama ")
//    Mahasiswa findByName(String nama);

    @Insert
    void insertAll(Mahasiswa... mahasiswa);

//    @Delete
//    public void deleteUsers(Mahasiswa... users);

}
