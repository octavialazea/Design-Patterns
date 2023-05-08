package adapter2;

import singleton.Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MessageLogger {

    private volatile static MessageLogger instance;

    MessageLogger() {
    }

    public static MessageLogger getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new MessageLogger();

                }
            }
        }
        return instance;
    }

    public void writeToFile(String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("messageLogs.txt", true));
        writer.write(message);

        writer.close();
    }
}
