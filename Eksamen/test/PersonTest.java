import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void emptyConstructorTest(){
        Person person = new Person();

        assertNotNull(person);
    }


    @Test
    public void cannotFollowVeganDietTest(){
        Food favoriteFood = new Food("Hamburger",  FoodType.Protein, false);

        VeganDiet veganDiet = new VeganDiet(favoriteFood, 60f);
         Person onkel = new Person(favoriteFood, veganDiet, 61f);

         /*if favorite food is non-vegan*/
         assertFalse(veganDiet.isCompatible(onkel));

    }

    @Test
    public void cannotFollowVeganDietTest2(){
        Food favoriteFood = new Food("Banana", true);

        VeganDiet veganDiet = new VeganDiet(favoriteFood, 60f);
        Person onkel = new Person(favoriteFood, veganDiet, 61f);

        /*if favorite food is vegan*/
        assertTrue(veganDiet.isCompatible(onkel));

    }

    @Test
    public void allergicToFiftyPercentTest1(){
        Food favoriteFood = new Food("Banana", true);
        Food[] allowedFood = new Food[7];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);
        allowedFood[3] = new Food("Diary", FoodType.Protein, false);
        allowedFood[4] = new Food("Bread", FoodType.Carb, true);
        allowedFood[5] = new Food("Juice", FoodType.Carb, true);
        allowedFood[6] = new Food("Nudler", FoodType.Carb, true);

        FlexitarianDiet flexitarianDiet = new FlexitarianDiet(allowedFood);

        Food[] allergies = new Food[4];
        allergies[0] = new Food("Bread");
        allergies[1] = new Food("Diary");
        allergies[2] = new Food("Rice");
        allergies[3] = new Food("Nudler");

        Person onkel = new Person(favoriteFood, allergies, flexitarianDiet, 61f);

        /*allergic to more than 50%*/
        assertFalse(flexitarianDiet.isCompatible(onkel));
    }
    @Test
    public void allergicToFiftyPercentTest2(){
        Food favoriteFood = new Food("Banana", true);
        Food[] allowedFood = new Food[7];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);
        allowedFood[3] = new Food("Diary", FoodType.Protein, false);
        allowedFood[4] = new Food("Bread", FoodType.Carb, true);
        allowedFood[5] = new Food("Juice", FoodType.Carb, true);
        allowedFood[6] = new Food("Nudler", FoodType.Carb, true);

        FlexitarianDiet flexitarianDiet = new FlexitarianDiet(allowedFood);

        Food[] allergies = new Food[3];
        allergies[0] = new Food("Bread");
        allergies[1] = new Food("Diary");
        allergies[2] = new Food("Rice");


        Person onkel = new Person(favoriteFood, allergies, flexitarianDiet, 61f);

        /*allergic to under 50%*/
        assertTrue(flexitarianDiet.isCompatible(onkel));

    }

    //Weighs less than limit
    @Test
    public void weighLessThanReqTest1(){
        Food favoriteFood = new Food("Banana",  FoodType.Protein, true);

        VeganDiet veganDiet = new VeganDiet(favoriteFood, 60f);
        Person onkel = new Person(favoriteFood, veganDiet, 58f);

        assertFalse(veganDiet.isCompatible(onkel));
    }

    //Weigh more than limit
    @Test
    public void weighLessThanReq2(){
        Food favoriteFood = new Food("Banana",  FoodType.Protein, true);

        VeganDiet veganDiet = new VeganDiet(favoriteFood, 60f);
        Person onkel = new Person(favoriteFood, veganDiet, 70f);

        assertTrue(veganDiet.isCompatible(onkel));
    }


    @Test
    public void weighMoreThanReq(){
        Food favoriteFood = new Food("Banana",  FoodType.Protein, true);

        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet(favoriteFood, 60f);
        Person torleif = new Person(favoriteFood, hyperCaloricDiet, 70f);

        assertFalse(hyperCaloricDiet.isCompatible(torleif));
    }





}