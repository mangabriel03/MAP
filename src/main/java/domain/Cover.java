package domain;

public class Cover implements Melodie {
    private String nume;

    public Cover(String nume) {
        this.nume = nume;
    }

    public String  afiseazaDetalii() {
        return "Cover{" +
                "nume='" + nume + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Cover{" +
                "nume='" + nume + '\'' +
                '}';
    }
}
