package domain;

import java.time.LocalDate;

public class MembruTrupa extends Persoana{
    private int idMembru;
    private String nume;
    private String prenume;
    private LocalDate dataNasterii;
    private int idTrupa;

    public MembruTrupa(){
        super();
    }

    public MembruTrupa(int idMembru, String nume, String prenume, LocalDate dataNasterii, int idTrupa) {
        super(idMembru, nume, prenume);
        this.dataNasterii = dataNasterii;
        this.idTrupa = idTrupa;
    }

    public int getIdMembru() {
        return idMembru;
    }

    public void setIdMembru(int idMembru) {
        this.idMembru = idMembru;
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

    public int getIdTrupa() {
        return idTrupa;
    }

    public void setIdTrupa(int idTrupa) {
        this.idTrupa = idTrupa;
    }

    @Override
    public String toString() {
        return "MembruTrupa{" +
                "idMembru=" + idMembru +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii=" + dataNasterii +
                ", idTrupa=" + idTrupa +
                '}';
    }
}
