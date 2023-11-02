package org.example.domain;

import java.time.LocalDate;

public class Piesa {
    private int idPiesa;
    private String titlu;
    private int durata;

    public Piesa(int idPiesa, String titlu, int durata) {
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

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
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
