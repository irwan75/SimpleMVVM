package com.example.mvvmproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvmproject.models.Daerah;
import com.example.mvvmproject.models.Mahasiswa;
import com.example.mvvmproject.viewmodels.MyApp;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    EditText etKelurahan, etKecamatan, etKabupaten, etProvinsi;
    EditText etNama, etNim, etKejuruan, etAlamat;
    Mahasiswa mahasiswa;
    Daerah daerah;
    Button btInsert, btPindah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = findViewById(R.id.etNama);
        etNim = findViewById(R.id.etNim);
        etKejuruan = findViewById(R.id.etKejuruan);
        etAlamat = findViewById(R.id.etAlamat);

        etKelurahan = findViewById(R.id.etKelurahan);
        etKecamatan = findViewById(R.id.etKecamatan);
        etKabupaten = findViewById(R.id.etKabupaten);
        etProvinsi = findViewById(R.id.etProvinsi);

        btInsert = findViewById(R.id.btInsert);
        btPindah = findViewById(R.id.btPindah);

        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        btInsert.setOnClickListener(clickListener);
        btPindah.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btInsert:
                    if (!etAlamat.getText().toString().isEmpty()&&!etKejuruan.getText().toString().isEmpty()&&
                            !etNama.getText().toString().isEmpty()&&!etNim.getText().toString().isEmpty()){

                        mahasiswa = new Mahasiswa();
                        mahasiswa.setAlamat(etAlamat.getText().toString());
                        mahasiswa.setKejuruan(etKejuruan.getText().toString());
                        mahasiswa.setNama(etNama.getText().toString());
                        mahasiswa.setNim(etNim.getText().toString());

                        //Insert data in database
                        MyApp.dbApp.userDao().insertAll(mahasiswa);
                        startActivity(new Intent(MainActivity.this,MainActivity2.class));
                    }else {
                        Toast.makeText(MainActivity.this, "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btPindah :
                    if (!etKelurahan.getText().toString().isEmpty()&&!etKecamatan.getText().toString().isEmpty()&&
                            !etKabupaten.getText().toString().isEmpty()&&!etProvinsi.getText().toString().isEmpty()){

                        daerah = new Daerah();
                        daerah.setKelurahan(etKelurahan.getText().toString());
                        daerah.setKecamatan(etKecamatan.getText().toString());
                        daerah.setKabupaten(etKabupaten.getText().toString());
                        daerah.setProvinsi(etProvinsi.getText().toString());
                        //Insert data in database

                        MyApp.dbDaerah.daerahDao().insertAll(daerah);
                        startActivity(new Intent(MainActivity.this,MainActivity4.class));
                    }else {
                        Toast.makeText(MainActivity.this, "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
}
