public class Login {

    private String förnamn;
    private String lösenord;

    public Login(String förnamn, String lösenord) {
        this.förnamn = förnamn;
        this.lösenord = lösenord;
    }

    public String getFörnamn() {
        return förnamn;
    }

    public void setFörnamn(String förnamn) {
        this.förnamn = förnamn;
    }

    public String getLösenord() {
        return lösenord;
    }

    public void setLösenord(String lösenord) {
        this.lösenord = lösenord;
    }

}
