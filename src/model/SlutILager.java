package model;

public class SlutILager {
    private int id;
    private int skoId;
    private int kategoriId;

    public SlutILager(int id, int skoId, int kategoriId) {
        this.id = id;
        this.skoId = skoId;
        this.kategoriId = kategoriId;
    }

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

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }
}
