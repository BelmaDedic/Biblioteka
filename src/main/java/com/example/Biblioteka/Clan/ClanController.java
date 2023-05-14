package com.example.Biblioteka.Clan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClanController {
    @Autowired
    private ClanService clanService;

    @PostMapping("addClan")
    public void addClan(@RequestBody ClanEntity clan) {
        clanService.addClan(clan);
    }

    @GetMapping("rokIznajmljivanja")
    public List<IznajmljivanjeProjection> clan() {
        return clanService.clan();
    }
}
