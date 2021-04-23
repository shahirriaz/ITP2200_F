import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlexitarianDietTest {

    @Test
    public void emptyConstructorTest(){
        FlexitarianDiet flexitarianDiet = new FlexitarianDiet();

        assertNotNull(flexitarianDiet);
    }


      @Test
    public void FlexitarianDietNameTest(){
          FlexitarianDiet f = new FlexitarianDiet("FlexitarianDiet");
          assertEquals("FlexitarianDiet", f.getName());

          f.setName("FlexitarianDietNameChange");
          assertEquals("FlexitarianDietNameChange", f.getName());
      }


    /*will check if i add non-vegan food, then the diet is non-vegan*/
      @Test
    public void setVeganFalseIfFoodIsNonVeganTest() {
          Food[] nonVeganFood = new Food[3];
          nonVeganFood[0] = new Food("Lasagna", false); /*non-vegan*/
          nonVeganFood[1] = new Food("Mandel", true);
          nonVeganFood[2] = new Food("Banana", true);
          FlexitarianDiet diet = new FlexitarianDiet();
          diet.setVeganFalseIfFoodIsNonVegan(nonVeganFood);

          assertFalse(diet.isVegan());

      }

    /*will check if i add only vegan food, then the diet is vegan*/
    @Test
    public void setVeganTrueIfFoodIsVeganTest() {
            Food[] onlyVeganFood = new Food[3];
            onlyVeganFood[0] = new Food("Apple", true);
            onlyVeganFood[1] = new Food("Nuts", true);
            onlyVeganFood[2] = new Food("Kiwi", true);
            FlexitarianDiet diet = new FlexitarianDiet();
            diet.setVeganTrueIfFoodIsVegan(onlyVeganFood);

            assertTrue(diet.isVegan());

    }

    /*will throw an exception if non-vegan food is added to a vegan diet*/
    @Test (expected = IllegalArgumentException.class)
    public void setVeganTrueIfFoodIsVeganExceptionTest() {
        Food[] onlyVeganFood = new Food[3];
        onlyVeganFood[0] = new Food("Apple", true);
        onlyVeganFood[1] = new Food("Nuts", true);
        onlyVeganFood[2] = new Food("Spaghetti", false); /*non-vegan*/
        FlexitarianDiet diet = new FlexitarianDiet();
        diet.setVeganTrueIfFoodIsVegan(onlyVeganFood);

    }

    /*sets the duration of diet in days*/
    @Test
    public void FlexitarianDietDaysDurationTest(){
        FlexitarianDiet flexitarianDiet = new FlexitarianDiet("FlexiDiet", 30);
        assertEquals("FlexiDiet", flexitarianDiet.getName());
        assertEquals(30, flexitarianDiet.getDaysDuration());

        flexitarianDiet.setName("FlexiDietNameChangeTest");
        flexitarianDiet.setDaysDuration(60);
        assertEquals("FlexiDietNameChangeTest", flexitarianDiet.getName());
        assertEquals(60, flexitarianDiet.getDaysDuration());
    }

    /*sets the duration of diet in days and months*/
    @Test
    public void FlexitarianDietDaysMonthDurationTest(){
        FlexitarianDiet flexitarianDiet = new FlexitarianDiet("FlexiDiet", 30, 5);
        assertEquals("FlexiDiet", flexitarianDiet.getName());
        assertEquals(30, flexitarianDiet.getDaysDuration());
        assertEquals(5, flexitarianDiet.getMonthDuration());

        flexitarianDiet.setName("FlexiDietNameChangeTest");
        flexitarianDiet.setDaysDuration(60);
        flexitarianDiet.setMonthDuration(3);
        assertEquals("FlexiDietNameChangeTest", flexitarianDiet.getName());
        assertEquals(60, flexitarianDiet.getDaysDuration());
        assertEquals(3, flexitarianDiet.getMonthDuration());
    }






}