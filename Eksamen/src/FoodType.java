package PACKAGE_NAME;

public class FoodType extends Food {

    //Vil ikke ha med enumen??
    FoodType(String name, boolean isVegan, float caloriesPerDay) {
        super(name, isVegan, caloriesPerDay);
        this.type = type;

    }

}
enum type {
    CARB,
    FAT,
    PROTEIN,
    RECIPE;
}