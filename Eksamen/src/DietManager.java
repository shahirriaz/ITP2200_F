import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DietManager {

    boolean areCompatible;

    public DietManager(){};

    public boolean isAreCompatible(Person p, Diet diet){
        if(!p.getFavoriteFood().isVegan() && diet instanceof VeganDiet)
            throw new IllegalArgumentException("Error, favorite food is nonVegan");
        new Person(p.getFavoriteFood(), p.getAllergies(), p.getWeight()).setDiet(diet);
        return true;
    }
    public HyperCaloricDiet randomDiet(Person p, Food[] foods){
        int days = (int) Math.floor(Math.random() * 101);
        Food[] goodfood = removeAllergicFood(p, foods);
        float maxWeight = generateRandomNumber(p.weight, p.weight + 20);
        float minCalories = generateRandomNumber(2000f, 4000f);
        return new HyperCaloricDiet("RandomDiet", goodfood, maxWeight, minCalories, days);

    }
     public Food[] removeAllergicFood(Person p, Food[] foods){
         List<Food> result = new LinkedList<Food>();

         for (Food food : foods)
             for(Food allergies : p.allergies)
                 if (food.getName().equals(allergies.getName()))
                     result.add(food);
         return result.toArray(foods);

     }

    float generateRandomNumber(float min, float max){
        Random r = new Random();
        return r.nextInt((int) (max-min)) + min;

    }
}
