package com.example.Biblioteka.Biblioteka;

import com.example.Biblioteka.Grad.GradEntity;

import javax.persistence.*;

@Entity
@Table(schema = "biblioteka", name = "biblioteka")
public class BibliotekaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String naziv, adresa;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    GradEntity grad;

    public BibliotekaEntity() {
    }

    public BibliotekaEntity(Integer id, String naziv, String adresa, GradEntity grad) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
    }

    public BibliotekaEntity(String naziv, String adresa, GradEntity grad) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.grad = grad;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public GradEntity getGrad() {
        return grad;
    }

    public void setGrad(GradEntity grad) {
        this.grad = grad;
    }

    @Override
    public String toString() {
        return "BibliotekaEntity{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad=" + grad +
                '}';
    }
}
