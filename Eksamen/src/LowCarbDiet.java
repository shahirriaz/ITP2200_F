public class LowCarbDiet extends Diet {


    Float minWeightKg;

    public LowCarbDiet(){}

    public LowCarbDiet(Float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }

    public LowCarbDiet(Food[] allowedFood, Float minWeightKg) {
        this.minWeightKg = minWeightKg;
        throwError(allowedFood);
        super.setAllowedFood(allowedFood);

    }

    private void throwError(Food[] allowedFood) {
        if (maxiMumCarbFoodAllowed(allowedFood) > 2)
            throw new IllegalArgumentException("Cannot contain more than two carb foods");
    }

    public LowCarbDiet(Food[] allowedFood ) {
        throwError(allowedFood);
        super.setAllowedFood(allowedFood);

        if (isVeganOrNot(allowedFood) == allowedFood.length)
            super.setVegan(true);

    }

    public int isVeganOrNot(Food[] allowedFood){
        int foodThatIsVegan = 0;
        for (Food food : allowedFood) {
            if (food.isVegan)
                foodThatIsVegan++;
        }
        return foodThatIsVegan;


    }
    public LowCarbDiet(String name){
        super.setName(name);
    }

    public LowCarbDiet(Food food){
        if(food.isVegan)
            super.setFood(food);
        else
            throw new IllegalArgumentException("Cannot follow vegan diet");
    }


    public int maxiMumCarbFoodAllowed(Food[] carbFoods){
        int maximumCarbsALlowed = 0;
        for (Food carbFood : carbFoods) {
            if (carbFood.getType() == FoodType.Carb) {
                maximumCarbsALlowed++;
            }
        }
        return maximumCarbsALlowed;
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


    public Float getMinWeightKg() {
        return minWeightKg;
    }

    public void setMinWeightKg(Float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }

    @Override
    public boolean isCompatible(Person person) {
        return false;
    }
}
