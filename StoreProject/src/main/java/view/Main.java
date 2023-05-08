package view;

import adapter2.MessageAdapter;
import builder.StandardItemBuilder;
import controller.ItemController;
import observer.Item;
import observer.Store;
import observer.listeners.Customer;
import observer.listeners.EmailCustomerListener;
import observer.listeners.SMSCustomerListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static final String BACK_IN_STOCK_MESSAGE = "The item is back in stock!";
    public static final String ITEM_SALE_MESSAGE = "The item is now on sale!";


    public static void main(String[] args) throws IOException {
        ItemView itemView = new ItemViewConsole();
        StandardItemBuilder itemBuilder = new StandardItemBuilder();

        itemBuilder.buildItem();
        itemBuilder.buildName("Printer");
        itemBuilder.buildBrand("HP");
        itemBuilder.buildPrice(3000.0);
        Item item1 = itemBuilder.getItem();
        Item item2 = new Item("Laptop", "Lenovo", 2522.8);


        ItemController itemController1 = new ItemController(itemView, item1);
        ItemController itemController2 = new ItemController(itemView, item2);


        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));


        Customer c1 = new EmailCustomerListener("customer1@mail.com");
        Customer c2 = new EmailCustomerListener("customer2@gmail.com");
        Customer c3 = new SMSCustomerListener("0711111111");


        itemController1.storeSubscribe(c1, BACK_IN_STOCK_MESSAGE);
        itemController2.storeSubscribe(c2, BACK_IN_STOCK_MESSAGE);
        itemController1.storeSubscribe(c3, ITEM_SALE_MESSAGE);


        // MENU
        while (true) {
            System.out.println("""
                    MENU:
                    \t0. EXIT
                    \t1. BACK IN STOCK - notify customers
                    \t2. ITEM SALE - notify customers
                    \t3. SET NEW PRICE FOR ITEM1
                    \t4. SET NEW PRICE FOR ITEM2
                    \t5. SEE CURRENT ITEM STATES
                    """);
            String messageType = reader.readLine();
            if (Objects.equals(messageType, "0"))
                break;
            else if (Objects.equals(messageType, "1")) {
                itemController1.storeNotify(BACK_IN_STOCK_MESSAGE);
                itemController2.storeNotify(BACK_IN_STOCK_MESSAGE);
            } else if (Objects.equals(messageType, "2")) {
                itemController1.storeNotify(ITEM_SALE_MESSAGE);
                itemController2.storeNotify(ITEM_SALE_MESSAGE);
            } else if (Objects.equals(messageType, "3")) {
                System.out.println("New price: ");
                String newPriceString = reader.readLine();
                Double newPrice = Double.parseDouble(newPriceString);
                itemController1.setItemPrice(newPrice);
                itemController1.updateView();
            } else if (Objects.equals(messageType, "4")) {
                System.out.println("New price: ");
                String newPriceString = reader.readLine();
                Double newPrice = Double.parseDouble(newPriceString);
                itemController2.setItemPrice(newPrice);
                itemController2.updateView();
            } else if (Objects.equals(messageType, "5")) {
                itemController1.updateView();
                System.out.println("\n");
                itemController2.updateView();
                System.out.println("\n");
            }

        }

    }
}
