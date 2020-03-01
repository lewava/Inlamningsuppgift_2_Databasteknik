package model;

public class BeställdSko {
    private int id;
    private int beställningId;
    private int skoId;

    public BeställdSko(int id, int beställningId, int skoId) {
        this.id = id;
        this.beställningId = beställningId;
        this.skoId = skoId;
    }
}
