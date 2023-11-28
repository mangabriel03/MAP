package ObserverLogic;

public class ConcertObserver implements EvenimentObserver{



    @Override
    public void update(String mesaj) {
        System.out.println("Observer a primit următorul mesaj: " + mesaj);
    }

    @Override
    public void printEvents() {

    }

    @Override
    public void clearEvents() {

    }
}
