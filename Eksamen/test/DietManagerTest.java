import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DietManagerTest {

    //Favorite food is none-vegan
    @Test (expected = IllegalArgumentException.class)
    public void req_4_a_0(){
        Food favoriteFood1 = new Food("Kebab", false);
        Food[] allowedFood = new Food[4];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);
        allowedFood[3] = new Food("Diary", FoodType.Protein, false);

        Food[] allergies = new Food[2];
        allergies[0] = new Food("Bread");
        allergies[1] = new Food("Diary");

        VeganDiet veganDiet = new VeganDiet("VeganDiet",allowedFood);
        Person person = new Person(favoriteFood1, allergies, veganDiet, 75f);

        DietManager dm = new DietManager();
        dm.isAreCompatible(person, veganDiet);

    }

    //Favorite food is vegan
    @Test
    public void req_4_a_1(){
        Food favoriteFood2 = new Food("Banana", true);
        Food[] allowedFood = new Food[4];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);
        allowedFood[3] = new Food("Diary", FoodType.Protein, false);

        Food[] allergies = new Food[2];
        allergies[0] = new Food("Bread");
        allergies[1] = new Food("Diary");

        VeganDiet veganDiet = new VeganDiet("VeganDiet", allowedFood);
        Person person = new Person(favoriteFood2, allergies, veganDiet, 75f);

        DietManager dm = new DietManager();
        dm.isAreCompatible(person, veganDiet);

        assertTrue(dm.isAreCompatible(person,veganDiet));

    }

    @Test
    public void randomHyperCaloricDiet(){
        Food[] foods = new Food[5];
        foods[0] = new Food( "Potato", FoodType.Carb, true );
        foods[1] = new Food( "Rice", FoodType.Carb, true );
        foods[2] = new Food( "Bread", FoodType.Carb, true );
        foods[3] = new Food( "Juice", FoodType.Carb, true );
        foods[4] = new Food( "Beef", FoodType.Protein, false );

        Food[] allergies = new Food[1];
        allergies[0] = new Food( "Bread" );


        Person theLuckyOne = new Person(allergies, 70f);

        HyperCaloricDiet randomHyperCaloricDiet = new DietManager().randomDiet(theLuckyOne,foods );



    }


}