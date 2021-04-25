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

    /*will check if i add ONLY NONE-VEGAN FOOD, then the diet is non-vegan*/
    @Test
    public void setVeganStateToFalseTest_a() {
        Food[] nonVeganFood = new Food[3];
        nonVeganFood[0] = new Food("Lasagna", false);
        nonVeganFood[1] = new Food("Meatball", false);
        nonVeganFood[2] = new Food("Eggs", false);
        VeganDiet veganDiet = new VeganDiet();
        veganDiet.setVeganStateToFalse(nonVeganFood);

        assertFalse(veganDiet.isVegan);

    }

    /*will check if i add atleast ONE NONE-VEGAN food*/
    @Test
    public void setVeganStateToFalse_b() {
        Food[] nonVeganFood = new Food[3];
        nonVeganFood[0] = new Food("Lasagna", false); /*One none-vegan*/
        nonVeganFood[1] = new Food("Apple", true);
        nonVeganFood[2] = new Food("Banana", true);
        VeganDiet veganDiet = new VeganDiet();

        assertFalse(veganDiet.isVegan);
    }


    /*will throw an exception if non-vegan food is added to a vegan diet*/
    @Test (expected = IllegalArgumentException.class)
    public void setVeganTrueIfFoodIsVeganExceptionTest() {
        Food[] onlyVeganFood = new Food[3];
        onlyVeganFood[0] = new Food("Apple", true);
        onlyVeganFood[1] = new Food("Nuts", true);
        onlyVeganFood[2] = new Food("Spaghetti", false); /*non-vegan*/
        VeganDiet diet = new VeganDiet();
        diet.setVeganStateToTrue(onlyVeganFood);

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