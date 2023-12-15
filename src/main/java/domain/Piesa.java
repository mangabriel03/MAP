package domain;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Piesa {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPiesa;
    @Column(name = "titlu")
    private String titlu;
    @Column(name = "durata")
    private float durata;

    public Piesa(int idPiesa, String titlu, float durata) {
        this.idPiesa = idPiesa;
        this.titlu = titlu;
        this.durata = durata;
    }

    public Piesa() {

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
