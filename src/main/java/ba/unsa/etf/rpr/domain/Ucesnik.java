package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.util.Objects;

public class Ucesnik implements Comparable<Ucesnik>{
    private int id;
    private String Ime_i_Prezime;
    private int Rejting;
    private Double Broj_Osvojenih_Bodova;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getIme_i_Prezime() {
        return Ime_i_Prezime;
    }

    public void setIme_i_Prezime(String Ime_i_Prezime) {
        this.Ime_i_Prezime = Ime_i_Prezime;
    }

    public int getRejting() {
        return Rejting;
    }

    public void setRejting(int rejting) {
        Rejting = rejting;
    }

    public Double getBroj_Osvojenih_Bodova() {
        return Broj_Osvojenih_Bodova;
    }

    public void setBroj_Osvojenih_Bodova(Double broj_Osvojenih_Bodova) {
        Broj_Osvojenih_Bodova = broj_Osvojenih_Bodova;
    }

    @Override
    public String toString() {
        return Ime_i_Prezime + " / " + Rejting + " / " + Broj_Osvojenih_Bodova;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ucesnik ucesnik = (Ucesnik) o;
        return id == ucesnik.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Ime_i_Prezime, Rejting, Broj_Osvojenih_Bodova);
    }

    @Override
    public int compareTo(Ucesnik o) {
        return (int)(o.Broj_Osvojenih_Bodova - this.Broj_Osvojenih_Bodova);
    }
}
