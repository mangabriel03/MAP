package repository.inMemoryRepo;

import ObserverLogic.EvenimentObservable;
import ObserverLogic.EvenimentObserver;
import ObserverLogic.Observer;
import domain.Concert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConcertRepo implements EvenimentObservable {
    private final List<Concert> concerte = new ArrayList<>();
    private int nextConcertId = 1;
    private Observer observer;
    private List<EvenimentObserver> evenimentObservers = new ArrayList<>();


    public Concert createConcert(LocalDate data, String nume, int idTrupa, String locatie){
        Concert concert = new Concert(nextConcertId, data, nume, idTrupa, locatie);
        concerte.add(concert);
        nextConcertId++;

        notificaObservatori("Concert creat " + concert.getIdConcert());

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
        //evenimentObserver.update("repo method called: " + concert);
        notificaObservatori("Concert actualizat : " + concert.getIdConcert());
        return concert;
    }

    public void removeConcert(int id){
        Concert concertToRemove = getConcertById(id);
        if (concertToRemove != null)
            concerte.remove(concertToRemove);
        notificaObservatori("Concert sters :" + id);
    }


    @Override
    public void adaugaObserver(EvenimentObserver observer) {
        evenimentObservers.add(observer);
    }

    @Override
    public void stergeObserver(EvenimentObserver observer) {
        evenimentObservers.remove(observer);
    }

    @Override
    public void notificaObservatori(String mesaj) {
        for (EvenimentObserver evenimentObserver1 : evenimentObservers)
            evenimentObserver1.update(mesaj);
    }
}
