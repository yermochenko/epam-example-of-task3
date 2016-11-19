package domain;

public class HotelCharacteristic {
    private Integer starsCount;
    private FoodType food;
    private boolean TV;

    public Integer getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(Integer starsCount) {
        this.starsCount = starsCount;
    }

    public FoodType getFood() {
        return food;
    }

    public void setFood(FoodType food) {
        this.food = food;
    }

    public boolean isTV() {
        return TV;
    }

    public void setTV(boolean tV) {
        TV = tV;
    }
}