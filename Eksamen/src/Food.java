public class Food {

    String name;
    boolean isVegan;
    float caloriesPerDay;
    FoodType type;

    // Konstruktør
    public Food(String name, boolean isVegan, float caloriesPerDay, FoodType type) {
        this.name = name;
        this.isVegan = isVegan;
        this.caloriesPerDay = caloriesPerDay;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public float getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(float caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }


}


