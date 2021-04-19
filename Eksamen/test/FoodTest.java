import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FoodTest {

    @Test
    public void foodConstructorTest(){
        Food f = new Food("Pizza", false, 200, FoodType.Recipe);

        assertEquals("Pizza", f.getName());
        assertFalse(f.isVegan);
        assertEquals(200, f.getCaloriesPerDay());
        assertEquals(FoodType.Recipe, f.getType());
    }

}