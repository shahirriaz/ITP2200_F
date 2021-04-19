public class HyperCaloricDiet extends Diet {


    Float maxWeightKg;
    Float minCaloriesPerDay;


    public HyperCaloricDiet(Float maxWeightKg, Float minCaloriesPerDay) {
        this.maxWeightKg = maxWeightKg;
        this.minCaloriesPerDay = minCaloriesPerDay;
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
