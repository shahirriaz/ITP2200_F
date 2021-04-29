public class VeganDiet extends Diet  {


    Float minWeightKg;

    public VeganDiet(){}

    public VeganDiet(Float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }


    @Override
    public boolean canBeFollowedOrNotBy(Person person) {
        if(person.getFavoriteFood().isVegan && person.diet.isVegan
                && person.checkWeightCompatibility(person.getWeight())
                && person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50
                &&  (!(person.diet instanceof FlexitarianDiet))
        ){
            person.setDiet(person.diet);
            return true;
        }else
            throw new IllegalArgumentException("This diet cannot be followed");
    }

    public VeganDiet(String name, Food favoriteFood, Float minWeight){
        super.setName(name);
        super.setFood(favoriteFood);
        this.minWeightKg = minWeight;
    }

    /*
     * Setter vegan til true kun hvis det er vegan food i arrayet
     * The food will be evaluated in each constructor, if it contains any non-vegan food
     * */

    public VeganDiet(String name, Food[] allowedFood, Float minWeightKg) {
        super.setName(name);
        this.minWeightKg = minWeightKg;
        super.setAllowedFood(allowedFood);
        if (isVeganOrNot(allowedFood) == allowedFood.length)
            super.setVegan(true);

    }

    /*
    * Setter vegan til true kun hvis det er vegan food i arrayet
    * */
    public VeganDiet(String name, Food[] allowedFood){
        super.setName(name);
        super.setAllowedFood(allowedFood);
        if (isVeganOrNot(allowedFood) == allowedFood.length)
            super.setVegan(true);
    }


    /*her sjekkes om maten i arrayet er vegan eller ikke*/
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
