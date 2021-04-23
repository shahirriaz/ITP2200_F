import java.util.Arrays;
import java.util.Date;

public class FlexitarianDiet extends Diet {

    Float maxMeatGramsPerWeek;
    Food preferredMeat;

    public FlexitarianDiet() {
    }

    public FlexitarianDiet(String name){
        super.setName(name);
    }

    /*
     * Whether a diet is non-vegan or vegan depends on if the food is vegan or non-vegan, this method checks that
     * */

    public void setVeganFalseIfFoodIsNonVegan(Food[] food){
        for (Food f: food) if (!f.isVegan){
            super.setVegan(false);
            super.setAllowedFood(food);
        }

    }

    /*
    * Whether a diet is non-vegan or vegan depends on if the food is vegan or non-vegan, this method checks that
    * */

    public void setVeganTrueIfFoodIsVegan(Food[] food){
        for(Food f: food)
                /*if food is not vegan*/
            if (!f.isVegan)
                throw new IllegalArgumentException("A vegan diet cannot contain any non-vegan food");
            else {
                super.setVegan(true);
                super.setAllowedFood(food);
            }
    }


    /*IF THE DIET LASTS FOR ONLY DAYS*/
    public FlexitarianDiet(String name, int daysDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
    }
    /*IF THE DIET LASTS FOR ONLY DAYS AND MONTHS*/
    public FlexitarianDiet(String name, int daysDuration, int monthDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
        super.setMonthDuration(monthDuration);
    }


}

