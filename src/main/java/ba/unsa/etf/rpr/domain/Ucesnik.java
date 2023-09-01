package ba.unsa.etf.rpr.domain;

public class Ucesnik {
    private int id;
    private String Ime_i_Prezime;
    private int Rejting;
    private int Broj_Osvojenih_Bodova;

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

    public int getBroj_Osvojenih_Bodova() {
        return Broj_Osvojenih_Bodova;
    }

    public void setBroj_Osvojenih_Bodova(int broj_Osvojenih_Bodova) {
        Broj_Osvojenih_Bodova = broj_Osvojenih_Bodova;
    }

    @Override
    public String toString() {
        return "id = " + id + ", Ime i Prezime: " + Ime_i_Prezime + ", Rejting: " + Rejting +
                ", Broj osvojenih bodova: " + Broj_Osvojenih_Bodova;
    }
}
