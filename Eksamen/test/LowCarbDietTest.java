import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LowCarbDietTest {

    @Test
    public void emptyConstructorTest() {
        LowCarbDiet lowCarbDiet = new LowCarbDiet();

        assertNotNull(lowCarbDiet);
    }

    @Test
    public void LowCarbDietNameTest(){
        LowCarbDiet lowCarbDiet = new LowCarbDiet("LowCarbDiet");
        assertEquals("LowCarbDiet", lowCarbDiet.getName());

        lowCarbDiet.setName("LowCarbDietNameChange");
        assertEquals("LowCarbDietNameChange", lowCarbDiet.getName());
    }

    /*Maximum number of foodType Carb is two*/
    @Test
    public void noMoreThanTwoCarbFoodsTest_a(){
        Food[] carbFoods = new Food[2];
        carbFoods[0] = new Food("Rice", FoodType.Carb);
        carbFoods[1] = new Food("Potato", FoodType.Carb);
        LowCarbDiet lowCarbDiet = new LowCarbDiet();
        lowCarbDiet.maxiMumCarbFoodAllowed(carbFoods);
    }

    /*Maximum number of foodType Carb is two*/
    @Test (expected = IllegalArgumentException.class)
    public void noMoreThanTwoCarbFoodsTest_b(){
        Food[] carbFoods = new Food[3];
        carbFoods[0] = new Food("Rice", FoodType.Carb);
        carbFoods[1] = new Food("Potato", FoodType.Carb);
        carbFoods[2] = new Food("Hamburger", FoodType.Carb);
        LowCarbDiet lowCarbDiet = new LowCarbDiet();
        lowCarbDiet.maxiMumCarbFoodAllowed(carbFoods);
    }


}