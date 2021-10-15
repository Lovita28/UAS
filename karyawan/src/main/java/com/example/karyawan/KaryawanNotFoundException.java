package com.example.karyawan;

class KaryawanNotFoundException extends RuntimeException{
    KaryawanNotFoundException(Long nip){
        super("Karyawan dengan Id : " + nip + " tidak ditemukan!");
    }
}
