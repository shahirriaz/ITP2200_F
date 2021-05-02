import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HyperCaloricDietTest {

    @Test
    public void emptyConstructorTest() {
        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet();

        assertNotNull(hyperCaloricDiet);
    }

    @Test
    /*weight equals*/
    public void HyperCaloricDietWeightTest(){
        HyperCaloricDiet hyperCaloricDie = new HyperCaloricDiet(80f);

        assertEquals(hyperCaloricDie.maxWeightKg, 80f);
    }

    @Test
    public void HyperCaloricDietNameTest(){
        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet("HyperCaloricDiet");
        assertEquals("HyperCaloricDiet", hyperCaloricDiet.getName());

        hyperCaloricDiet.setName("HyperCaloricDietNameChange");
        assertEquals("HyperCaloricDietNameChange", hyperCaloricDiet.getName());
    }

    @Test
    public void HyperCaloricConstructorTest(){
       Food favoriteFood = new Food("Fish", FoodType.Protein, false);

        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet("HyperCaloricDiet", favoriteFood, 80f );

        assertEquals( "HyperCaloricDiet", hyperCaloricDiet.getName() );
        assertEquals( favoriteFood.getName(), "Fish" );
        assertEquals( hyperCaloricDiet.getMaxWeightKg(), 80f );
    }

    @Test
    /*weighs less than limit*/
    public void canBeFollowedOrNotByTest_1(){
        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet(65f);
        Person person = new Person(new Food("Lasagna", FoodType.Carb, false), hyperCaloricDiet, 55f);
        assertThrows(IllegalArgumentException.class,() -> hyperCaloricDiet.canBeFollowedOrNotBy(person));
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


        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet("HyperCaloricDiet",allowedFood,80f);
        Food favoriteFood = new Food("Ku", false);

        Person person = new Person(favoriteFood, hyperCaloricDiet, 70f);

        assertFalse(person.getFavoriteFood().isVegan);
        assertFalse(person.getWeight() > hyperCaloricDiet.maxWeightKg);
        assertTrue(person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50);

       assertThrows(IllegalArgumentException.class,() -> hyperCaloricDiet.canBeFollowedOrNotBy(person));

       favoriteFood.setVegan( true );

        assertTrue( hyperCaloricDiet.canBeFollowedOrNotBy( person ) );

    }

    @Test // public boolean canBeFollowedOrNot(Person person)
    //consideren vegan if it only contains vegan food
    public void canBeFollowedOrNotByTest_3(){
        Food[] allowedFood = new Food[3];
        allowedFood[0] = new Food("KidneyBeans", FoodType.Protein, true);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);


        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet("HyperCaloricDiet",allowedFood,60f);
        Food favoriteFood = new Food("Kiwi", true);

        Person person = new Person(favoriteFood, hyperCaloricDiet, 70f);
        assertTrue( hyperCaloricDiet.canBeFollowedOrNotBy( person ) );

    }

    @Test
    public void isVeganCompatible1(){
        Food[] food = new Food[3];
        food[0] =  new Food("Rice", FoodType.Carb, true);
        food[1] =  new Food("Beans", FoodType.Protein, true);
        food[2] =  new Food("Pølse", FoodType.Carb, false);

        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet("HyperCaloric",food);
        assertFalse(hyperCaloricDiet.isVeganCompatible(food));
    }

    @Test
    public void isVeganCompatible2(){
        Food[] food = new Food[3];
        food[0] =  new Food("Rice", FoodType.Carb, true);
        food[1] =  new Food("Beans", FoodType.Protein, true);
        food[2] =  new Food("KidneyBean", FoodType.Carb, true);

        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet("HyperCaloric",food);
        assertTrue(hyperCaloricDiet.isVeganCompatible(food));
    }

    @Test
    public void HyperCaloricDietDaysDurationTest(){
        HyperCaloricDiet hyperCaloricDiet = new HyperCaloricDiet("HyperCaloricDiet", 30);
        assertEquals("HyperCaloricDiet", hyperCaloricDiet.getName());
        assertEquals(30, hyperCaloricDiet.getDaysDuration());

        hyperCaloricDiet.setName("HyperCaloricNameChangeTest");
        hyperCaloricDiet.setDaysDuration(60);
        assertEquals("HyperCaloricNameChangeTest", hyperCaloricDiet.getName());
        assertEquals(60, hyperCaloricDiet.getDaysDuration());
    }

    /*sets the duration of diet in days and months*/
    @Test
    public void HyperCaloricDietDaysMonthDurationTest(){
        HyperCaloricDiet hyperCaloricDiet  = new HyperCaloricDiet("HyperCaloricDiet", 30, 5);
        assertEquals("HyperCaloricDiet", hyperCaloricDiet.getName());
        assertEquals(30, hyperCaloricDiet.getDaysDuration());
        assertEquals(5, hyperCaloricDiet.getMonthDuration());

        hyperCaloricDiet.setName("HyperCaloricNameChangeTest");
        hyperCaloricDiet.setDaysDuration(60);
        hyperCaloricDiet.setMonthDuration(3);
        assertEquals("HyperCaloricNameChangeTest", hyperCaloricDiet.getName());
        assertEquals(60, hyperCaloricDiet.getDaysDuration());
        assertEquals(3, hyperCaloricDiet.getMonthDuration());
    }





}