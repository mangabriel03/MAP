package domain;

import jakarta.persistence.*;
@Entity
public class Merchandise {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProdus;
    @Column(name = "numeProdus")
    private String numeProdus;
    @Column(name = "stoc")
    private int stoc;
    @Column(name = "pret")
    private float pret;

    @Column(name = "idTrupa")
    private int idTrupa;
    private PretStrategy pretStrategy;
    public Merchandise(int idProdus, String numeProdus, int stoc, float pret, int idTrupa) {
        this.idProdus = idProdus;
        this.numeProdus = numeProdus;
        this.stoc = stoc;
        this.pret = pret;
        this.idTrupa = idTrupa;
        this.pretStrategy = new AplicaDiscountPretStrategy(0); // Setați o strategie implicită
    }

    public Merchandise() {

    }

    public void setPretStrategy(PretStrategy pretStrategy) {
        this.pretStrategy = pretStrategy;
    }
    public void aplicaStrategiePret() {
        this.pret = pretStrategy.calculeazaPret(pret);
    }

    public int getIdProdus() {
        return idProdus;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getIdTrupa() {
        return idTrupa;
    }

    public void setIdTrupa(int idTrupa) {
        this.idTrupa = idTrupa;
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "idProdus=" + idProdus +
                ", numeProdus='" + numeProdus + '\'' +
                ", stoc=" + stoc +
                ", pret=" + pret +
                ", idTrupa=" + idTrupa +
                '}';
    }
}
