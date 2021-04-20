import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DietTest {

    @Test
    public void test(){
        Diet d = new Diet() {
            @Override
            public String writeDuration() {
                return null;
            }

            @Override
            public String writeAllowedFood() {
                return null;
            }
        };

    }

}