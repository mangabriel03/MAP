package RepoTests;

import org.example.domain.Manager;
import org.example.repository.inMemoryRepo.ManagerRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private ManagerRepo managerRepo;

    @BeforeEach
    void setUp() {
        managerRepo = new ManagerRepo();
    }

    @Test
    void createAndGetManager() {
        Manager created = managerRepo.createManager("John", "Doe", LocalDate.of(1990, 5, 15));
        Manager retrieved = managerRepo.getManagerById(created.getIdManager());
        assertNotNull(retrieved);
        assertEquals(created, retrieved);
    }

    @Test
    void getAllManageri() {
        Manager manager1 = managerRepo.createManager("John", "Doe", LocalDate.of(1990, 5, 15));
        Manager manager2 = managerRepo.createManager("Jane", "Smith", LocalDate.of(1985, 8, 20));

        List<Manager> allManageri = managerRepo.getAllManageri();
        assertNotNull(allManageri);
        assertEquals(2, allManageri.size());
        assertTrue(allManageri.contains(manager1));
        assertTrue(allManageri.contains(manager2));
    }

    @Test
    void updateManager() {
        Manager created = managerRepo.createManager("John", "Doe", LocalDate.of(1990, 5, 15));
        Manager updated = new Manager(created.getIdManager(), "Jane", "Smith", LocalDate.of(1985, 8, 20));

        Manager result = managerRepo.updateManager(updated);
        assertNotNull(result);
        assertEquals(updated, result);

        Manager retrieved = managerRepo.getManagerById(created.getIdManager());
        assertNotNull(retrieved);
        assertEquals(updated.getIdManager(), retrieved.getIdManager());
        assertEquals(updated.getNume(), retrieved.getNume());
        assertEquals(updated.getPrenume(), retrieved.getPrenume());
    }

    @Test
    void removeManager() {
        Manager created = managerRepo.createManager("John", "Doe", LocalDate.of(1990, 5, 15));
        int managerId = created.getIdManager();
        managerRepo.removeManager(managerId);
        assertNull(managerRepo.getManagerById(managerId));
    }


    //EXCEPTIONSSS

    @Test
    void testCreateManagerWithInvalidDateOfBirth() {
        assertThrows(IllegalArgumentException.class, () -> {
            managerRepo.createManager("John", "Doe", LocalDate.of(2030, 1, 1));
        });
    }
}
