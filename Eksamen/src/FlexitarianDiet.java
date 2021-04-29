public class  FlexitarianDiet extends Diet {

    Float maxMeatGramsPerWeek;
    Food preferredMeat;

    public FlexitarianDiet() { }

    public FlexitarianDiet(String name){
        super.setName(name);
    }

    @Override
    public boolean canBeFollowedOrNotBy(Person person) {
        if(person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50 && (!(person.diet instanceof VeganDiet))){
            person.setDiet(person.diet);
            return true;
        }else
            throw new IllegalArgumentException("This diet cannot be followed");
    }


    public FlexitarianDiet(String name, Food[] allowedFood){
        super.setName(name);
        super.setAllowedFood(allowedFood);
    }


    /*
    * Will throw an exception if preferredMeat is vegan, otherwise it will assign correct meat to the
    * preferredMeat property
    * */
    public FlexitarianDiet(Food preferredMeat) {
        if(preferredMeat.isVegan) throw
                new IllegalArgumentException("This diet only contains non-vegan meat of type protein");
        this.preferredMeat = preferredMeat;
    }



    /*IF THE DIET LASTS FOR ONLY DAYS*/
    public FlexitarianDiet(String name, int daysDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
    }
    /*IF THE DIET LASTS FOR ONLY DAYS AND MONTHS*/
    public FlexitarianDiet(String name, int daysDuration, int monthDuration){
        super.setName(name);
        super.setDaysDuration(daysDuration);
        super.setMonthDuration(monthDuration);
    }

/*GETTER AND SETTER*/
    public Food getPreferredMeat() {
        return preferredMeat;
    }

    public void setPreferredMeat(Food preferredMeat) {
        this.preferredMeat = preferredMeat;
    }

}

