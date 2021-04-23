import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlexitarianDietTest {

      @Test
    public void FlexitarianDietNameTest(){
          FlexitarianDiet f = new FlexitarianDiet("FlexitarianDiet");
          assertEquals("FlexitarianDiet", f.getName());
      }


      /*will check if i add non vegan food, the diet = IsVegan = false*/
      @Test
    public void FlexitarianDietCheckVeganism_b() {
          Food[] nonVeganFood = new Food[3];
          nonVeganFood[0] = new Food("Lasagna", false);
          nonVeganFood[1] = new Food("Pizza", false);
          nonVeganFood[2] = new Food("BANANA", true);
          FlexitarianDiet diet = new FlexitarianDiet(nonVeganFood);

          assertFalse(diet.isVegan());

      }





}