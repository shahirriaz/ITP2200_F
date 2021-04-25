public class LowCarbDiet extends Diet {


    Float minWeightKg;

    public LowCarbDiet(){}

    public LowCarbDiet(String name){
        super.setName(name);
    }

    public void maxiMumCarbFoodAllowed(Food[] carbFoods){
        for (Food f: carbFoods)
            if (f.getType() != FoodType.Carb) {
                throw new IllegalArgumentException("This method only accepts carbFoods");
            } else if (carbFoods.length > 2) {
                throw new IllegalArgumentException("Cannot contain more than two carb foods");
            }

        super.setAllowedFood(carbFoods);
    }

    public void setVeganStateToFalse(Food[] food){
        for (Food f: food)
            if (!f.isVegan){
                super.setVegan(false);
                super.setAllowedFood(food);
            }
    }

    public void setVeganStateToTrue(Food[] food){
        for(Food f: food)
            /*if food is not vegan*/
            if (!f.isVegan)
                throw new IllegalArgumentException("A vegan diet cannot contain any non-vegan food");
            else {
                super.setVegan(true);
                super.setAllowedFood(food);
            }
    }


    public LowCarbDiet(String name, int daysDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
    }

    public LowCarbDiet(String name, int daysDuration, int monthDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
        super.setMonthDuration(monthDuration);
    }
}
