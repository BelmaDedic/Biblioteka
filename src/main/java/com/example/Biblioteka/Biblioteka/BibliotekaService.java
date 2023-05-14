package com.example.Biblioteka.Biblioteka;

import java.util.HashMap;
import java.util.List;

public interface BibliotekaService {
    List<BibliotekaEntity> pretragaPoGradu(Integer grad);
    public HashMap<String, List<BibliotekaEntity>> gradoviBiblioteke();
}
