package cs.ualberta.ca.aabels_habittracker;

import java.util.Date;

/**
 * Created by Angus on 9/28/2016.
 */
public class Habit {
    protected String habitName;
    private Date habitCreationDate;

    public Habit(String habitName, Date habitCreationDate) {
        this.habitName = habitName;
        this.habitCreationDate = habitCreationDate;
    }

    public String getName() {
        return this.habitName;
    }

    public Date getCreationHabitDate() {
        habitCreationDate = new Date();
        return this.habitCreationDate;
    }
}
