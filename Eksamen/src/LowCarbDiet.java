public class LowCarbDiet extends Diet {


    Float minWeightKg;

    public LowCarbDiet(){}

    public LowCarbDiet(String name){
        super.setName(name);
    }

    public LowCarbDiet(Float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }

    @Override
    public boolean canBeFollowedOrNotBy(Person person) {
        if(person.checkWeightCompatibility(person.getWeight()) && (person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50) &&
                (maxiMumCarbFoodAllowed(allowedFood) <= 2)
                && person.getFavoriteFood().isVegan && (!(person.diet instanceof VeganDiet))

        ){
                 person.setDiet(person.diet);
                 return true;
        }else
            throw new IllegalArgumentException("This diet cannot be followed");
    }


    public LowCarbDiet(String name, Food[] allowedFood, Float minWeightKg) {
        super.setName(name);
        super.setAllowedFood(allowedFood);
        this.minWeightKg = minWeightKg;
    }


    public LowCarbDiet(Food[] allowedFood ) {
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

}
