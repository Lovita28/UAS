package com.example.karyawan;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://dashboard.whatabyte.app")
@RestController
public class KaryawanController {
    private final KaryawanRepository repository;

    KaryawanController(KaryawanRepository repository){
        this.repository = repository;
    }

    @GetMapping("api/data/karyawan")
    List<Karyawan> all(){
        return repository.findAll();
    }

    @PostMapping("api/data/karyawan")
    Karyawan newKaryawan(@RequestBody Karyawan newKaryawan){
        return repository.save(newKaryawan);
    }

    @GetMapping("api/data/karyawan/{nip}")
    Karyawan karyawan(@PathVariable Long nip){
        return repository.findById(nip).orElseThrow(()->new KaryawanNotFoundException(nip));
    }

    @PutMapping("api/data/karyawan/{nip}")
    Karyawan editKaryawan(@RequestBody Karyawan newKaryawan, @PathVariable Long nip) {
        
        return repository.findById(nip)
        .map(menu -> {
            menu.setNama(newKaryawan.getNama());
            menu.setAlamat(newKaryawan.getAlamat());
            menu.setJabatan(newKaryawan.getJabatan());
            menu.setGaji(newKaryawan.getGaji());
            menu.setPajak(newKaryawan.getPajak());
            return repository.save(menu);
        })
        .orElseGet(() -> {
            newKaryawan.setNip(nip);
            return repository.save(newKaryawan);
        });
    }


    @DeleteMapping("api/data/karyawan/{nip}")
    void deleteKaryawan(@PathVariable Long nip){
        repository.deleteById(nip);
    }
}
