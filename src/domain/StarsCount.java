package domain;

public class StarsCount extends HotelCharacteristic {
    public StarsCount() {
        super("Количество звёзд");
    }

    private Integer count;

    @Override
    public void setValue(String value) {
        count = Integer.parseInt(value);
    }

    @Override
    public String getValue() {
        return String.valueOf(count);
    }
}