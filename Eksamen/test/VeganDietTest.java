import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VeganDietTest {

    @Test
    public void emptyConstructorTest(){
        VeganDiet veganDiet = new VeganDiet();

        assertNotNull(veganDiet);
    }

    @Test
    public void VeganDietNameTest(){
        VeganDiet veganDiet = new VeganDiet("VeganDiet");

        assertEquals("VeganDiet", veganDiet.getName());

        veganDiet.setName("VeganDietNameChangeTest");

        assertEquals("VeganDietNameChangeTest", veganDiet.getName());

    }

    @Test // public boolean canBeFollowedOrNotBy(Person person)
    /*Will throw error if a diet other than Vegan diet is assigned to Person*/
    public void canBeFollowedOrNotByTest_1(){
        Food[] allowedFood = new Food[5];
        allowedFood[0] = new Food("Potato", FoodType.Carb, true);
        allowedFood[1] = new Food("Rice", FoodType.Carb, true);
        allowedFood[2] = new Food("Bread", FoodType.Carb, true);
        allowedFood[3] = new Food("Juice", FoodType.Carb, true);
        allowedFood[4] = new Food("Nudler", FoodType.Carb, true);

        Food[] allergies = new Food[3];
        allergies[0] = new Food("Bread");
        allergies[1] = new Food("Diary");
        allergies[2] = new Food("Rice");

        VeganDiet veganDiet = new VeganDiet("VeganDiet",allowedFood,60f);
        Food favoriteFood = new Food("Apple", true);

        Person person = new Person(favoriteFood, allergies, veganDiet, 70f);
        veganDiet.canBeFollowedOrNotBy(person);

        assertTrue(person.getFavoriteFood().isVegan);
        assertTrue(person.getWeight() > veganDiet.minWeightKg);
        assertTrue(person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50);

        assertTrue(veganDiet.canBeFollowedOrNotBy(person));

        /*will throw error -- cannot add flexitarianDiet to VeganDiet*/
        person.setDiet(new FlexitarianDiet());

        assertThrows(IllegalArgumentException.class,() -> veganDiet.canBeFollowedOrNotBy(person));
    }

    @Test
    public void isVeganCompatible1(){
        Food[] food = new Food[3];
        food[0] =  new Food("Rice", FoodType.Carb, true);
        food[1] =  new Food("Beans", FoodType.Protein, true);
        food[2] =  new Food("Pølse", FoodType.Carb, false);

        VeganDiet diet = new VeganDiet("VeganDiet",food);
        assertFalse(diet.isVeganCompatible(food));
    }

    @Test
    public void isVeganCompatible2(){
        Food[] food = new Food[3];
        food[0] =  new Food("Rice", FoodType.Carb, true);
        food[1] =  new Food("Beans", FoodType.Protein, true);
        food[2] =  new Food("Pølse", FoodType.Carb, true);

        VeganDiet diet = new VeganDiet("VeganDiet",food);
        assertTrue(diet.isVeganCompatible(food));
    }


    @Test //public VeganDiet(Food favoriteFood, Float minWeight)
    public void  VeganDiet(){
        VeganDiet veganDiet = new VeganDiet("VeganDiet", new Food("Apple", true), 65f);

        assertTrue(veganDiet.getFood().isVegan);
        assertEquals("Apple", veganDiet.getFood().getName());
        assertEquals(65f, veganDiet.getMinWeightKg());
    }

    @Test //VeganDiet(Food[] allowedFood, Float minWeightKg)
    public void  VeganDiet2(){
        Food[] allowedFood = new Food[4];
        allowedFood[0] = new Food("Fish", FoodType.Protein, false);
        allowedFood[1] = new Food("Potato", FoodType.Carb, true);
        allowedFood[2] = new Food("Rice", FoodType.Carb, true);
        allowedFood[3] = new Food("Diary", FoodType.Protein, false);

        VeganDiet veganDiet = new VeganDiet("VeganDiet", allowedFood, 65f);


          assertTrue(veganDiet.getAllowedFood().length >= 4 );
          assertEquals(65f, veganDiet.getMinWeightKg());
    }



    @Test
    public void VeganDietDaysDurationTest(){
        VeganDiet veganDiet = new VeganDiet("VeganDiet", 30);
        assertEquals("VeganDiet", veganDiet.getName());
        assertEquals(30, veganDiet.getDaysDuration());

        veganDiet.setName("VeganDietNameChangeTest");
        veganDiet.setDaysDuration(60);
        assertEquals("VeganDietNameChangeTest", veganDiet.getName());
        assertEquals(60, veganDiet.getDaysDuration());
    }

    @Test
    public void VeganDietDaysAndMonthDurationTest(){
        VeganDiet veganDiet = new VeganDiet("VeganDiet", 30,3);
        assertEquals("VeganDiet", veganDiet.getName());
        assertEquals(30, veganDiet.getDaysDuration());
        assertEquals(3, veganDiet.getMonthDuration());

        veganDiet.setName("VeganDietNameChangeTest");
        veganDiet.setDaysDuration(35);
        veganDiet.setMonthDuration(6);
        assertEquals("VeganDietNameChangeTest", veganDiet.getName());
        assertEquals(35, veganDiet.getDaysDuration());
        assertEquals(6, veganDiet.getMonthDuration());
    }




}