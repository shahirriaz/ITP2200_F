import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DietTest {

    @Test
    public void writeDaysDurationTest(){
        FlexitarianDiet diet1 = new FlexitarianDiet("FlexitarianDiet", 90);
        String result = diet1.writeDuration(diet1);
        assertEquals("This FlexitarianDiet lasts for 0 years, 0 months ,90 days", result);
    }

    @Test
    public void writeDaysMonthDurationTest(){
        FlexitarianDiet diet1 = new FlexitarianDiet("FlexitarianDiet", 90, 6);
        String result = diet1.writeDuration(diet1);
        assertEquals("This FlexitarianDiet lasts for 0 years, 6 months ,90 days", result);
    }

    @Test
    public void writeAllowedFoodTest(){
        FlexitarianDiet diet1 = new FlexitarianDiet("FlexitarianDiet");
        Food[] allowedFood = new Food[2];
        allowedFood[0] = new Food("Salad");
        allowedFood[1] = new Food("Soup");
        String result = diet1.writeAllowedFood(allowedFood, diet1);
        assertEquals("The following food is allowed in this FlexitarianDiet: Salad, Soup", result.trim());
    }

}