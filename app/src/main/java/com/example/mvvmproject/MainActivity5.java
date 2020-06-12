package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvmproject.models.Daerah;
import com.example.mvvmproject.viewmodels.MyApp;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    TextView tvKelurahan, tvKecamatan, tvKodePos;
    List<Daerah> listDaerah = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        tvKelurahan = findViewById(R.id.tvKelurahan);
        tvKecamatan = findViewById(R.id.tvKecamatan);
        tvKodePos = findViewById(R.id.tvKodePos);

        fetchDataFromRoom();

    }

    private void fetchDataFromRoom() {
        listDaerah = MyApp.dbDaerah.daerahDao().getAll();
        tvKelurahan.setText(listDaerah.get(listDaerah.size()-1).getKelurahan());
        tvKecamatan.setText(listDaerah.get(listDaerah.size()-1).getKecamatan());
        tvKodePos.setText(MainActivity4.kodepos);

    }
}
