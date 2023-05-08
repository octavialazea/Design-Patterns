package observer;

import adapter2.MessageAdapter;
import adapter2.MessageLogger;
import observer.listeners.Customer;

import java.io.IOException;
import java.util.*;

public class Store {
    Map<Item, List<Event>> listeners = new HashMap<>();

    public Store(Item... items) {
        for (Item item : items)
            this.listeners.put(item, new ArrayList<>());
    }

    public void addListener(Item item) {
        this.listeners.put(item, new ArrayList<>());
    }

    public void subscribe(Item item, Customer customer, String eventType) {
        List<Event> customers = listeners.get(item);
        Event event = new Event(customer, eventType);
        customers.add(event);
    }

    public void unsubscribe(Item item, Customer customer) {
        List<Event> customers = listeners.get(item);
        Event event = customers.stream().filter(it -> it.getCustomer().equals(customer)).findFirst().get();
        customers.remove(event);
    }

    public void notify(Item item, String eventType) {
        List<Event> customers = listeners.get(item);
        customers.stream().filter(it -> it.getMessage().equals(eventType)).forEach(it -> {
            it.getCustomer().update(it.getMessage(), item);
            MessageAdapter adapter = new MessageAdapter(it);
            try {
                adapter.convert();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
//        for (var customer : customers) {
//            if (Objects.equals(customer.getMessage(), eventType))
//                customer.getCustomer().update(customer.getMessage(), item);
//        }
    }
}
