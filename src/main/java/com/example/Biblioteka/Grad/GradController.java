package com.example.Biblioteka.Grad;

import com.example.Biblioteka.Knjiga.KnjigaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradController {
    @Autowired
    private GradService gradService;

    @GetMapping("pretragaPoVise/{naziv}/{imeClana}/{knjiga}")
    public List<KnjigaEntity> pretragaPoVise(@PathVariable String naziv, @PathVariable String imeClana,
                                             @PathVariable String knjiga) {
        return gradService.pretragaPoVise(naziv, imeClana, knjiga);
    }
}
