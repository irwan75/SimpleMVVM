package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.mvvmproject.adapter.RecyclerAdapter;
import com.example.mvvmproject.dao.AppDatabase;
import com.example.mvvmproject.models.Mahasiswa;
import com.example.mvvmproject.viewmodels.MyApp;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    Button btPindah;
    RecyclerView myRecyclerView;
    RecyclerAdapter recycleAdapter;
    List<Mahasiswa> listMahasiswas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myRecyclerView = findViewById(R.id.myRecyclerview);
        btPindah = findViewById(R.id.btPindah);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();

        btPindah.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btPindah :
                    startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                    break;
            }
        }
    };

    private void fetchDataFromRoom() {
//        MyApp.dbApp = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class,"mahasiswa").allowMainThreadQueries().build();
        listMahasiswas = MyApp.dbApp.userDao().getAll();

        //just checking data from db
        for (int i = 0 ;i <listMahasiswas.size();i++){
            Log.e("Aplikasi",listMahasiswas.get(i).getAlamat()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getKejuruan()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNama()+i);
            Log.e("Aplikasi",listMahasiswas.get(i).getNim()+i);
        }
    }
    private void initRecyclerView() {
        myRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerView.setLayoutManager(llm);
        recycleAdapter =new RecyclerAdapter(this,listMahasiswas);
    }

    private void setAdapter() {
        myRecyclerView.setAdapter(recycleAdapter);
    }
}
