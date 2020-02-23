public class Sko {
    private int id;
    private String namn;
    private int pris;
    private String märke;
    private String färg;
    private int storlek;
    private String kategori;

    public Sko(int id, String namn, int pris, String märke, String färg, int storlek, String kategori) {
        this.id = id;
        this.namn = namn;
        this.pris = pris;
        this.märke = märke;
        this.färg = färg;
        this.storlek = storlek;
        this.kategori = kategori;
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

    public String getMärke() {
        return märke;
    }

    public void setMärke(String märke) {
        this.märke = märke;
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

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
