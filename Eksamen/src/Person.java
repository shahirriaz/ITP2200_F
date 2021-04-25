import java.util.Arrays;

public class Person{


    Food favoriteFood;
    Food[] allergies;
    Diet diet;
    Float weight;

    public Person() {}

    public void setVeganDietIfFoodIsVegan(Person p, Food favoriteFood, Diet diet){
        if(!favoriteFood.isVegan) throw new IllegalArgumentException("Favorite Food is non-vegan, cannot follow a non-vegan deit");
        p.setFavoriteFood(favoriteFood);
        p.setDiet(diet);
    }



    public Person(Food favoriteFood, Diet diet) {
        this.favoriteFood = favoriteFood;
        this.diet = diet;
    }

    public Person(Food favoriteFood, Food[] allergies, Diet diet, Float weight) {
        this.favoriteFood = favoriteFood;
        this.allergies = allergies;
        this.diet = diet;
        this.weight = weight;
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
