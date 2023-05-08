package observer.listeners;

import observer.Item;

import java.io.File;

public interface Customer {
    void update(String eventType, Item item);
}
