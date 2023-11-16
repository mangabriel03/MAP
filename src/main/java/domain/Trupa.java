package domain;

import java.util.ArrayList;
import java.util.List;

public class Trupa {
    private int idTrupa;
    private String numeTrupa;
    private int idManager;
    private int anFormare;
    private List<MembruTrupa> membriiTrupa; //aici tinem id-urile membrilor unei trupe.

    public Trupa(int idTrupa, String numeTrupa, int idManager, int anFormare) {
        this.idTrupa = idTrupa;
        this.numeTrupa = numeTrupa;
        this.idManager = idManager;
        this.anFormare = anFormare;
        this.membriiTrupa = new ArrayList<MembruTrupa>();
        for (MembruTrupa membruTrupa : membriiTrupa){
            membruTrupa = new MembruTrupa(); // compozitia
        }
    }

    public int getIdTrupa() {
        return idTrupa;
    }

    public void setIdTrupa(int idTrupa) {
        this.idTrupa = idTrupa;
    }

    public String getNumeTrupa() {
        return numeTrupa;
    }

    public void setNumeTrupa(String numeTrupa) {
        this.numeTrupa = numeTrupa;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public int getanFormare() {
        return anFormare;
    }

    public void setanFormare(int anFormare) {
        this.anFormare = anFormare;
    }

    @Override
    public String toString() {
        String membrii="";
        for(MembruTrupa membru : membriiTrupa){
            membrii+=membru.toString()+" ";
        }
        return "Trupa{" +
                "idTrupa=" + idTrupa +
                ", numeTrupa='" + numeTrupa + '\'' +
                ", idManager=" + idManager +
                ", anFormare=" + anFormare +
                ", listaIdMembrii=" + membrii +
                '}';
    }
}
