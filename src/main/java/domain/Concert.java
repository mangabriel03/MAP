package domain;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Concert {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idConcert;
    @Column(name = "data")
    private LocalDate data;
    @Column(name = "nume")
    private String nume;
    @Column(name = "idTrupa")
    private int idTrupa;
    @Column(name = "locatie")
    private String locatie;


    public Concert(int idConcert, LocalDate data, String nume, int idTrupa, String locatie) {
        this.idConcert = idConcert;
        this.data = data;
        this.nume = nume;
        this.idTrupa = idTrupa;
        this.locatie = locatie;
    }

    public Concert() {

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
