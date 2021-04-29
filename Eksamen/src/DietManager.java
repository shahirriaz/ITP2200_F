public class DietManager {

    boolean areCompatible;

    public DietManager(){};

    public boolean isAreCompatible(Person p, Diet diet){
        if(!p.getFavoriteFood().isVegan() && diet instanceof VeganDiet)
            throw new IllegalArgumentException("Error, favorite food is nonVegan");
        new Person(p.getFavoriteFood(), p.getAllergies(), p.getWeight()).setDiet(diet);
        return true;
    }
    public HyperCaloricDiet randomDiet(Person p, Food[] foods){
        return null;

    }
}
