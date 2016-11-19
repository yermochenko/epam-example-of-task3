package domain;

public enum TransportType {
    AVIA("авиа"), RAILWAY("ж/д"), AUTO("авто"), SHIP("лайнер");

    private String name;

    public String getName() {
        return name;
    }

    private TransportType(String name) {
        this.name = name;
    }
}