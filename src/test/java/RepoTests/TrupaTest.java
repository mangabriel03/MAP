package RepoTests;

import org.example.domain.Trupa;
import org.example.repository.inMemoryRepo.TrupaRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrupaTest {
    private TrupaRepo trupaRepo;

    @BeforeEach
    void setUp() {
        trupaRepo = new TrupaRepo();
    }

    @Test
    void excetionTest(){
        Trupa created = trupaRepo.createTrupa("", 1, 2000);
        assertNotNull(created.getNumeTrupa());
    }
    @Test
    void createAndGetTrupa() {
        Trupa created = trupaRepo.createTrupa("Trupa1", 1, 2000);
        Trupa retrieved = trupaRepo.getTrupaById(created.getIdTrupa());
        assertNotNull(retrieved);
        assertEquals(created, retrieved);
    }

    @Test
    void getAllTrupe() {
        Trupa trupa1 = trupaRepo.createTrupa("Trupa1", 1, 2000);
        Trupa trupa2 = trupaRepo.createTrupa("Trupa2", 2, 2005);

        List<Trupa> allTrupe = trupaRepo.getAllTrupe();
        assertNotNull(allTrupe);
        assertEquals(2, allTrupe.size());
        assertTrue(allTrupe.contains(trupa1));
        assertTrue(allTrupe.contains(trupa2));
    }

    @Test
    void updateTrupa() {
        Trupa created = trupaRepo.createTrupa("Trupa1", 1, 2000);
        Trupa updated = new Trupa(created.getIdTrupa(), "Updated Trupa", 2, 2005);

        Trupa result = trupaRepo.updateTrupa(updated);
        assertNotNull(result);
        assertEquals(updated, result);

        Trupa retrieved = trupaRepo.getTrupaById(created.getIdTrupa());
        assertNotNull(retrieved);
        assertEquals(updated.getIdTrupa(), retrieved.getIdTrupa());
        assertEquals(updated.getNumeTrupa(), retrieved.getNumeTrupa());
    }

    @Test
    void removeTrupa() {
        Trupa created = trupaRepo.createTrupa("Trupa1", 1, 2000);
        int trupaId = created.getIdTrupa();
        trupaRepo.removeTrupa(trupaId);
        assertTrue(trupaRepo.getTrupaById(trupaId) == null);
        assertNull(trupaRepo.getTrupaById(trupaId));
    }



    // EXCEPTIONS TESTS


    @Test
    void testCreateTrupaWithInvalidYear() {
        assertThrows(IllegalArgumentException.class, () -> {
            trupaRepo.createTrupa("Trupa1", 1, 2030);
        });
    }

    @Test
    void testUpdateNonExistentTrupa() {
        assertThrows(NullPointerException.class, () -> {
            trupaRepo.updateTrupa(new Trupa(999, "Non-Existent Trupa", 2, 2005));
        });
    }

    @Test
    void testGetTrupaByInvalidID() {
        assertThrows(IllegalArgumentException.class, () -> {
            trupaRepo.getTrupaById(-1);
        });
    }
}
