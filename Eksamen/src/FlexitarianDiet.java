public class FlexitarianDiet extends Diet {

    Float maxMeatGramsPerWeek;
    Food preferredMeat;

    public FlexitarianDiet() { }

    public FlexitarianDiet(String name){
        super.setName(name);
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


    public void setVeganStateToFalse(Food[] food){
        for (Food f: food)
            if (!f.isVegan){
            super.setVegan(false);
            super.setAllowedFood(food);
        }
    }
    public void setVeganStateToTrue(Food[] food){
        for(Food f: food)
            /*if food is not vegan*/
            if (!f.isVegan)
                throw new IllegalArgumentException("A vegan diet cannot contain any non-vegan food");
            else {
                super.setVegan(true);
                super.setAllowedFood(food);
            }
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

