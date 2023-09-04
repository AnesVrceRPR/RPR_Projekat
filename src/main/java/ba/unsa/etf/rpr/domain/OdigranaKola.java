package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class OdigranaKola {
    private int id;
    private Double igr1;
    private String igrac1;
    private String igrac2;
    private Double igr2;

    public Double getIgr1() {
        return igr1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIgrac1() {
        return igrac1;
    }

    public void setIgrac1(String igrac1) {
        this.igrac1 = igrac1;
    }

    public String getIgrac2() {
        return igrac2;
    }

    public void setIgrac2(String igrac2) {
        this.igrac2 = igrac2;
    }

    @Override
    public String toString() {
        return igrac1  + " " + igrac2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdigranaKola odigranaKola = (OdigranaKola) o;
        return id == odigranaKola.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, igrac1, igrac2);
    }
}
