import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void emptyConstructorTest(){
        Person person = new Person();

        assertNotNull(person);
    }

    /*Cannot follow a vegan diet if favorite food is non-vegan*/
    /*Must not be allowed to follow VeganDiet*/
    @Test (expected = IllegalArgumentException.class)
    public void nonVeganFoodTest_a(){
        Food favoriteFood = new Food("Hamburger", false);
        VeganDiet veganDiet = new VeganDiet();
        Person person = new Person();
        person.setVeganDietIfFoodIsVegan(person,favoriteFood,veganDiet);
    }

    @Test
    public void nonVeganFoodTest_b(){
        Food favoriteFood = new Food("Apple", true);
        VeganDiet veganDiet = new VeganDiet();
        Person person = new Person();
        person.setVeganDietIfFoodIsVegan(person,favoriteFood,veganDiet);
        veganDiet.setVegan(true);

        assertTrue(person.diet.isVegan);
        System.out.println(person.toString());

    }





}