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