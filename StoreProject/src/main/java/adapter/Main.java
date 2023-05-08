package adapter;

public class Main {
    private static final SocketAdapter socketAdapter = new SocketAdapterImpl();

    public static void main(String[] args){
        Volt v1 = socketAdapter.to120Volt();
        System.out.println("v1 = " + v1.getVolts() + " volts");
        Volt v2 = socketAdapter.to12Volt();
        System.out.println("v2 = " + v2.getVolts() + " volts");
        Volt v3 = socketAdapter.to3Volt();
        System.out.println("v3 = " + v3.getVolts() + " volts");
    }
}
