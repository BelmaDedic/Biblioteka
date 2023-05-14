package com.example.Biblioteka.Biblioteka;

import com.example.Biblioteka.Grad.GradEntity;
import com.example.Biblioteka.Grad.GradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BibliotekaServiceImpl implements BibliotekaService{
    @Autowired
    private BibliotekaRepository bibliotekaRepository;

    @Autowired
    private GradRepository gradRepository;

    @Override
    public List<BibliotekaEntity> pretragaPoGradu(Integer grad) {
        return bibliotekaRepository.pretragaPoGradu(grad);
    }

    @Override
    public HashMap<String, List<BibliotekaEntity>> gradoviBiblioteke() {
        HashMap<String, List<BibliotekaEntity>> gradBibilioteka = new HashMap<>();
        List<GradEntity> grad = new ArrayList<>();
        grad = gradRepository.findAll();
        for(int i = 0; i < grad.size(); i++) {
            gradBibilioteka.put(grad.get(i).getNaziv(),
                    bibliotekaRepository.gradBiblioteka(grad.get(i).getId()));
        }
        return gradBibilioteka;
    }
}
