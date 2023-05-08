package adapter;

public class SocketAdapterImpl extends Socket implements SocketAdapter {
    @Override
    public Volt to120Volt() {
        return getVolt();
    }

    @Override
    public Volt to12Volt() {
        Volt initialVolt = getVolt();
        return convert(initialVolt, 10);
    }

    @Override
    public Volt to3Volt() {
        Volt initialVolt = getVolt();
        return convert(initialVolt, 40);
    }

    private Volt convert(Volt volt, int i){
        return new Volt(volt.getVolts()/i);
    }
}
