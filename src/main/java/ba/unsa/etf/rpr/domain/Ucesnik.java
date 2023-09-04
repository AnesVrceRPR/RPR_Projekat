package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * JavaBeans klasa, sadrži gettere i settere za sve privatne atribute
 * konstruktor sa i bez parametara
 * toSTring, hashCode, equals i compareTo
 */

public class Ucesnik implements Comparable<Ucesnik>, Serializable{
    private int id;
    private String imeIPrezime;
    private int Rejting;
    private Double brojOsvojenihBodova;

    public Ucesnik() {
        this.id = 0;
        this.imeIPrezime = "";
        Rejting = 0;
        this.brojOsvojenihBodova = 0.;
    }

    public Ucesnik(int id, String imeIPrezime, int rejting, Double brojOsvojenihBodova) {
        this.id = id;
        this.imeIPrezime = imeIPrezime;
        Rejting = rejting;
        this.brojOsvojenihBodova = brojOsvojenihBodova;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getImeIPrezime() {
        return imeIPrezime;
    }

    public void setImeIPrezime(String Ime_i_Prezime) {
        this.imeIPrezime = Ime_i_Prezime;
    }

    public int getRejting() {
        return Rejting;
    }

    public void setRejting(int rejting) {
        Rejting = rejting;
    }

    public Double getBrojOsvojenihBodova() {
        return brojOsvojenihBodova;
    }

    public void setBrojOsvojenihBodova(Double brojOsvojenihBodova) {
        this.brojOsvojenihBodova = brojOsvojenihBodova;
    }

    @Override
    public String toString() {
        return imeIPrezime + " / " + Rejting + " / " + brojOsvojenihBodova;
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
        return Objects.hash(id, imeIPrezime, Rejting, brojOsvojenihBodova);
    }

    @Override
    public int compareTo(Ucesnik o) {
        return (int)(o.brojOsvojenihBodova - this.brojOsvojenihBodova);
    }
}
