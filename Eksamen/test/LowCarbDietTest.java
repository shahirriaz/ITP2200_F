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
    //only two carbs
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

    @Test
    public void isVeganCompatible1(){
        Food[] food = new Food[3];
        food[0] =  new Food("Rice", FoodType.Carb, true);
        food[1] =  new Food("Beans", FoodType.Protein, true);
        food[2] =  new Food("Pølse", FoodType.Carb, false);

        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet",food);
        assertFalse(lowCarbDiet.isVeganCompatible(food));
    }

    @Test
    public void isVeganCompatible2(){
        Food[] food = new Food[3];
        food[0] =  new Food("Rice", FoodType.Carb, true);
        food[1] =  new Food("Beans", FoodType.Protein, true);
        food[2] =  new Food("Gress", FoodType.Carb, true);

        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet",food);
        assertTrue(lowCarbDiet.isVeganCompatible(food));
    }

    @Test
    public void maxiMumCarbFoodAllowed1(){
        Food[] food = new Food[3];
        food[0] =  new Food("Rice", FoodType.Carb, true);
        food[1] =  new Food("Banana", FoodType.Carb, true);
        food[2] =  new Food("Chips", FoodType.Carb, true);

        LowCarbDiet lowCarbDiet = new LowCarbDiet();
        assertEquals(lowCarbDiet.maxiMumCarbFoodAllowed(food), 3);
    }

    @Test
    public void maxiMumCarbFoodAllowed2(){
        Food[] food = new Food[3];
        food[0] =  new Food("Chicken", FoodType.Protein, false);
        food[1] =  new Food("Beef", FoodType.Protein, false);
        food[2] =  new Food("Pepperoni", FoodType.Protein, false);

        LowCarbDiet lowCarbDiet = new LowCarbDiet();
        assertEquals(lowCarbDiet.maxiMumCarbFoodAllowed(food), 0);
    }

    @Test
    public void LowCarbDaysDurationTest(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet", 30);
        assertEquals("LowCarbDiet", lowCarbDiet.getName());
        assertEquals(30, lowCarbDiet.getDaysDuration());

        lowCarbDiet.setName("LowCarbDietNameChangeTest");
        lowCarbDiet.setDaysDuration(60);
        assertEquals("LowCarbDietNameChangeTest", lowCarbDiet.getName());
        assertEquals(60, lowCarbDiet.getDaysDuration());
    }

    @Test
    public void VeganDietDaysAndMonthDurationTest(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet", 30,3);
        assertEquals("LowCarbDiet", lowCarbDiet.getName());
        assertEquals(30, lowCarbDiet.getDaysDuration());
        assertEquals(3, lowCarbDiet.getMonthDuration());

        lowCarbDiet.setName("LowCarbDietNameChangeTest");
        lowCarbDiet.setDaysDuration(35);
        lowCarbDiet.setMonthDuration(6);
        assertEquals("LowCarbDietNameChangeTest", lowCarbDiet.getName());
        assertEquals(35, lowCarbDiet.getDaysDuration());
        assertEquals(6, lowCarbDiet.getMonthDuration());
    }









}