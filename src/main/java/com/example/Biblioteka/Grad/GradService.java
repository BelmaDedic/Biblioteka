package com.example.Biblioteka.Grad;

import com.example.Biblioteka.Knjiga.KnjigaEntity;

import java.util.List;

public interface GradService {
    GradEntity pretragaPoNazivu(String naziv);

    List<KnjigaEntity> pretragaPoVise(String naziv, String imeClana, String knjiga);
}
