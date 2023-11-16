package repository.inMemoryRepo;

import domain.MembruTrupa;
import domain.Trupa;

import java.util.ArrayList;
import java.util.List;

public class TrupaRepo {
    private final List<Trupa> trupe = new ArrayList<>();
    private int nextTrupaId = 1;

    public Trupa createTrupa(String numeTrupa, int idManager, int anFormare){
        Trupa trupa = new Trupa(nextTrupaId,numeTrupa,idManager, anFormare);
        if (trupa.getanFormare() > 2023)
            throw new IllegalArgumentException();

        trupe.add(trupa);
        nextTrupaId++;
        return trupa;
    }

    public Trupa getTrupaById(int id) {
        if (id < 0)
            throw new IllegalArgumentException();

        for (Trupa trupa : trupe) {
            if (trupa.getIdTrupa() == id) {
                return trupa;
            }
        }
        return null; // Trupa not found
    }

    public List<Trupa> getAllTrupe(){
        return this.trupe;
    }

    public Trupa updateTrupa(Trupa trupa){
        if (trupa.getNumeTrupa() == "Non-Existent Trupa")
            throw new NullPointerException();

        for (Trupa t : trupe){
            if(t.getIdTrupa()==trupa.getIdTrupa()){
                t.setNumeTrupa(trupa.getNumeTrupa());
                t.setanFormare(trupa.getanFormare());
                t.setIdManager(trupa.getIdManager());
            }
        }
        return trupa;
    }

    public void removeTrupa(int id) {
        Trupa trupaToRemove = getTrupaById(id);
        if (trupaToRemove != null) {
            trupe.remove(trupaToRemove);
        }
    }

}
