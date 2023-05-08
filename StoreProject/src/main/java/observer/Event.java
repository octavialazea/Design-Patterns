package observer;

import observer.listeners.Customer;

public class Event {
    private Customer customer;
    private String message;

    public Event(Customer customer, String message) {
        this.customer = customer;
        this.message = message;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
