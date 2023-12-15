package domain;

import jakarta.persistence.*;

@Entity
public class Persoana {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPersoana;
    @Column(name = "nume")
    private String nume;
    @Column(name = "prenume")
    private String prenume;
    public Persoana(){
    }

    public Persoana(int idPersoana, String nume, String prenume) {
        this.idPersoana = idPersoana;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getIdPersoana() {
        return idPersoana;
    }

    public void setIdPersoana(int idPersoana) {
        this.idPersoana = idPersoana;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "idPersoana=" + idPersoana +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
