package ba.unsa.etf.rpr.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * JavaBeans klasa, sadrži gettere i settere za sve privatne atribute
 * konstruktor sa i bez parametara
 * toSTring, hashCodei equals
 */
public class Tabela implements Serializable {
    private int id;
    private String mjesto1;
    private String mjesto2;
    private String mjesto3;
    private String mjesto4;
    private String mjesto5;
    private String mjesto6;
    private String mjesto7;
    private String mjesto8;

    public Tabela() {
        this.id = 0;
        this.mjesto1 = "";
        this.mjesto2 = "";
        this.mjesto3 = "";
        this.mjesto4 = "";
        this.mjesto5 = "";
        this.mjesto6 = "";
        this.mjesto7 = "";
        this.mjesto8 = "";
    }

    public Tabela(int id, String mjesto1, String mjesto2, String mjesto3, String mjesto4, String mjesto5, String mjesto6, String mjesto7, String mjesto8) {
        this.id = id;
        this.mjesto1 = mjesto1;
        this.mjesto2 = mjesto2;
        this.mjesto3 = mjesto3;
        this.mjesto4 = mjesto4;
        this.mjesto5 = mjesto5;
        this.mjesto6 = mjesto6;
        this.mjesto7 = mjesto7;
        this.mjesto8 = mjesto8;
    }

    public String getMjesto1() {
        return mjesto1;
    }

    public String getMjesto2() {
        return mjesto2;
    }

    public String getMjesto3() {
        return mjesto3;
    }

    public String getMjesto4() {
        return mjesto4;
    }

    public String getMjesto5() {
        return mjesto5;
    }

    public String getMjesto6() {
        return mjesto6;
    }

    public String getMjesto7() {
        return mjesto7;
    }

    public String getMjesto8() {
        return mjesto8;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMjesto1(String mjesto1) {
        this.mjesto1 = mjesto1;
    }

    public void setMjesto2(String mjesto2) {
        this.mjesto2 = mjesto2;
    }

    public void setMjesto3(String mjesto3) {
        this.mjesto3 = mjesto3;
    }

    public void setMjesto4(String mjesto4) {
        this.mjesto4 = mjesto4;
    }

    public void setMjesto5(String mjesto5) {
        this.mjesto5 = mjesto5;
    }

    public void setMjesto6(String mjesto6) {
        this.mjesto6 = mjesto6;
    }

    public void setMjesto7(String mjesto7) {
        this.mjesto7 = mjesto7;
    }

    public void setMjesto8(String mjesto8) {
        this.mjesto8 = mjesto8;
    }

    @Override
    public String toString() {return mjesto1;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tabela tabela = (Tabela) o;
        return id == tabela.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mjesto1, mjesto2, mjesto3);
    }
}
