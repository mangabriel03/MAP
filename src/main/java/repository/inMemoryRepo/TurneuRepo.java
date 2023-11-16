package repository.inMemoryRepo;

import domain.Concert;
import domain.Turneu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TurneuRepo {
    private final List<Turneu> turnee = new ArrayList<>();

    private int nextIdTurneu = 1;
    public Turneu createTurneu(String nume, LocalDate dataInceput, LocalDate dataSfarsit, String locatie, List<Concert> concerte){
        Turneu turneu = new Turneu(nextIdTurneu, nume, dataInceput, dataSfarsit, locatie, concerte);
        nextIdTurneu++;
        turnee.add(turneu);
        return turneu;
    }

    public Turneu getTurneuById(int id){
        for (Turneu t : turnee){
            if (t.getIdTurneu() == id)
                return t;
        }
        return null;
    }
    public List<Turneu> getAllTurnee(){
        return this.turnee;
    }

    public Turneu updateTurneu(Turneu turneu){
        for (Turneu t : turnee){
            if (t.getIdTurneu() == turneu.getIdTurneu()){
                t.setDataInceput(turneu.getDataInceput());
                t.setDataSfarsit(turneu.getDataSfarsit());
                t.setNume(turneu.getNume());
                t.setLocatie(t.getLocatie());

            }
        }
        return turneu;
    }

    public void removeTurneu(int id){
        Turneu turneuToRemove = getTurneuById(id);
        if (turneuToRemove != null)
            turnee.remove(turneuToRemove);
    }


}
