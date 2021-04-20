
/*ABSTRACT CLASS*/
public abstract class Diet {

    int daysDuration;
    String purpose;
    Food[] allowedFood;
    boolean isVegan;

    /*EMPTY CONSTRUCTOR*/
    public Diet() { };


/*ABSTRACT METHODS, IMPLEMENTED IN PERSON CLASS??*/
   public abstract String writeDuration();

   public abstract String writeAllowedFood();

/*GETTER AND SETTERS*/
    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Food[] getAllowedFood() {
        return allowedFood;
    }

    public void setAllowedFood(Food[] allowedFood) {
        this.allowedFood = allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

}
