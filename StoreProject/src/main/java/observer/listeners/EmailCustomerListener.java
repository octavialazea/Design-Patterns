package observer.listeners;


import observer.Item;

public class EmailCustomerListener implements  Customer{

    private String email;

    public EmailCustomerListener(String email){
        this.email = email;
    }

    @Override
    public void update(String eventType, Item item) {
        System.out.println("Email sent to " + email + ": " + eventType + " item: " + item.toString());
    }
}
