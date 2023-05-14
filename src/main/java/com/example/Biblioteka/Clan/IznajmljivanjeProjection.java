package com.example.Biblioteka.Clan;

public class IznajmljivanjeProjection {
    String ime, prezime, nazivKnjige;
    int daniVracanja;

    public IznajmljivanjeProjection(String ime, String prezime, String nazivKnjige, int daniVracanja) {
        this.ime = ime;
        this.prezime = prezime;
        this.nazivKnjige = nazivKnjige;
        this.daniVracanja = daniVracanja;
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

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public int getDaniVracanja() {
        return daniVracanja;
    }

    public void setDaniVracanja(int daniVracanja) {
        this.daniVracanja = daniVracanja;
    }
}
