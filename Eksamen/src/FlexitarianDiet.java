import java.util.Arrays;
import java.util.Date;

public class FlexitarianDiet extends Diet {

    Float maxMeatGramsPerWeek;
    Food preferredMeat;

    public FlexitarianDiet(String name){
        super.setName(name);
    }

    public FlexitarianDiet(String purpose, int duration, Food[] allowedFood){
        super.setDaysDuration(duration);
        super.setPurpose(purpose);
        super.setAllowedFood(allowedFood);
    }

    public FlexitarianDiet(String name, int daysDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
    }

    public FlexitarianDiet(String name, int daysDuration, int monthDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
        super.setMonthDuration(monthDuration);
    }

    public void setDaysDuration(int duration){
        super.setDaysDuration(duration);
    }



}
