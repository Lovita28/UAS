package com.example.karyawan;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Karyawan {
    private @Id @GeneratedValue Long nip;
    private String nama;
    private String alamat;
    private String jabatan;
    private Long gaji;
    private Long pajak;

    Karyawan() {}

    Karyawan(String nama, String alamat, String jabatan, Long gaji, Long pajak){
        this.nama = nama;
        this.alamat = alamat;
        this.jabatan = jabatan;
        this.gaji = gaji;
        this.pajak = pajak;
    }

    public Long getNip(){
        return this.nip;
    }
    public String getNama(){
        return this.nama;
    }

    public String getAlamat(){
        return this.alamat;
    }

    public String getJabatan(){
        return this.jabatan;
    }

    public Long getGaji(){
        return this.gaji;
    }

    public Long getPajak(){
        return this.pajak;
    }

    public void setNip(Long nip){
        this.nip = nip;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public void setJabatan(String jabatan){
        this.jabatan = jabatan;
    }

    public void setGaji(Long gaji){
        this.gaji = gaji;
    }

    public void setPajak(Long pajak){
        this.pajak = pajak;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.nip, this.nama, this.alamat, this.jabatan, this.gaji, this.pajak);
    }

    @Override
    public String toString(){
        return "Karyawan{" + "nip=" + this.nip + ", nama='" + this.nama + '\'' + ", alamat='" + this.alamat + '\'' + ", jabatan='" + this.jabatan + '\'' +", gaji='" + this.gaji + '\'' +", pajak='"+ this.pajak +'\''+'}';
    }
}
