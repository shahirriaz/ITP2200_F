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


}


