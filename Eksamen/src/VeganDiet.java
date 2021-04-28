public class VeganDiet extends Diet  {


    Float minWeightKg;

    public VeganDiet(){}

    public VeganDiet(Float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }


    @Override
    public boolean isCompatible(Person person) {
        if(person.getFavoriteFood().isVegan && person.checkWeightCompatibility(person.getWeight())
        && person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50)
                return true;
   return false;

    }

    public VeganDiet(Food favoriteFood, Float minWeight){
        super.setFood(favoriteFood);
        this.minWeightKg = minWeight;
    }


    public VeganDiet(Food[] allowedFood, Float minWeightKg) {
        this.minWeightKg = minWeightKg;
        super.setAllowedFood(allowedFood);

    }

//    public VeganDiet(Food food){
//        if(food.isVegan)
//        super.setFood(food);
//        else
//            throw new IllegalArgumentException("Cannot follow vegan diet");
//    }


    public VeganDiet(Food[] allowedFood){
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

    public VeganDiet(String name){
        super.setName(name);
    }


    public VeganDiet(String name, int daysDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
    }

    public VeganDiet(String name, int daysDuration, int monthDuration){
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
