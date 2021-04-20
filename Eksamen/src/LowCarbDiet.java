public class LowCarbDiet extends Diet {


    Float minWeightKg;

    public LowCarbDiet(int daysDuration, String purpose, Food[] allowedFood, boolean isVegan, Float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.minWeightKg = minWeightKg;
    }


    @Override
    public String writeDuration() {
        return null;
    }

    @Override
    public String writeAllowedFood() {
        return null;
    }
}
