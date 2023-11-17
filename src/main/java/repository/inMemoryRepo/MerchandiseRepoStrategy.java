package repository.inMemoryRepo;

import domain.AdaugaAdaosPretStrategy;
import domain.AplicaDiscountPretStrategy;
import domain.Merchandise;
import domain.PretStrategy;

public class MerchandiseRepoStrategy {
    private PretStrategy pretStrategy; // nou adăugat

    public MerchandiseRepoStrategy(PretStrategy pretStrategy) {
        this.pretStrategy = pretStrategy;
    }

    public void setPretStrategy(PretStrategy pretStrategy) {
        this.pretStrategy = pretStrategy;
    }

    public Merchandise applyAdaos(Merchandise merchandise, float procentAdaos) {
        this.pretStrategy = new AdaugaAdaosPretStrategy(procentAdaos);
        return applyPretStrategy(merchandise);
    }

    public Merchandise applyDiscount(Merchandise merchandise, float procentDiscount) {
        this.pretStrategy = new AplicaDiscountPretStrategy(procentDiscount);
        return applyPretStrategy(merchandise);
    }

    public Merchandise applyPretStrategy(Merchandise merchandise) {
        if (merchandise.getPret() == 0)
            throw new IllegalArgumentException();
        System.out.println(merchandise.getPret());
        float pretCalculat = pretStrategy.calculeazaPret(merchandise.getPret());
        merchandise.setPret(pretCalculat);
        System.out.println(merchandise.getPret());
        return merchandise;
    }
}
