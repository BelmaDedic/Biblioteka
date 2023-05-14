package com.example.Biblioteka.Knjiga;

import com.example.Biblioteka.Enum.NacinIzdavanjaEnum;

import java.util.List;

public interface KnjigaService {
    void addKnjiga(KnjigaEntity knjiga);

    void deleteKnjiga(Integer id);

    void updateKnjiga(Integer id, KnjigaEntity knjiga);

    List<KnjigaEntity> allKnjige();

    List<KnjigaEntity> pretragaPoKategoriji(String kategorija);

    KnjigaEntity pretragaPoNazivu(String naziv);

    void updateKnjigaClan(Integer knjigaId, Integer clanId, NacinIzdavanjaEnum nacinIzdavanja);

    List<KnjigaProjection> korisniciGrad(String naziv);
}
