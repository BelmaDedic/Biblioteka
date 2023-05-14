package com.example.Biblioteka.Grad;

import com.example.Biblioteka.Knjiga.KnjigaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradServiceImpl implements GradService{
    @Autowired
    private GradRepository gradRepository;

    @Override
    public GradEntity pretragaPoNazivu(String naziv) {
        return gradRepository.pretragaPoNazivu(naziv);
    }

    @Override
    public List<KnjigaEntity> pretragaPoVise(String naziv, String imeClana, String knjiga) {
        return gradRepository.pretragaPoVise(naziv, imeClana, knjiga);
    }
}
