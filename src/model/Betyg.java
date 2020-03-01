package model;

public class Betyg {
    private int id;
    private int skoId;
    private String kommentar;
    private enum nöjdhet {mycketNöjd, nöjd, ganskaNöjd, missnöjd}
    private int kundId;

    public Betyg(int id, int skoId, String kommentar, nöjdhet nöjdhet, int kundId) {
        this.id = id;
        this.skoId = skoId;
        this.kommentar = kommentar;
        this.kundId = kundId;
    }
}
