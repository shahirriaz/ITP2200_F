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

    /*will check if i add non-vegan food, then the diet is non-vegan*/
    @Test
    public void setVeganFalseIfFoodIsNonVeganTest() {
        Food[] nonVeganFood = new Food[3];
        nonVeganFood[0] = new Food("Lasagna", false); /*non-vegan*/
        nonVeganFood[1] = new Food("Pizza", false); /*non-vegan*/
        nonVeganFood[2] = new Food("Banana", true);
        VeganDiet diet = new VeganDiet();
        diet.setVeganFalseIfFoodIsNonVegan(nonVeganFood);

        assertFalse(diet.isVegan());
        System.out.println(diet.toString());

    }

    /*will check if i add only vegan food, then the diet is vegan*/
    @Test
    public void setVeganTrueIfFoodIsVeganTest() {
        Food[] onlyVeganFood = new Food[3];
        onlyVeganFood[0] = new Food("Apple", true);
        onlyVeganFood[1] = new Food("Nuts", true);
        onlyVeganFood[2] = new Food("Kiwi", true);
        VeganDiet diet = new VeganDiet();
        diet.setVeganTrueIfFoodIsVegan(onlyVeganFood);

        assertTrue(diet.isVegan());
        System.out.println(diet.toString());
    }

    /*will throw an exception if non-vegan food is added to a vegan diet*/
    @Test (expected = IllegalArgumentException.class)
    public void setVeganTrueIfFoodIsVeganExceptionTest() {
        Food[] onlyVeganFood = new Food[3];
        onlyVeganFood[0] = new Food("Apple", true);
        onlyVeganFood[1] = new Food("Nuts", true);
        onlyVeganFood[2] = new Food("Spaghetti", false); /*non-vegan*/
        VeganDiet diet = new VeganDiet();
        diet.setVeganTrueIfFoodIsVegan(onlyVeganFood);

        assertTrue(diet.isVegan());

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