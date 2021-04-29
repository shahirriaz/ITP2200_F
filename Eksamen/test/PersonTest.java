import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void emptyConstructorTest(){
        Person person = new Person();

        assertNotNull(person);
    }

    /*if favorite food is non-vegan it will throw an error*/
    @Test
    public void req_2_a_0(){
        Food favoriteFood = new Food("Hamburger",  FoodType.Protein, false);

        VeganDiet veganDiet = new VeganDiet("VeganDiet", favoriteFood, 60f);
         Person onkel = new Person(favoriteFood, veganDiet, 61f);


        assertThrows(IllegalArgumentException.class,() -> veganDiet.canBeFollowedOrNotBy(onkel));

    }

    /*if favorite food is vegan*/
    @Test
    public void req_2_a_1(){
        Food favoriteFood = new Food("Banana", true);

        VeganDiet veganDiet = new VeganDiet("VeganDiet",favoriteFood, 60f);
        Person onkel = new Person(favoriteFood, veganDiet, 61f);

        assertTrue(veganDiet.canBeFollowedOrNotBy(onkel));

    }

    /*if allergiv food is more than 50% it will throw an error*/
    @Test
    public void req_2_b_0(){
        Food favoriteFood = new Food("Banana", true);
        Food[] allowedFood = new Food[7];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);
        allowedFood[3] = new Food("Diary", FoodType.Protein, false);
        allowedFood[4] = new Food("Bread", FoodType.Carb, true);
        allowedFood[5] = new Food("Juice", FoodType.Carb, true);
        allowedFood[6] = new Food("Nudler", FoodType.Carb, true);

        FlexitarianDiet flexitarianDiet = new FlexitarianDiet("FlexitarianDiet", allowedFood);

        Food[] allergies = new Food[4];
        allergies[0] = new Food("Bread");
        allergies[1] = new Food("Diary");
        allergies[2] = new Food("Rice");
        allergies[3] = new Food("Nudler");

        Person onkel = new Person(favoriteFood, allergies, flexitarianDiet, 61f);

         assertThrows(IllegalArgumentException.class,() -> flexitarianDiet.canBeFollowedOrNotBy(onkel));


    }

    /*allergic to under 50%*/
    @Test
    public void req_2_b_1(){
        Food favoriteFood = new Food("Banana", true);
        Food[] allowedFood = new Food[7];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);
        allowedFood[3] = new Food("Diary", FoodType.Protein, false);
        allowedFood[4] = new Food("Bread", FoodType.Carb, true);
        allowedFood[5] = new Food("Juice", FoodType.Carb, true);
        allowedFood[6] = new Food("Nudler", FoodType.Carb, true);

        FlexitarianDiet flexitarianDiet = new FlexitarianDiet("FlexitarianDiet", allowedFood);

        Food[] allergies = new Food[3];
        allergies[0] = new Food("Bread");
        allergies[1] = new Food("Diary");
        allergies[2] = new Food("Rice");

        Person onkel = new Person(favoriteFood, allergies, flexitarianDiet, 61f);

        assertTrue(flexitarianDiet.canBeFollowedOrNotBy(onkel));

    }

    //Weighs less than minlimit VeganDiet it will throw error
    @Test
    public void req_2_c_0(){
        Food favoriteFood = new Food("Banana",  FoodType.Protein, true);

        VeganDiet veganDiet = new VeganDiet("VeganDiet", favoriteFood, 60f);
        Person onkel = new Person(favoriteFood, veganDiet, 58f);

        assertThrows(IllegalArgumentException.class,() -> veganDiet.canBeFollowedOrNotBy(onkel));
    }

    //Weigh more than minlimit VeganDiet
    @Test
    public void req_2_c_1(){
        Food favoriteFood = new Food("Banana",  FoodType.Protein, true);

        VeganDiet veganDiet = new VeganDiet("VeganDiet", favoriteFood, 60f);
        Person onkel = new Person(favoriteFood, veganDiet, 70f);

        assertTrue(veganDiet.canBeFollowedOrNotBy(onkel));
    }

    //Weighs less than minlimit LowCarbDiet it will throw error
    @Test
    public void req_2_c_2(){
        Food[] allowedFood = new Food[3];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);

        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet", allowedFood, 60f);
        Person perOle = new Person(lowCarbDiet,50f);


        assertThrows(IllegalArgumentException.class,() -> lowCarbDiet.canBeFollowedOrNotBy(perOle));
    }

    @Test
    public void req_2_c_3(){
        Food[] allowedFood = new Food[3];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);

        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet", allowedFood, 60f);
        Person perOle = new Person(lowCarbDiet,70f);


        assertTrue(lowCarbDiet.canBeFollowedOrNotBy(perOle));
    }


    //Weighs more than maxlimit it will throw error
    @Test
    public void req_2_d_0(){
        Food favoriteFood = new Food("Banana",  FoodType.Protein, true);

        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet("HyperCaloricDiet",favoriteFood, 80f);
        Person torleif = new Person(favoriteFood, hyperCaloricDiet, 90f);

        assertThrows(IllegalArgumentException.class,() -> hyperCaloricDiet.canBeFollowedOrNotBy(torleif));
    }

    //Weighs less than maxlimit
    @Test
    public void req_2_d_1(){
        Food favoriteFood = new Food("Banana",  FoodType.Protein, true);

        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet("HyperCaloricDiet", favoriteFood, 80f);
        Person torleif = new Person(favoriteFood, hyperCaloricDiet, 75f);

        assertTrue(hyperCaloricDiet.canBeFollowedOrNotBy(torleif));
    }





}