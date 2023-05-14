package com.example.Biblioteka.Biblioteka;

import com.example.Biblioteka.Grad.GradEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class BibliotekaController {
    @Autowired
    private BibliotekaService bibliotekaService;

    @GetMapping("pretragaPoGradu")
    public List<BibliotekaEntity> pretragaPoGradu(Integer grad) {
        return bibliotekaService.pretragaPoGradu(grad);
    }

    @GetMapping("getGradoveIBiblioteke")
    public HashMap<String, List<BibliotekaEntity>> gradoviBiblioteke() {
        return bibliotekaService.gradoviBiblioteke();
    }
}
