package ObserverLogic;

import java.util.ArrayList;
import java.util.List;

public class Eveniment implements EvenimentObservable{

    private List<EvenimentObserver> observers = new ArrayList<>();
    @Override
    public void adaugaObserver(EvenimentObserver observer) {
        observers.add(observer);
    }

    @Override
    public void stergeObserver(EvenimentObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificaObservatori(String mesaj) {
        for (EvenimentObserver evenimentObserver : observers)
            evenimentObserver.update(mesaj);
    }

}
