import domain.AdaugaAdaosPretStrategy;
import domain.Merchandise;
import domain.PretStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.inMemoryRepo.ManagerRepo;
import repository.inMemoryRepo.MerchandiseRepo;
import repository.inMemoryRepo.MerchandiseRepoStrategy;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MerchandiseTest {
    private MerchandiseRepo merchandiseRepo;
    private MerchandiseRepoStrategy merchandiseRepoStrategy;
    private Merchandise merchandise;


    @Test
    void applyPretStrategy() {
        float initialPret = 100.0f;
        Merchandise merchandise = new Merchandise(1, "Produs", 10, initialPret, 1);

        PretStrategy pretStrategy = new AdaugaAdaosPretStrategy(10.0f);
        MerchandiseRepoStrategy merchandiseRepoStrategy = new MerchandiseRepoStrategy(pretStrategy);

        Merchandise updatedMerchandise = merchandiseRepoStrategy.applyPretStrategy(merchandise);

        assertNotNull(updatedMerchandise);
        assertEquals(initialPret + (initialPret * 10.0f / 100), updatedMerchandise.getPret(), 0.01); // Verificare adaos
    }
    @Test
    void applyPretStrategyException() {
        Merchandise merchandise = new Merchandise(1, "Produs", 10, 0, 1);  // sau orice altă valoare validă
        MerchandiseRepoStrategy merchandiseRepoStrategy = new MerchandiseRepoStrategy(new AdaugaAdaosPretStrategy(10.0f));

        assertThrows(IllegalArgumentException.class, () -> {
            merchandiseRepoStrategy.applyPretStrategy(merchandise);
        });
    }

}
