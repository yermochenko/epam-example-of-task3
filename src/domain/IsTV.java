package domain;

public class IsTV extends HotelCharacteristic {
    public IsTV() {
        super("Есть ли телевизор");
    }

    private Boolean is;

    @Override
    public void setValue(String value) {
        is = Boolean.parseBoolean(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(is);
    }
}