package view;

import observer.Item;

public class ItemViewConsole implements ItemView{
    @Override
    public void printItem(Item item) {
        System.out.println("Item name: " + item.getName());
        System.out.println("Brand: " + item.getBrand());
        System.out.println("Price: " + item.getPrice());
    }
}
