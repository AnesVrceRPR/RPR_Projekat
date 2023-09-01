package ba.unsa.etf.rpr.dao;

public class UcesnikDaoSQLImpl{
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



}