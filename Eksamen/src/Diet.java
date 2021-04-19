
/*ABSTRACT CLASS*/
public abstract class Diet {

    int daysDuration;
    String purpose;
    Food[] allowedFood;
    boolean isVegan;

    /*EMPTY CONSTRUCTOR*/
    public Diet() {

    }


    public Diet(int daysDuration, String purpose, Food[] allowedFood, Boolean isVegan) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
        this.isVegan = isVegan;
    }



    /*ABSTRACT METHODS, IMPLEMENTED IN PERSON CLASS??*/
   public abstract String writeDuration();

   public abstract String writeAllowedFood();


}
