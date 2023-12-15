package domain;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Fan extends Persoana{
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFan;
    @Column(name = "nume")
    private String nume;
    @Column(name = "prenume")
    private String prenume;
    @Column(name = "dataNasterii")
    private LocalDate dataNasterii;

    public Fan(int idFan, String nume, String prenume, LocalDate dataNasterii) {
        super(idFan, nume, prenume);
        this.dataNasterii = dataNasterii;
    }

    public Fan() {

    }

    public int getIdFan() {
        return idFan;
    }

    public void setIdFan(int idFan) {
        this.idFan = idFan;
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String getPrenume() {
        return prenume;
    }

    @Override
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public LocalDate getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(LocalDate dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    @Override
    public String toString() {
        return "Fan{" +
                "idFan=" + idFan +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii=" + dataNasterii +
                '}';
    }
}
