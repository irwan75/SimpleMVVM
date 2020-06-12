package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmproject.dao.AppDatabase;
import com.example.mvvmproject.models.Daerah;
import com.example.mvvmproject.models.Mahasiswa;
import com.example.mvvmproject.viewmodels.MyApp;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    TextView tvKelurahan, tvKecamatan, tvKabupaten, tvProvinsi;
    List<Daerah> listDaerah = new ArrayList<>();
    EditText etKodePos;
    Button btnPindah;
    public static String kodepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tvKelurahan = findViewById(R.id.tvKelurahan);
        tvKecamatan = findViewById(R.id.tvKecamatan);
        tvKabupaten = findViewById(R.id.tvKabupaten);
        tvProvinsi = findViewById(R.id.tvProvinsi);
        etKodePos = findViewById(R.id.etKodePos);
        btnPindah = findViewById(R.id.btnPindah);

        fetchDataFromRoom();

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kodepos = etKodePos.getText().toString().trim();
                startActivity(new Intent(MainActivity4.this, MainActivity5.class));
            }
        });

    }

    private void fetchDataFromRoom() {
//        MyApp.db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class,"daerah").allowMainThreadQueries().build();
        listDaerah = MyApp.dbDaerah.daerahDao().getAll();

        tvKelurahan.setText(listDaerah.get(listDaerah.size()-1).getKelurahan());
        tvKecamatan.setText(listDaerah.get(listDaerah.size()-1).getKecamatan());
        tvKabupaten.setText(listDaerah.get(listDaerah.size()-1).getKabupaten());
        tvProvinsi.setText(listDaerah.get(listDaerah.size()-1).getProvinsi());
    }
}
