package com.example.mvvmproject.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Daerah {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "kelurahan")
    String kelurahan;
    @ColumnInfo(name = "kecamatan")
    String kecamatan;
    @ColumnInfo(name = "kabupaten")
    String kabupaten;
    @ColumnInfo(name = "provinsi")
    String provinsi;

    public Daerah(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
}
