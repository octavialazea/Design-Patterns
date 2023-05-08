package controller;

import observer.Item;
import observer.Store;
import observer.listeners.Customer;
import view.ItemView;

public class ItemController {
    private ItemView itemView;
    private Item item;
    private Store store;

    public ItemController(ItemView itemView, Item item) {
        this.itemView = itemView;
        this.item = item;
        this.store = new Store(item);
    }

    public ItemView getItemView() {
        return itemView;
    }

    public void setItemView(ItemView itemView) {
        this.itemView = itemView;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setItemPrice(Double price){
        item.setPrice(price);
    }

    public void updateView(){
        itemView.printItem(item);
    }

    public void storeSubscribe(Customer customer, String eventType){
        store.subscribe(item, customer, eventType);
    }

    public void storeNotify( String eventType){
        store.notify(item, eventType);
    }
}
