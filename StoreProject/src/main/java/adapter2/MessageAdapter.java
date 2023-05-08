package adapter2;

import observer.Event;

import java.io.IOException;

public class MessageAdapter extends MessageLogger {

    private Event event;

    public MessageAdapter(Event event) {
        super();
        this.event = event;
    }

    public void convert() throws IOException {
        writeToFile("client: " + event.getCustomer().toString() + "; message: " + event.getMessage() + '\n');
    }
}
