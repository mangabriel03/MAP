package domain;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Manager extends Persoana{
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idManager;
    @Column(name = "nume")
    private String nume;
    @Column(name = "prenume")
    private String prenume;
    @Column(name = "dataNasterii")
    private LocalDate dataNasterii;

    public Manager(int idManager, String nume, String prenume, LocalDate dataNasterii) {
        super(idManager, nume, prenume);
        this.dataNasterii = dataNasterii;
    }

    public Manager() {

    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
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

    public LocalDate getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(LocalDate dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "idManager=" + idManager +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii=" + dataNasterii +
                '}';
    }
}
