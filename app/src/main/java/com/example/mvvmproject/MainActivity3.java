package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvmproject.dao.AppDatabase;
import com.example.mvvmproject.models.Mahasiswa;
import com.example.mvvmproject.viewmodels.MyApp;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    TextView tvNim, tvNama, tvKejuruan, tvAlamat, tvKodePos;
    List<Mahasiswa> listMahasiswas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvNama = findViewById(R.id.tvNama);
        tvNim = findViewById(R.id.tvNim);
        tvKejuruan = findViewById(R.id.tvKejuruan);
        tvAlamat = findViewById(R.id.tvAlamat);
        tvKodePos = findViewById(R.id.tvKodePos);

        fetchDataFromRoom();

    }

    private void fetchDataFromRoom() {
//        MyApp.db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class,"mahasiswa").allowMainThreadQueries().build();
        listMahasiswas = MyApp.dbApp.userDao().getAll();

        tvAlamat.setText(listMahasiswas.get(listMahasiswas.size()-1).getAlamat());
        tvNama.setText(listMahasiswas.get(listMahasiswas.size()-1).getNama());
        tvNim.setText(listMahasiswas.get(listMahasiswas.size()-1).getNim());
        tvKejuruan.setText(listMahasiswas.get(listMahasiswas.size()-1).getKejuruan());
        tvKodePos.setText(MainActivity4.kodepos);
    }
}
