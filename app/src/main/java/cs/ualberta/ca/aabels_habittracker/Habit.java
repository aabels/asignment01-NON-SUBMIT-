package cs.ualberta.ca.aabels_habittracker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Angus on 9/28/2016.
 */
public class Habit {
    protected String habitName;
    protected String habitCreationDate;
    protected String habitUpdateDate;
    private Date local_date;

//    public Habit(String habitName) {
//        this.habitName = habitName;
//        this.local_date = new Date();
//    }

    public Habit(String habitName) {
        this.habitName = habitName;
        this.habitCreationDate = getHabitCreationDate();
        this.habitUpdateDate = getUpdateDate();
    }

    public String getName() {
        return this.habitName;
    }

    public String toString() {
        return getName()+'\n'+ getHabitCreationDate();
    }

//http://stackoverflow.com/questions/7651221/android-how-to-get-the-current-day-of-the-week-monday-etc-in-the-users-l
    public String getHabitCreationDate() {
        local_date = new Date();
        DateFormat aformat = new SimpleDateFormat("yyyy-MM-dd");
        habitCreationDate = aformat.format(local_date);
        return this.habitCreationDate;
    }

    public String getUpdateDate() {
        local_date = new Date();
        DateFormat aformat = new SimpleDateFormat("yyyy-MM-dd HH: mm a");
        String updated_date = aformat.format(local_date);
        return updated_date;
    }
}
