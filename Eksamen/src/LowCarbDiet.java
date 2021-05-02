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
        if(person.checkWeightCompatibility(person.getWeight())
                && (person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50)
                && (maxiMumCarbFoodAllowed(allowedFood) <= 2)){
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
    }

    public boolean isCarbTotalCompatible(Food[] allowedFood) {
        if(maxiMumCarbFoodAllowed(allowedFood) <= 2) {
            super.setAllowedFood(allowedFood);
            return true;
        }
        else throw new IllegalArgumentException("Cannot contain more than two");
    }

    public LowCarbDiet(String name, Food[] allowedFood ) {
        super.setName(name);
        super.setAllowedFood(allowedFood);

    }

    public boolean isVeganCompatible(Food[] allowedFood){
        int foodThatIsVegan = 0;
        for (Food food : allowedFood)
            if(food.isVegan)
                foodThatIsVegan++;

        if (foodThatIsVegan != allowedFood.length){
            super.setVegan(false);
            return false;
        }
        else
            super.setVegan(true);
        new LowCarbDiet("LowCarbVeganComboDiet", allowedFood);
        System.out.println("Lowcarb diet is compatible with this food");
        return true;
    }


    public int maxiMumCarbFoodAllowed(Food[] carbFoods){
        int maximumCarbsALlowed = 0;
        for (Food carbFood : carbFoods) if (carbFood.getType() == FoodType.Carb) maximumCarbsALlowed++;
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
