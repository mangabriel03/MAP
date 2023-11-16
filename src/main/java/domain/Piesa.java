package domain;

import java.time.LocalDate;

public class Piesa {
    private int idPiesa;
    private String titlu;
    private float durata;

    public Piesa(int idPiesa, String titlu, float durata) {
        this.idPiesa = idPiesa;
        this.titlu = titlu;
        this.durata = durata;
    }

    public int getIdPiesa() {
        return idPiesa;
    }

    public void setIdPiesa(int idPiesa) {
        this.idPiesa = idPiesa;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public float getDurata() {
        return durata;
    }

    public void setDurata(float durata) {
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Piesa{" +
                "idPiesa=" + idPiesa +
                ", titlu='" + titlu + '\'' +
                ", durata=" + durata +
                '}';
    }
}
