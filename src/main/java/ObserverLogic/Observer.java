package ObserverLogic;

import java.util.ArrayList;
import java.util.List;

public class Observer implements EvenimentObserver{

    private static List<String> Evenimente = new ArrayList<>();


    public void update(String mesaj) {
        Evenimente.add(mesaj);

    }

    @Override
    public void printEvents() {

    }

    @Override
    public void clearEvents() {
        Evenimente = new ArrayList<>();

    }


}
