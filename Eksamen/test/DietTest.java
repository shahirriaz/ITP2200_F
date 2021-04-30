import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DietTest {


    @Test
    public void req_1_a(){
        Food[] food = new Food[3];
        food[0] =  new Food("Rice", FoodType.Carb, true);
        food[1] =  new Food("Beans", FoodType.Protein, true);
        food[2] =  new Food("Pølse", FoodType.Carb, false);

        VeganDiet diet = new VeganDiet("VeganDiet",food);

        /*Cannot contain any none vegan food*/
        assertFalse(diet.isVeganCompatible(food));
    }

    @Test
    public void req_1_b(){
        Food[] food = new Food[3];
        food[0] =  new Food("Rice", FoodType.Carb, true);
        food[1] =  new Food("Beans", FoodType.Protein, true);
        food[2] =  new Food("Avocado", FoodType.Carb, true);

        VeganDiet diet = new VeganDiet("VeganDiet",food);
        LowCarbDiet diet1 = new LowCarbDiet(food);

        assertTrue(diet.isVeganCompatible(food));



    }


    /*will test if correct values are assigned to FlexitarianDiet object
     * Correct values are: non-vegan food, FoodType.Protein
     * */
    @Test
    public void req_1_d_0(){
        FlexitarianDiet f = new FlexitarianDiet(new Food("Beef", FoodType.Protein, false));
        assertTrue(f.getPreferredMeat().name.equals("Beef")
                && f.getPreferredMeat().type.equals(FoodType.Protein));

    }

    /*expected behaviour: It will throw exception because preferredMeat MUST be non-vegan food of protein
    type. */
    @Test (expected = IllegalArgumentException.class)
    public void req_1_d_1(){
        new FlexitarianDiet(new Food("KidneyBeans", FoodType.Carb, true));
    }

    /*Maximum number of foodType Carb is two*/
    @Test
    public void  req_1_e_0(){
        Food[] carbFoods = new Food[2];
        carbFoods[0] = new Food("Rice", FoodType.Carb);
        carbFoods[1] = new Food("Potato", FoodType.Carb);
        LowCarbDiet lowCarbDiet = new LowCarbDiet(carbFoods);

        assertTrue(lowCarbDiet.maxiMumCarbFoodAllowed(carbFoods) <= 2);
    }

    /*Maximum number of foodType Carb is two*/
    @Test (expected = IllegalArgumentException.class)
    public void  req_1_e_1(){
        Food[] carbFoods = new Food[3];
        carbFoods[0] = new Food("Rice", FoodType.Carb);
        carbFoods[1] = new Food("Potato", FoodType.Carb);
        carbFoods[2] = new Food("Hamburger", FoodType.Carb);
         new LowCarbDiet(carbFoods);

    }


    @Test
    public void req_3_a_0(){
        FlexitarianDiet diet1 = new FlexitarianDiet("FlexitarianDiet", 90);
        String result = diet1.writeDuration(diet1);

        /*0 years, 0 months, 90 days*/
        assertEquals("This FlexitarianDiet lasts for 0 years, 0 months ,90 days", result);
    }

    @Test
    public void req_3_a_1(){
        FlexitarianDiet diet1 = new FlexitarianDiet("FlexitarianDiet", 90, 6);
        String result = diet1.writeDuration(diet1);

        /*0 years, 6 months, 90 days*/
        assertEquals("This FlexitarianDiet lasts for 0 years, 6 months ,90 days", result);
    }

    @Test
    public void req_3_b(){
        FlexitarianDiet diet1 = new FlexitarianDiet("FlexitarianDiet");
        Food[] allowedFood = new Food[2];
        allowedFood[0] = new Food("Salad");
        allowedFood[1] = new Food("Soup");
        String result = diet1.writeAllowedFood(allowedFood, diet1);
        assertEquals("The following food is allowed in this FlexitarianDiet: Salad, Soup", result.trim());
    }


}