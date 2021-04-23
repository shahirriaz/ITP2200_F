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


    public FlexitarianDiet(Food[] food){
        for (Food f: food) if (!f.isVegan) super.setVegan(false);

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



    public void setDaysDuration(int duration){
        super.setDaysDuration(duration);
    }

}
