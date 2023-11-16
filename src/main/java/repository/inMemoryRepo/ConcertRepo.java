package repository.inMemoryRepo;

import domain.Concert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConcertRepo {
    private final List<Concert> concerte = new ArrayList<>();
    private int nextConcertId = 1;
    public Concert createConcert(LocalDate data, String nume, int idTrupa, String locatie){
        Concert concert = new Concert(nextConcertId, data, nume, idTrupa, locatie);
        concerte.add(concert);
        nextConcertId++;
        return concert;
    }

    public Concert getConcertById(int id){
        for (Concert concert : concerte){
            if (concert.getIdConcert() == id)
                return concert;
        }
        return null;
    }

    public List<Concert> getAllConcerte(){
        return this.concerte;
    }

    public Concert updateConcerte(Concert concert){
        for (Concert c : concerte){
            if (c.getIdConcert() == concert.getIdConcert()){
                c.setIdConcert(concert.getIdConcert());
                c.setIdTrupa(concert.getIdTrupa());
                c.setData(concert.getData());
                c.setNume(concert.getNume());
                c.setLocatie(concert.getLocatie());
            }
        }
        return concert;
    }

    public void removeConcert(int id){
        Concert concertToRemove = getConcertById(id);
        if (concertToRemove != null)
            concerte.remove(concertToRemove);
    }
}
