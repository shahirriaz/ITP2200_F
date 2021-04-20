import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void createPersonTest(){

        /*FOOD OBJECTS*/
        Food favoriteFood = new Food("Pizza", false, 200, FoodType.Carb);
        Food preferredMeat = new Food("RedMeat");

        /*ALLOWED FOOD ARRAY*/
        Food[] allowedFood = new Food[2];
        allowedFood[0] = new Food("Kjøttboller", false, 400, FoodType.Protein);
        allowedFood[1] = new Food("MacDonalds", false, 600, FoodType.Protein);

        FlexitarianDiet flexitarianDiet = new FlexitarianDiet(30, "weightGain", allowedFood, false, 200f, preferredMeat);

        /*ALLERGIES ARRAY, CAN BE NULL*/
        Food[] allergies = new Food[2];
        allergies[0] = new Food("Gluten");
        allergies[1] = new Food("Lactose");

        Person person_a = new Person(favoriteFood, allergies, flexitarianDiet, (float) 60.4);

        System.out.println(person_a);
    }



}