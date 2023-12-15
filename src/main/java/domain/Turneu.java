package domain;

import org.apache.commons.lang3.builder.EqualsExclude;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Turneu {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTurneu;
    @Column(name = "nume")
    private String nume;
    @Column (name = "dataInceput")
    private LocalDate dataInceput;
    @Column(name = "dataSfarsit")
    private LocalDate dataSfarsit;
    @Column(name = "locatie")
    private String locatie;
    @OneToMany
    private List<Concert> concerte;

    public Turneu(int idTurneu, String nume, LocalDate dataInceput, LocalDate dataSfarsit, String locatie, List<Concert> concerte ) {
        this.idTurneu = idTurneu;
        this.nume = nume;
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.locatie = locatie;
        this.concerte = concerte;
    }

    public Turneu() {

    }


    public int getIdTurneu() {
        return idTurneu;
    }

    public void setIdTurneu(int idTurneu) {
        this.idTurneu = idTurneu;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public LocalDate getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(LocalDate dataInceput) {
        this.dataInceput = dataInceput;
    }

    public LocalDate getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataSfarsit(LocalDate dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public List<Concert> getConcerte() {
        return concerte;
    }

    public void setConcerte(List<Concert> concerte) {
        this.concerte = concerte;
    }

    @Override
    public String toString() {
        return "Turneu{" +
                "idTurneu=" + idTurneu +
                ", nume='" + nume + '\'' +
                ", dataInceput=" + dataInceput +
                ", dataSfarsit=" + dataSfarsit +
                ", locatie='" + locatie + '\'' +
                ", concerte=" + concerte +
                '}';
    }
}
