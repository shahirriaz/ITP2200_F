public class VeganDiet extends Diet  {


    Float minWeightKg;


    public VeganDiet(){}

    public VeganDiet(String name){
        super.setName(name);
    }

    /*
    * If ONE food is non-vegan, then the whole diet is non-vegan regardless if one or multiple food is vegan
    * */
    public void setVeganFalseIfFoodIsNonVegan(Food[] food){
        for (Food f: food) if(!f.isVegan) {
            super.setVegan(false);
            super.setAllowedFood(food);

        }
    }

    /*
    * If the food is only vegan, then the whole diet is set to Vegan
    * */
    public void setVeganTrueIfFoodIsVegan(Food[] food){
        for(Food f: food)
            /*if food is not vegan throw exception*/ {
            if (!f.isVegan) throw new IllegalArgumentException("A vegan diet cannot contain any non-vegan food");
            super.setVegan(true);
            super.setAllowedFood(food);
        }
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
}
