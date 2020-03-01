package model;

public class Sko {
    private int id;
    private String namn;
    private int pris;
    private String märkeNamn;
    private String färg;
    private int storlek;
    private int lagerstatus;
    private String kategoriNamn;

    public Sko (int id, String namn, int pris, String märkeNamn, String färg, int storlek, String kategoriNamn) {
        this.id = id;
        this.namn = namn;
        this.pris = pris;
        this.märkeNamn = märkeNamn;
        this.färg = färg;
        this.storlek = storlek;
        this.kategoriNamn = kategoriNamn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public String getMärkeNamn() {
        return märkeNamn;
    }

    public void setMärkeNamn(String märkeNamn) {
        this.märkeNamn = märkeNamn;
    }

    public String getFärg() {
        return färg;
    }

    public void setFärg(String färg) {
        this.färg = färg;
    }

    public int getStorlek() {
        return storlek;
    }

    public void setStorlek(int storlek) {
        this.storlek = storlek;
    }

    public int getLagerstatus() {
        return lagerstatus;
    }

    public void setLagerstatus(int lagerstatus) {
        this.lagerstatus = lagerstatus;
    }

    public String getKategoriNamn() {
        return kategoriNamn;
    }

    public void setKategoriNamn(String kategoriNamn) {
        this.kategoriNamn = kategoriNamn;
    }
}
