package com.example.Biblioteka.Knjiga;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnjigaRepository extends JpaRepository<KnjigaEntity, Integer> {
    List<KnjigaEntity> pretragaPoKategoriji(String kategorija);
    KnjigaEntity pretragaPoNazivu(String naziv);
}
