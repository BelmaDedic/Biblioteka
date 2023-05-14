package com.example.Biblioteka.Knjiga;

import com.example.Biblioteka.Clan.ClanEntity;
import com.example.Biblioteka.Enum.NacinIzdavanjaEnum;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(schema = "biblioteka", name = "knjiga")
public class KnjigaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String naziv, autor, kategorija, godinaObjave;
    private Date rokVracanja;
    private NacinIzdavanjaEnum nacinIzdavanja;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    ClanEntity clan;

    public KnjigaEntity() {
    }

    public KnjigaEntity(Integer id, String naziv, String autor, String kategorija, String godinaObjave,
                        Date rokVracanja, NacinIzdavanjaEnum nacinIzdavanja, ClanEntity clan) {
        this.id = id;
        this.naziv = naziv;
        this.autor = autor;
        this.kategorija = kategorija;
        this.godinaObjave = godinaObjave;
        this.rokVracanja = rokVracanja;
        this.nacinIzdavanja = nacinIzdavanja;
        this.clan = clan;
    }

    public KnjigaEntity(String naziv, String autor, String kategorija, String godinaObjave, Date rokVracanja,
                        NacinIzdavanjaEnum nacinIzdavanja, ClanEntity clan) {
        this.naziv = naziv;
        this.autor = autor;
        this.kategorija = kategorija;
        this.godinaObjave = godinaObjave;
        this.rokVracanja = rokVracanja;
        this.nacinIzdavanja = nacinIzdavanja;
        this.clan = clan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getGodinaObjave() {
        return godinaObjave;
    }

    public void setGodinaObjave(String godinaObjave) {
        this.godinaObjave = godinaObjave;
    }

    public Date getRokVracanja() {
        return rokVracanja;
    }

    public void setRokVracanja(Date rokVracanja) {
        this.rokVracanja = rokVracanja;
    }

    public NacinIzdavanjaEnum getNacinIzdavanja() {
        return nacinIzdavanja;
    }

    public void setNacinIzdavanja(NacinIzdavanjaEnum nacinIzdavanja) {
        this.nacinIzdavanja = nacinIzdavanja;
    }

    public ClanEntity getClan() {
        return clan;
    }

    public void setClan(ClanEntity clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "KnjigaEntity{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", autor='" + autor + '\'' +
                ", kategorija='" + kategorija + '\'' +
                ", godinaObjave='" + godinaObjave + '\'' +
                ", rokVracanja=" + rokVracanja +
                ", nacinIzdavanja=" + nacinIzdavanja +
                ", clan=" + clan +
                '}';
    }
}
