public class  FlexitarianDiet extends Diet {

    Float maxMeatGramsPerWeek;
    Food preferredMeat;

    public FlexitarianDiet() { }

    public FlexitarianDiet(String name){
        super.setName(name);
    }


    public FlexitarianDiet(Food[] allowedFood){
        super.setAllowedFood(allowedFood);
    }


    @Override
    public boolean isCompatible(Person person) {
        if(person.getFavoriteFood().isVegan && person.getPercentThatMatch(allowedFood, person.getAllergies()) <= 50)
            return true;
        return false;

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

