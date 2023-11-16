package repository.inMemoryRepo;

import domain.Manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerRepo {
    private final List<Manager> manageri = new ArrayList<>();
    private int nextIdManager = 1;
    public Manager createManager(String nume, String prenume, LocalDate dataNasterii){
        Manager manager = new Manager(nextIdManager, nume, prenume, dataNasterii);
        if (manager.getDataNasterii().isAfter(LocalDate.now()))
            throw new IllegalArgumentException();

        manageri.add(manager);
        nextIdManager++;
        return manager;
    }

    public Manager getManagerById(int id){
        if (id < 0)
            throw new IllegalArgumentException();

        for (Manager manager : manageri){
            if (manager.getIdManager() == id)
                return manager;
        }
        return null;
    }

    public List<Manager> getAllManageri(){
        return this.manageri;
    }

    public Manager updateManager(Manager manager){
        for (Manager m : manageri){
            if (m.getIdManager() == manager.getIdManager()){
                m.setIdManager(manager.getIdManager());
                m.setNume(manager.getNume());
                m.setPrenume(manager.getPrenume());
                m.setDataNasterii(manager.getDataNasterii());
            }
        }
        return manager;
    }

    public void removeManager(int id){
        Manager managerToRemove = getManagerById(id);
        if (managerToRemove != null)
            manageri.remove(managerToRemove);
    }
}
