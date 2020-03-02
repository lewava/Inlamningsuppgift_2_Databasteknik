package model;

public class Betyg {
    private int id;
    private int skoId;
    private String kommentar;
    private enum nöjdhet {mycketNöjd, nöjd, ganskaNöjd, missnöjd}
    private int kundId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkoId() {
        return skoId;
    }

    public void setSkoId(int skoId) {
        this.skoId = skoId;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public int getKundId() {
        return kundId;
    }

    public void setKundId(int kundId) {
        this.kundId = kundId;
    }

    public Betyg(int id, int skoId, String kommentar, nöjdhet nöjdhet, int kundId) {
        this.id = id;
        this.skoId = skoId;
        this.kommentar = kommentar;
        this.kundId = kundId;


    }
}
