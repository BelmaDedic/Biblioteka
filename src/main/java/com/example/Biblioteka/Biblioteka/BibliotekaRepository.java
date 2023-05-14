package com.example.Biblioteka.Biblioteka;

import com.example.Biblioteka.Grad.GradEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface BibliotekaRepository extends JpaRepository<BibliotekaEntity, Integer> {
    public List<BibliotekaEntity> pretragaPoGradu(Integer grad);
    public List<BibliotekaEntity> gradBiblioteka(Integer grad_id);
}
