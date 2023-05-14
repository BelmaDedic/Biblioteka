package com.example.Biblioteka.Grad;

import com.example.Biblioteka.Knjiga.KnjigaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradRepository extends JpaRepository<GradEntity, Integer> {
    GradEntity pretragaPoNazivu(String naziv);
    List<KnjigaEntity> pretragaPoVise(String naziv, String imeClana, String knjiga);
}
