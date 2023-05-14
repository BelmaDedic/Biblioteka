package com.example.Biblioteka.Knjiga;

import com.example.Biblioteka.Clan.ClanRepository;
import com.example.Biblioteka.Clan.IznajmljivanjeProjection;
import com.example.Biblioteka.Enum.NacinIzdavanjaEnum;
import com.example.Biblioteka.Grad.GradEntity;
import com.example.Biblioteka.Grad.GradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class KnjigaServiceImpl implements KnjigaService{
    @Autowired
    private KnjigaRepository knjigaRepository;

    @Autowired
    private ClanRepository clanRepository;

    @Autowired
    private GradRepository gradRepository;

    @Override
    public void addKnjiga(KnjigaEntity knjiga) {
        knjigaRepository.save(knjiga);
    }

    @Override
    public void deleteKnjiga(Integer id) {
        knjigaRepository.deleteById(id);
    }

    @Override
    public void updateKnjiga(Integer id, KnjigaEntity knjiga) {
        knjigaRepository.findById(id)
                .ifPresent(novaKnjiga -> {
                    novaKnjiga.setNaziv(knjiga.getNaziv());
                    novaKnjiga.setAutor(knjiga.getAutor());
                    novaKnjiga.setKategorija(knjiga.getKategorija());
                    novaKnjiga.setGodinaObjave(knjiga.getGodinaObjave());
                    novaKnjiga.setClan(knjiga.getClan());
                    novaKnjiga.setNacinIzdavanja(knjiga.getNacinIzdavanja());
                    novaKnjiga.setRokVracanja(knjiga.getRokVracanja());

                    knjigaRepository.save(novaKnjiga);
                });
    }

    @Override
    public List<KnjigaEntity> allKnjige() {
        return knjigaRepository.findAll();
    }

    @Override
    public List<KnjigaEntity> pretragaPoKategoriji(String kategorija) {
        return knjigaRepository.pretragaPoKategoriji(kategorija);
    }

    @Override
    public KnjigaEntity pretragaPoNazivu(String naziv) {
        return knjigaRepository.pretragaPoNazivu(naziv);
    }

    @Override
    public void updateKnjigaClan(Integer knjigaId, Integer clanId, NacinIzdavanjaEnum nacinIzdavanja) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(clanRepository.findById(clanId).get().getDatumUclanjenja());

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        Date rokVracanja;

        if(calendar.get(Calendar.YEAR) < 2020) {
            cal.add(Calendar.DAY_OF_MONTH, 30);
            rokVracanja = cal.getTime();
        } else {
            cal.add(Calendar.DAY_OF_MONTH, 20);
            rokVracanja = cal.getTime();
        }
        knjigaRepository.findById(knjigaId)
                .ifPresent(novaKnjiga -> {
                    novaKnjiga.setClan(clanRepository.findById(clanId).get());
                    novaKnjiga.setRokVracanja(rokVracanja);
                    novaKnjiga.setNacinIzdavanja(nacinIzdavanja);
                    knjigaRepository.save(novaKnjiga);
                });
    }

    @Override
    public List<KnjigaProjection> korisniciGrad(String naziv) {
        List<KnjigaEntity> knjiga = new ArrayList<>();

        List<KnjigaProjection> knjigaProjections = new ArrayList<>();

        knjiga = knjigaRepository.findAll();

        GradEntity grad = gradRepository.pretragaPoNazivu(naziv);
        if(grad != null) {
            for(int i = 0; i < knjiga.size(); i++) {
                if(knjiga.get(i).getNacinIzdavanja() == NacinIzdavanjaEnum.online) {
                    KnjigaProjection knjigaProjection = new KnjigaProjection(grad.getNaziv(),
                            knjiga.get(i).getClan().getIme(), knjiga.get(i).getNacinIzdavanja());
                    knjigaProjections.add(knjigaProjection);
                }
            }
        }
        return knjigaProjections;
    }
}
