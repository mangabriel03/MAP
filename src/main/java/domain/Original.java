// domain/Original.java
package domain;

public class Original implements Melodie {
    private String nume;

    public Original(String nume) {
        this.nume = nume;
    }


    @Override
    public String toString() {
        return "Original{" +
                "nume='" + nume + '\'' +
                '}';
    }

    @Override
    public String afiseazaDetalii() {
        return null;
    }

}
