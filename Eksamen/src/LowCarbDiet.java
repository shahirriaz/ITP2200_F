public class LowCarbDiet extends Diet {
    // Skal man sette en vekt som er minimum?
    Float minWeightKg;

    public LowCarbDiet(String name) {
        super.setName(name);
    }

    // This diet can contain maximum two Meals with foodtype Carb
    // Array
    Food[] LowCarbDietFood = new Food[2];
    LowCarbDietFood[0] = new Food("Lasagna", false);
    LowCarbDietFood[1] = new Food("Pizza", false);




    //Skal følgende være på alle diettyper?
    /*IF THE DIET LASTS FOR ONLY DAYS*/
    public LowCarbDiet(String name, int daysDuration) {
        super.setName(name);
        super.setDaysDuration(daysDuration);
    }

    /*IF THE DIET LASTS FOR ONLY DAYS AND MONTHS*/
    public LowCarbDiet(String name, int daysDuration, int monthDuration) {
        super.setName(name);
        super.setDaysDuration(daysDuration);
        super.setMonthDuration(monthDuration);
    }

    public void setDaysDuration(int duration) {
        super.setDaysDuration(duration);
    }


}