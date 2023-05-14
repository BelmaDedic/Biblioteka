package com.example.Biblioteka.Grad;

import com.example.Biblioteka.Biblioteka.BibliotekaEntity;
import com.example.Biblioteka.Clan.ClanEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "biblioteka", name = "grad")
public class GradEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String naziv, postanskiBroj;

    @JsonIgnore
    @OneToMany(targetEntity = BibliotekaEntity.class, mappedBy = "grad")
    private List<BibliotekaEntity> biblioteka = new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = ClanEntity.class, mappedBy = "grad")
    private List<ClanEntity> clan = new ArrayList<>();

    public GradEntity() {
    }

    public GradEntity(Integer id, String naziv, String postanskiBroj, List<BibliotekaEntity> biblioteka,
                      List<ClanEntity> clan) {
        this.id = id;
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
        this.biblioteka = biblioteka;
        this.clan = clan;
    }

    public GradEntity(String naziv, String postanskiBroj, List<BibliotekaEntity> biblioteka,
                      List<ClanEntity> clan) {
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
        this.biblioteka = biblioteka;
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

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public List<BibliotekaEntity> getBiblioteka() {
        return biblioteka;
    }

    public void setBiblioteka(List<BibliotekaEntity> biblioteka) {
        this.biblioteka = biblioteka;
    }

    public List<ClanEntity> getClan() {
        return clan;
    }

    public void setClan(List<ClanEntity> clan) {
        this.clan = clan;
    }

    @Override
    public String toString() {
        return "GradEntity{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", postanskiBroj='" + postanskiBroj + '\'' +
                ", biblioteka=" + biblioteka +
                ", clan=" + clan +
                '}';
    }
}
