package mvc;
import java.util.*;
public class Publisher {
    private List<Subscriber> observers = new LinkedList<>();
    public void subscribe(Subscriber s) {observers.add(s);}
    public void unsubscribe(Subscriber s) {observers.remove(s);}
    public void notifySubscribers() {
        for (Subscriber s: observers) {
            s.update();
        }
    }
}
