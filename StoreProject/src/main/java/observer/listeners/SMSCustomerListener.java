package observer.listeners;

import observer.Item;

public class SMSCustomerListener implements Customer{

    private String phoneNumber;

    public SMSCustomerListener(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String eventType, Item item) {
        System.out.println("SMS sent to " + phoneNumber + ": " + eventType + " item: " + item.toString());

    }
}
