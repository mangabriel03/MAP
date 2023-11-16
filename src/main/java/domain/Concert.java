package domain;

import java.time.LocalDate;

public class Concert {
    private int idConcert;
    private LocalDate data;
    private String nume;
    private int idTrupa;
    private String locatie;


    public Concert(int idConcert, LocalDate data, String nume, int idTrupa, String locatie) {
        this.idConcert = idConcert;
        this.data = data;
        this.nume = nume;
        this.idTrupa = idTrupa;
        this.locatie = locatie;
    }

    public int getIdConcert() {
        return idConcert;
    }

    public void setIdConcert(int idConcert) {
        this.idConcert = idConcert;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getIdTrupa() {
        return idTrupa;
    }

    public void setIdTrupa(int idTrupa) {
        this.idTrupa = idTrupa;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "idConcert=" + idConcert +
                ", data=" + data +
                ", nume='" + nume + '\'' +
                ", idTrupa=" + idTrupa +
                ", locatie='" + locatie + '\'' +
                '}';
    }
}
