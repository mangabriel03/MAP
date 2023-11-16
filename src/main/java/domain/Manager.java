package domain;

import java.time.LocalDate;

public class Manager extends Persoana{
    private int idManager;
    private String nume;
    private String prenume;
    private LocalDate dataNasterii;

    public Manager(int idManager, String nume, String prenume, LocalDate dataNasterii) {
        super(idManager, nume, prenume);
        this.dataNasterii = dataNasterii;
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
