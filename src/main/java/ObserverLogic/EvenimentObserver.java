package ObserverLogic;

public interface EvenimentObserver {
    void update(String mesaj);

    void printEvents();
    void clearEvents();

}
