import java.util.Arrays;

public class Person{

    Food favoriteFood;
    Food[] allergies;
    Diet diet;
    Float weight;


    public Person() {}

    public Person(Food favoriteFood, Food[] allergies, Diet diet, Float weight) {
        this.favoriteFood = favoriteFood;
        this.allergies = allergies;
        this.diet = diet;
        this.weight = weight;
    }

    public Person(Food favoriteFood, Diet diet, Float weight) {
        this.favoriteFood = favoriteFood;
        this.diet = diet;
        this.weight = weight;
    }


    public Person(Food favoriteFood, Diet diet) {
        this.favoriteFood = favoriteFood;
        this.diet = diet;
    }

//    public void checkCompatibilityVeganFood(Diet diet){
//       if(!followCompatibility(getFavoriteFood()) && diet.isVegan)
//       setDiet(diet);
//    }
//
//    public void weightLessOrMoreThanReq(Diet diet){
//        if (checkWeightCompatibility(getWeight()))
//        throw new IllegalArgumentException("Cannot follow this diet because you are underweight");
//        else if(checkWeightCompatibility2(getWeight()))
//            throw new IllegalArgumentException("Cannot follow this diet because you are overWeight");
//        setDiet(diet);
//
//    }

//    public boolean followCompatibility(Food favoriteFood){
//        return favoriteFood.isVegan;
//    }

    public boolean checkWeightCompatibility(Float weight){
        return (weight > 60);
    }

    public boolean checkWeightCompatibility2(Float weight){
        return  (weight > 80);
    }


    public double getPercentThatMatch(Food[] allowedFood, Food[] allergies) {
        double match = 0;
            if(allergies != null ) {
                for (Food food : allowedFood) {
                    for (Food allergy : allergies) {
                        if (food.getName().equals(allergy.getName()))
                            match++;
                    }
                }
                return (match / allowedFood.length) * 100;
            }
        return 0;
    }


    public Food getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(Food favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public Food[] getAllergies() {
        return allergies;
    }

    public void setAllergies(Food[] allergies) {
        this.allergies = allergies;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }


    public Float getWeight() {
        return weight;
    }


    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "favoriteFood=" + favoriteFood +
                ", allergies=" + Arrays.toString(allergies) +
                ", diet=" + diet +
                ", weight=" + weight +
                '}';
    }


}
