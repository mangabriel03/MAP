package repository.inMemoryRepo;

import domain.MembruTrupa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MembruTrupaRepo {
    private final List<MembruTrupa> membriiTrupa = new ArrayList<>();
    private int nextMembruId = 1;
    public MembruTrupa createMembruTrupa(String nume, String prenume, LocalDate dataNasterii, int idTrupa){
        MembruTrupa membruTrupa = new MembruTrupa(nextMembruId, nume, prenume, dataNasterii, idTrupa);
        membriiTrupa.add(membruTrupa);
        nextMembruId++;
        return membruTrupa;
    }

    public MembruTrupa getMembruById(int id){
        for (MembruTrupa membruTrupa : membriiTrupa){
            if (membruTrupa.getIdTrupa() == id)
                return membruTrupa;
        }
        return null;
    }

    public List<MembruTrupa> getAllMembrii(){
        return this.membriiTrupa;
    }

    public MembruTrupa updateMembruTrupa(MembruTrupa membruTrupa){

        for (MembruTrupa membru : membriiTrupa){
            if (membru.getIdMembru() == membruTrupa.getIdMembru()){
                membru.setNume(membruTrupa.getNume());
                membru.setPrenume(membruTrupa.getPrenume());
                membru.setDataNasterii(membruTrupa.getDataNasterii());
            }
        }
        return membruTrupa;
    }

    public void removeMembruTrupa(int id){
        MembruTrupa membruToRemove = getMembruById(id);
        if (membruToRemove != null)
            membriiTrupa.remove(membruToRemove);
    }
}
