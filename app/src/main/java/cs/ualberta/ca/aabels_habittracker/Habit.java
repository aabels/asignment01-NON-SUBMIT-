package cs.ualberta.ca.aabels_habittracker;

/**
 * Created by Angus on 9/28/2016.
 */
public class Habit {
    protected String habitName;
    public Habit(String habitName) {
        this.habitName = habitName;
    }

    public String getName() {
        return this.habitName;
    }
}
