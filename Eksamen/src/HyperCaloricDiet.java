public class HyperCaloricDiet extends Diet {


    Float maxWeightKg;
    Float minCaloriesPerDay;



     @Override
    public boolean isCompatible(Person person) {
        if(person.checkWeightCompatibility2(person.getWeight())
                && person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50)
            return true;
        return false;

    }

    public HyperCaloricDiet(Food favoriteFood, Float maxWeightKg){
        super.setFood(favoriteFood);
        this.maxWeightKg = maxWeightKg;
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
