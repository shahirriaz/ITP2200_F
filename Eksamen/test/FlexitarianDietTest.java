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

      /*will test if correct values are assigned to FlexitarianDiet object
      * Correct values are: non-vegan food, FoodType.Protein
      * */
      @Test
      public void FlexitarianDietPreferredMeatTest(){
        FlexitarianDiet f = new FlexitarianDiet(new Food("Beef", FoodType.Protein, false));
        assertTrue(f.getPreferredMeat().name.equals("Beef")
                && f.getPreferredMeat().type.equals(FoodType.Protein));

      }

        /*expected behaviour: It will throw exception because preferredMeat MUST be non-vegan food of protein
        type. */
        @Test (expected = IllegalArgumentException.class)
        public void FlexitarianDietPreferredMeatTest_ExceptionTest(){
            FlexitarianDiet preferredMeat = new FlexitarianDiet(new Food("KidneyBeans", FoodType.Carb, true));
        }


    /*will check if i add ONLY NONE-VEGAN FOOD, then the diet is non-vegan*/
      @Test
    public void setVeganStateToFalseTest_a() {
          Food[] nonVeganFood = new Food[3];
          nonVeganFood[0] = new Food("Lasagna", false);
          nonVeganFood[1] = new Food("Meatball", false);
          nonVeganFood[2] = new Food("Eggs", false);

          FlexitarianDiet diet = new FlexitarianDiet();
          diet.setVeganStateToFalse(nonVeganFood);

          LowCarbDiet diet1 = new LowCarbDiet();
          diet1.setVeganStateToFalse(nonVeganFood);

          assertFalse(diet.isVegan);
          assertFalse(diet1.isVegan);

      }

    /*will check if i add atleast ONE NONE-VEGAN food*/
    @Test
    public void setVeganStateToFalse_b() {
        Food[] nonVeganFood = new Food[3];
        nonVeganFood[0] = new Food("Lasagna", false); /*One none-vegan*/
        nonVeganFood[1] = new Food("Apple", true);
        nonVeganFood[2] = new Food("Banana", true);
        FlexitarianDiet diet = new FlexitarianDiet();
        diet.setVeganStateToFalse(nonVeganFood);

        assertFalse(diet.isVegan);
    }

    @Test
    public void setVeganToTrueTest() {
            Food[] onlyVeganFood = new Food[3];
            onlyVeganFood[0] = new Food("Apple", true);
            onlyVeganFood[1] = new Food("Nuts", true);
            onlyVeganFood[2] = new Food("Kiwi", true);

            FlexitarianDiet flexitarianDiet = new FlexitarianDiet();
            flexitarianDiet.setVeganStateToTrue(onlyVeganFood);

            LowCarbDiet lowCarbDiet1 = new LowCarbDiet();
            lowCarbDiet1.setVeganStateToTrue(onlyVeganFood);


            assertTrue(flexitarianDiet.isVegan());
            assertTrue(lowCarbDiet1.isVegan());

    }

    /*will throw an exception if atleast ONE NONE-VEGAN food is added to a vegan diet*/
    @Test (expected = IllegalArgumentException.class)
    public void cannotContainNoneVeganFoodTest() {
        Food[] onlyVeganFood = new Food[3];
        onlyVeganFood[0] = new Food("Apple", true);
        onlyVeganFood[1] = new Food("Nuts", true);
        onlyVeganFood[2] = new Food("Spaghetti", false); /*none-vegan*/
        FlexitarianDiet diet = new FlexitarianDiet();
        diet.setVeganStateToTrue(onlyVeganFood);
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