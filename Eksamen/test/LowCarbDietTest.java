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



}