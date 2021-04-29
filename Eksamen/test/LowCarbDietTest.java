import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LowCarbDietTest {

    @Test
    public void emptyConstructorTest() {
        LowCarbDiet lowCarbDiet = new LowCarbDiet();

        assertNotNull(lowCarbDiet);
    }

    @Test
    public void LowCarbDiet(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet(60f);

        assertEquals(lowCarbDiet.minWeightKg, 60f);
    }

    @Test
    public void LowCarbDietNameTest(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet");
        assertEquals("LowCarbDiet", lowCarbDiet.getName());

        lowCarbDiet.setName("LowCarbDietNameChange");
        assertEquals("LowCarbDietNameChange", lowCarbDiet.getName());
    }

    @Test
    /*weighs less than limit*/
    public void canBeFollowedOrNotByTest_1(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet(60f);
        Person person = new Person(new Food("Pizza", FoodType.Carb, false), lowCarbDiet, 55f);
        assertThrows(IllegalArgumentException.class,() -> lowCarbDiet.canBeFollowedOrNotBy(person));
    }

    @Test // public boolean canBeFollowedOrNot(Person person)
    //more carbs than allowed
    public void canBeFollowedOrNotByTest_2(){
        Food[] allowedFood = new Food[7];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);
        allowedFood[3] = new Food("Diary", FoodType.Protein, false);
        allowedFood[4] = new Food("Bread", FoodType.Carb, true);
        allowedFood[5] = new Food("Juice", FoodType.Carb, true);
        allowedFood[6] = new Food("Nudler", FoodType.Carb, true);


        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet",allowedFood,60f);
        Food favoriteFood = new Food("Blåkjell", false);

        Person person = new Person(favoriteFood, lowCarbDiet, 70f);

        assertFalse(person.getFavoriteFood().isVegan);
        assertTrue(person.getWeight() > lowCarbDiet.minWeightKg);
        assertTrue(person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50);
        assertFalse(lowCarbDiet.maxiMumCarbFoodAllowed(allowedFood) <= 2);

        assertThrows(IllegalArgumentException.class,() -> lowCarbDiet.canBeFollowedOrNotBy(person));


    }

    @Test // public boolean canBeFollowedOrNot(Person person)
    //more carbs than allowed
    public void canBeFollowedOrNotByTest_3(){
        Food[] allowedFood = new Food[3];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);


        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet",allowedFood,60f);
        Food favoriteFood = new Food("Blåkjell", false);

        Person person = new Person(favoriteFood, lowCarbDiet, 70f);

        assertFalse(person.getFavoriteFood().isVegan);
        assertTrue(person.getWeight() > lowCarbDiet.minWeightKg);
        assertTrue(person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50);
        assertTrue(lowCarbDiet.maxiMumCarbFoodAllowed(allowedFood) <= 2);

        assertTrue( lowCarbDiet.canBeFollowedOrNotBy( person ) );


    }




}