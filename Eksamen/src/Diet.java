import java.util.Arrays;
import java.util.Date;

/*ABSTRACT CLASS*/
public abstract class Diet {


    String name;
    int daysDuration;
    int yearsDuration;
    int monthDuration;
    String purpose;
    Food[] allowedFood;
    Food food;
    boolean isVegan;


    public String writeDuration(Diet d) {
        String s = "This " + d.getName() + " lasts for " + d.getYearsDuration() + " years" + ", " + d.getMonthDuration() + " months"
                + " ," + d.getDaysDuration() + " days";
        return s;
    }

    /*Takes Diet object and Food array as arguments
    * Uses StringBuilder to add Food name from Array of Food Objects to the sentence "The following food is...salad, etc"
    * Using comma to separate the output //output: The following food....Salad, Soup
    * */
    public String writeAllowedFood(Food[] allowedFood, Diet diet) {
        String result = "";

        if (allowedFood.length > 0){
            StringBuilder sb = new StringBuilder();

            for (Food food : allowedFood){
                sb.append(food.getName()).append(", ");
            }
            result = sb.deleteCharAt(sb.length() - 2).toString();
        }
        return "The following food is allowed in this " + diet.getName() + ": "+ result;
    }


    /*Added this method in Diet because all diets use this method.*/
    public abstract boolean canBeFollowedOrNotBy(Person person);


    /*GETTER AND SETTERS*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsDuration() {
        return yearsDuration;
    }

    public int getMonthDuration() {
        return monthDuration;
    }

    public void setMonthDuration(int monthDuration) {
        this.monthDuration = monthDuration;
    }

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
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

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }


    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    @Override
    public String toString() {
        return "Diet{" +
                "name='" + name + '\'' +
                ", daysDuration=" + daysDuration +
                ", yearsDuration=" + yearsDuration +
                ", monthDuration=" + monthDuration +
                ", purpose='" + purpose + '\'' +
                ", allowedFood=" + Arrays.toString(allowedFood) +
                ", isVegan=" + isVegan +
                '}';
    }
}
