import org.junit.jupiter.api.Test;
import singleton.Singleton;

import static org.junit.jupiter.api.Assertions.*;


public class SingletonTest {
    @Test
    void testSingleton(){
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        assertSame(singleton1, singleton2);
    }
}
