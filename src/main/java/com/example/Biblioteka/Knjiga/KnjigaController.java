package com.example.Biblioteka.Knjiga;

import com.example.Biblioteka.Enum.NacinIzdavanjaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KnjigaController {
    @Autowired
    private KnjigaService knjigaService;

    @PostMapping("addKnjiga")
    public void addKnjiga(@RequestBody KnjigaEntity knjiga) {
        knjigaService.addKnjiga(knjiga);
    }

    @DeleteMapping("deleteKnjiga/{id}")
    public void deleteKnjiga(@PathVariable(value = "id") Integer id) {
        knjigaService.deleteKnjiga(id);
    }

    @PutMapping("updateKnjiga/{id}")
    public void updateKnjiga(@PathVariable Integer id, @RequestBody KnjigaEntity knjiga) {
        knjigaService.updateKnjiga(id, knjiga);
    }

    @GetMapping("allKnjige")
    public List<KnjigaEntity> allKnjige() {
        return knjigaService.allKnjige();
    }

    @GetMapping("pretragaPoKategoriji")
    public List<KnjigaEntity> pretragaPoKategoriji(String kategorija) {
        return knjigaService.pretragaPoKategoriji(kategorija);
    }

    @GetMapping("pretragaPoNazivu")
    public KnjigaEntity pretragaPoNazivu(String naziv) {
        return knjigaService.pretragaPoNazivu(naziv);
    }

    @PutMapping("updateKnjigaClan/{knjigaId}/{clanId}")
    public void updateKnjigaClan(@PathVariable Integer knjigaId, @PathVariable Integer clanId,
                                 @RequestBody NacinIzdavanjaEnum nacinIzdavanja) {
        knjigaService.updateKnjigaClan(knjigaId, clanId, nacinIzdavanja);
    }

    @GetMapping("korisniciPoGradu/{naziv}")
    public List<KnjigaProjection> korisniciGrad(@PathVariable String naziv) {
        return knjigaService.korisniciGrad(naziv);
    }
}
