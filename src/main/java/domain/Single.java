package domain;

public class Single implements Melodie {
    private String nume;

    public Single(String nume) {
        this.nume = nume;
    }

    public String afiseazaDetalii() {
        return "Single{" +
                "nume='" + nume + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Single{" +
                "nume='" + nume + '\'' +
                '}';
    }
}
