public class HyperCaloricDiet extends Diet {


    Float maxWeightKg;
    Float minCaloriesPerDay;

    public HyperCaloricDiet() {

    }


    @Override
    public boolean canBeFollowedOrNotBy(Person person) {
        if(person.getFavoriteFood().isVegan && (!(person.diet instanceof VeganDiet))
                && person.checkWeightCompatibility2(person.getWeight())
                && person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50){
            person.setDiet(person.diet);
            return true;
        }else
            throw new IllegalArgumentException("This diet cannot be followed");
    }

    public HyperCaloricDiet(String name, Food favoriteFood, Float maxWeightKg){
        super.setName(name);
        super.setFood(favoriteFood);
        this.maxWeightKg = maxWeightKg;
    }

    public HyperCaloricDiet(String name, Food[] favoriteFood, Float maxWeightKg){
        super.setName(name);
        super.setAllowedFood(favoriteFood);
        this.maxWeightKg = maxWeightKg;
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


    public HyperCaloricDiet(Float maxWeightKg, Float minCaloriesPerDay) {
        this.maxWeightKg = maxWeightKg;
        this.minCaloriesPerDay = minCaloriesPerDay;
    }

    public HyperCaloricDiet(Float maxWeightKg) {
        this.maxWeightKg = maxWeightKg;
    }

    public HyperCaloricDiet(String name){
        super.setName(name);
    }

    public HyperCaloricDiet(String name, boolean isVegan){
        super.setName(name);
        super.setVegan(isVegan);
    }

    public HyperCaloricDiet(String name, int daysDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
    }

    public HyperCaloricDiet(String name, int daysDuration, int monthDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
        super.setMonthDuration(monthDuration);
    }



    public Float getMaxWeightKg() {
        return maxWeightKg;
    }

    public void setMaxWeightKg(Float maxWeightKg) {
        this.maxWeightKg = maxWeightKg;
    }

    public Float getMinCaloriesPerDay() {
        return minCaloriesPerDay;
    }

    public void setMinCaloriesPerDay(Float minCaloriesPerDay) {
        this.minCaloriesPerDay = minCaloriesPerDay;
    }


}
