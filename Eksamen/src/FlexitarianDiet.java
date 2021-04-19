public class FlexitarianDiet extends Diet {


    Float maxMeatGramsPerWeek;
    Food preferredMeat;

    public FlexitarianDiet(Float maxMeatGramsPerWeek, Food preferredMeat) {
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
}
