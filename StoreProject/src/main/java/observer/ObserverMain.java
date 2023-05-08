package observer;

import observer.listeners.Customer;
import observer.listeners.EmailCustomerListener;
import observer.listeners.SMSCustomerListener;

public class ObserverMain {
    public static final String BACK_IN_STOCK_MESSAGE = "The item is back in stock!";
    public static final String ITEM_SALE_MESSAGE = "The item is now on sale!";


    public static void main(String[] args){
        Item item1 = new Item("Printer", "HP", 300.0);
        Item item2 = new Item("Laptop", "Lenovo", 2522.8);
        Store store = new Store(item1, item2);

        Customer c1 = new EmailCustomerListener("customer1@mail.com");
        Customer c2 = new EmailCustomerListener("customer2@gmail.com");
        Customer c3 = new SMSCustomerListener("0711111111");

        store.subscribe(item1, c1, BACK_IN_STOCK_MESSAGE);
        store.subscribe(item1, c2, ITEM_SALE_MESSAGE);
        store.subscribe(item2, c3, BACK_IN_STOCK_MESSAGE);

        store.notify(item1, BACK_IN_STOCK_MESSAGE);
        store.notify(item1, ITEM_SALE_MESSAGE);
        store.notify(item2, BACK_IN_STOCK_MESSAGE);
        store.notify(item2, ITEM_SALE_MESSAGE);

    }
}
