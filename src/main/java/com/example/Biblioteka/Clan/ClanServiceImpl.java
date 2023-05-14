package com.example.Biblioteka.Clan;

import com.example.Biblioteka.Knjiga.KnjigaEntity;
import com.example.Biblioteka.Knjiga.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ClanServiceImpl implements ClanService{
    @Autowired
    private ClanRepository clanRepository;

    @Autowired
    private KnjigaRepository knjigaRepository;

    @Override
    public void addClan(ClanEntity clan) {
        clanRepository.save(clan);
    }

    @Override
    public List<IznajmljivanjeProjection> clan() {

        List<KnjigaEntity> knjiga = new ArrayList<>();

        Date date1 = new Date();

        List<IznajmljivanjeProjection> iznajmljivanjeProjections = new ArrayList<>();

        knjiga = knjigaRepository.findAll();

        for(int i = 0; i < knjiga.size(); i++) {
            if(knjiga.get(i).getRokVracanja() != null) {
                long date1InMs = date1.getTime();
                long date2InMs = knjiga.get(i).getRokVracanja().getTime();

                // getting the diff between two dates.
                long timeDiff = 0;
                if(date1InMs > date2InMs) {
                    timeDiff = date1InMs - date2InMs;
                } else {
                    timeDiff = date2InMs - date1InMs;
                }
                // converting diff into days
                int daysDiff = (int) (timeDiff / (1000 * 60 * 60* 24));

                if(daysDiff <= 10) {
                    IznajmljivanjeProjection iznajmljivanje = new IznajmljivanjeProjection(
                            knjiga.get(i).getClan().getIme(), knjiga.get(i).getClan().getPrezime(),
                            knjiga.get(i).getNaziv(), daysDiff);
                    iznajmljivanjeProjections.add(iznajmljivanje);
                }
            }
        }
        return iznajmljivanjeProjections;
    }
}
