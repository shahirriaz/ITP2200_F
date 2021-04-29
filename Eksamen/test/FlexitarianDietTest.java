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


    @Test // public boolean canBeFollowedOrNotBy(Person person)
    public void canBeFollowedOrNotByTest_1() {
        Food[] allowedFood = new Food[5];
        allowedFood[0] = new Food( "Potato", FoodType.Carb, true );
        allowedFood[1] = new Food( "Rice", FoodType.Carb, true );
        allowedFood[2] = new Food( "Bread", FoodType.Carb, true );
        allowedFood[3] = new Food( "Juice", FoodType.Carb, true );
        allowedFood[4] = new Food( "Beef", FoodType.Protein, false );

        Food[] allergies = new Food[3];
        allergies[0] = new Food( "Bread" );
        allergies[1] = new Food( "Diary" );
        allergies[2] = new Food( "Rice" );

        FlexitarianDiet flexitarianDiet = new FlexitarianDiet( "FlexiTarianDiet", allowedFood );
        Food favoriteFood = new Food( "Apple", true );

        Person person = new Person( favoriteFood, allergies, flexitarianDiet, 70f );
        flexitarianDiet.canBeFollowedOrNotBy( person );

        assertTrue( person.getFavoriteFood().isVegan );
        assertTrue( person.getPercentThatMatch( allowedFood, person.getAllergies() ) <= 50 );
        assertFalse( person.diet.isVegan );

        assertTrue( flexitarianDiet.canBeFollowedOrNotBy( person ) );

        /*will throw error -- cannot add veganDoet to FlexiTarianDiet where Meat is present*/
        person.setDiet( new VeganDiet() );

         assertThrows( IllegalArgumentException.class, () -> flexitarianDiet.canBeFollowedOrNotBy( person ) );
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