public class Kund {
    private String förnamn;
    private String efternamn;
    private String personnummer;
    private String telefonnummer;
    private String adress;
    private String ort;
    private String postnummer;
    private String lösenord;

    public Kund(String förnamn, String efternamn, String personnummer, String telefonnummer,
                String adress, String ort, String postnummer, String lösenord) {

        this.förnamn = förnamn;
        this.efternamn = efternamn;
        this.personnummer = personnummer;
        this.telefonnummer = telefonnummer;
        this.adress = adress;
        this.ort = ort;
        this.postnummer = postnummer;
        this.lösenord = lösenord;

    }

    public String getFörnamn() {
        return förnamn;
    }

    public void setFörnamn(String förnamn) {
        this.förnamn = förnamn;
    }

    public String getEfternamn() {
        return efternamn;
    }

    public void setEfternamn(String efternamn) {
        this.efternamn = efternamn;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getLösenord() {
        return lösenord;
    }

    public void setLösenord(String lösenord) {
        this.lösenord = lösenord;
    }

}
