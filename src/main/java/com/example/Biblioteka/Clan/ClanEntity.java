package com.example.Biblioteka.Clan;

import com.example.Biblioteka.Grad.GradEntity;
import com.example.Biblioteka.Knjiga.KnjigaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "biblioteka", name = "clan")
public class ClanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ime, prezime;
    private Date datumUclanjenja;

    @JsonIgnore
    @OneToMany(targetEntity = KnjigaEntity.class, mappedBy = "clan")
    private List<KnjigaEntity> knjige = new ArrayList<>();

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    GradEntity grad;

    public ClanEntity() {
    }

    public ClanEntity(Integer id, String ime, String prezime, Date datumUclanjenja, List<KnjigaEntity> knjige,
                      GradEntity grad) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumUclanjenja = datumUclanjenja;
        this.knjige = knjige;
        this.grad = grad;
    }

    public ClanEntity(String ime, String prezime, Date datumUclanjenja, List<KnjigaEntity> knjige,
                      GradEntity grad) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumUclanjenja = datumUclanjenja;
        this.knjige = knjige;
        this.grad = grad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumUclanjenja() {
        return datumUclanjenja;
    }

    public void setDatumUclanjenja(Date datumUclanjenja) {
        this.datumUclanjenja = datumUclanjenja;
    }

    public List<KnjigaEntity> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<KnjigaEntity> knjige) {
        this.knjige = knjige;
    }

    public GradEntity getGrad() {
        return grad;
    }

    public void setGrad(GradEntity grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return "ClanEntity{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datumUclanjenja=" + datumUclanjenja +
                ", knjige=" + knjige +
                ", grad=" + grad +
                '}';
    }
}
