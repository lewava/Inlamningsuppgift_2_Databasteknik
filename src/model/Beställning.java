package model;

public class Beställning {
    private int id;
    private String datum;
    private int kundId;
    private int beställningsStatusId;

    public Beställning(int id, String datum, int kundId, int beställningsStatusId) {
        this.id = id;
        this.datum = datum;
        this.kundId = kundId;
        this.beställningsStatusId = beställningsStatusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getKundId() {
        return kundId;
    }

    public void setKundId(int kundId) {
        this.kundId = kundId;
    }

    public int getBeställningsStatusId() {
        return beställningsStatusId;
    }

    public void setBeställningsStatusId(int beställningsStatusId) {
        this.beställningsStatusId = beställningsStatusId;
    }

    @Override
    public String toString() {
        return String.format("Beställning: %d, Datum: %s", getId(), getDatum());
    }
}
