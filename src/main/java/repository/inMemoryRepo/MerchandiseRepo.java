package repository.inMemoryRepo;

import domain.Merchandise;
import domain.PretStrategy;

import java.util.ArrayList;
import java.util.List;

public class MerchandiseRepo {
    private final List<Merchandise> merchandiseList = new ArrayList<>();
    private int nextIdMerchandise = 1;
    private final PretStrategy pretStrategy = pret -> 0;
    private final MerchandiseRepoStrategy merchandiseRepoStrategy = new MerchandiseRepoStrategy(pretStrategy);
    public Merchandise createMerchandise(String numeProdus, int stoc, float pret,  int idTrupa){
        Merchandise merchandise = new Merchandise(nextIdMerchandise,numeProdus,stoc,pret,idTrupa);
        nextIdMerchandise++;
        merchandiseList.add(merchandise);
        return merchandise;
    }
//    public void setMerchandiseRepoStrategy(MerchandiseRepoStrategy merchandiseRepoStrategy) {
//        this.merchandiseRepoStrategy = merchandiseRepoStrategy;
//    }
//    public Merchandise updateMerchandiseStrategy(Merchandise merchandise) {
//        return merchandiseRepoStrategy.applyPretStrategy(merchandise);
//    }


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
            {
                m.setPret(merchandise.getPret());
                m.setStoc(merchandise.getStoc());
                m.setNumeProdus(merchandise.getNumeProdus());
            }
        }
        return merchandise;
    }

    public void removeMerchandise(int id){
        Merchandise merchandiseToRemove = getMerchandiseById(id);
        if (merchandiseToRemove != null)
            merchandiseList.remove(merchandiseToRemove);
    }
}
