package com.example.Biblioteka.Clan;

import java.util.List;

public interface ClanService {
    void addClan(ClanEntity clan);

    List<IznajmljivanjeProjection> clan();
}
