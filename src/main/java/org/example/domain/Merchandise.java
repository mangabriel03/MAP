package org.example.domain;

public class Merchandise {
    private int idProdus;
    private String numeProdus;
    private int stoc;
    private int pret;
    private int idTrupa;

    public Merchandise(int idProdus, String numeProdus, int stoc, int pret, int idTrupa) {
        this.idProdus = idProdus;
        this.numeProdus = numeProdus;
        this.stoc = stoc;
        this.pret = pret;
        this.idTrupa = idTrupa;
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

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
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
