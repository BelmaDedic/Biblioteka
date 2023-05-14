package com.example.Biblioteka.Knjiga;

import com.example.Biblioteka.Enum.NacinIzdavanjaEnum;

public class KnjigaProjection {
    String grad, imeClana;
    NacinIzdavanjaEnum nacinIzdavanja;

    public KnjigaProjection(String grad, String imeClana, NacinIzdavanjaEnum nacinIzdavanja) {
        this.grad = grad;
        this.imeClana = imeClana;
        this.nacinIzdavanja = nacinIzdavanja;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getImeClana() {
        return imeClana;
    }

    public void setImeClana(String imeClana) {
        this.imeClana = imeClana;
    }

    public NacinIzdavanjaEnum getNacinIzdavanja() {
        return nacinIzdavanja;
    }

    public void setNacinIzdavanja(NacinIzdavanjaEnum nacinIzdavanja) {
        this.nacinIzdavanja = nacinIzdavanja;
    }
}
