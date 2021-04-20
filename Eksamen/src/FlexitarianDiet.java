import java.util.Arrays;

public class FlexitarianDiet extends Diet {


    Float maxMeatGramsPerWeek;
    Food preferredMeat;


    public FlexitarianDiet(int daysDuration, String purpose, Food[] allowedFood, boolean isVegan, Float maxMeatGramsPerWeek, Food preferredMeat) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.maxMeatGramsPerWeek = maxMeatGramsPerWeek;
        this.preferredMeat = preferredMeat;
    }



    @Override
    public String writeDuration() {

        return null;
    }

    @Override
    public String writeAllowedFood() {
        return null;
    }

    @Override
    public String toString() {
        return "FlexitarianDiet{" +
                "daysDuration=" + daysDuration +
                ", purpose='" + purpose + '\'' +
                ", allowedFood=" + Arrays.toString(allowedFood) +
                ", isVegan=" + isVegan +
                ", maxMeatGramsPerWeek=" + maxMeatGramsPerWeek +
                ", preferredMeat=" + preferredMeat +
                '}';
    }
}
