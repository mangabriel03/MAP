package domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Album {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAlbum;
    @Column(name = "titlu")
    private String titlu;
    @Column(name = "anLansare")
    private LocalDate anLansare;
    @Column(name = "idTrupa")
    private int idTrupa;

    public Album(int idAlbum,int idTrupa ,String titlu, LocalDate anLansare) {
        this.idAlbum = idAlbum;
        this.idTrupa = idTrupa;
        this.titlu = titlu;
        this.anLansare = anLansare;
    }
    public Album(int idAlbum,String titlu, LocalDate anLansare) {
        this.idAlbum = idAlbum;
        //this.idTrupa = idTrupa;
        this.titlu = titlu;
        this.anLansare = anLansare;
    }

    public Album() {

    }


    public int getIdTrupa() {
        return idTrupa;
    }

    public void setIdTrupa(int idTrupa) {
        this.idTrupa = idTrupa;
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public LocalDate getAnLansare() {
        return anLansare;
    }

    public void setAnLansare(LocalDate anLansare) {
        this.anLansare = anLansare;
    }


    @Override
    public String toString() {
        return "Album{" +
                "idAlbum=" + idAlbum +
                ", titlu='" + titlu + '\'' +
                ", anLansare=" + anLansare +
                ", idTrupa=" + idTrupa +
                '}';
    }
}
