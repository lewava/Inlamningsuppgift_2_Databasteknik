package model;

public class Beställningstatus {
    private int id;
    private enum status {behandlas, skickad, levererad}

    public Beställningstatus(int id, status status) {
        this.id = id;
    }
}
