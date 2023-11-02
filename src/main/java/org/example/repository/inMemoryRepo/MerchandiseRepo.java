package org.example.repository.inMemoryRepo;

import org.example.domain.Merchandise;

import java.util.ArrayList;
import java.util.List;

public class MerchandiseRepo {
    private final List<Merchandise> merchandiseList = new ArrayList<>();
    private int nextIdMerchandise = 1;

    public Merchandise createMerchandise(String numeProdus, int stoc, float pret,  int idTrupa){
        Merchandise merchandise = new Merchandise(nextIdMerchandise,numeProdus,stoc,pret,idTrupa);
        nextIdMerchandise++;
        merchandiseList.add(merchandise);
        return merchandise;
    }

    public Merchandise getMerchandiseById(int id){
        for (Merchandise m : merchandiseList){
            if (m.getIdProdus() == id)
                return m;
        }
        return null;
    }

    public List<Merchandise> getAllMerchandise(){
        return this.merchandiseList;
    }

    public Merchandise updateMerchandise(Merchandise merchandise){
        for (Merchandise m : merchandiseList){
            if (m.getIdProdus() == merchandise.getIdProdus())
                return merchandise;
        }
        return null;
    }

    public void removeMerchandise(int id){
        Merchandise merchandiseToRemove = getMerchandiseById(id);
        if (merchandiseToRemove != null)
            merchandiseList.remove(merchandiseToRemove);
    }
}
