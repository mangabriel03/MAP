package ObserverLogic;

public interface EvenimentObservable {
    void adaugaObserver(EvenimentObserver observer);
    void stergeObserver(EvenimentObserver observer);
    void notificaObservatori(String mesaj);
}
