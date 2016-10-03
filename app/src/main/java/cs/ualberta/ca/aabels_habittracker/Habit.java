package cs.ualberta.ca.aabels_habittracker;

import android.text.TextUtils;

import java.io.Serializable;
import java.io.SerializablePermission;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Angus on 9/28/2016.
 */
public class Habit implements Serializable {

    private static final long serialVersionUID = 40L;

    protected String daysOfTheWeekString = "";
    protected String habitName;
    protected String habitCreationDate;
    protected String habitUpdateDate;
//    protected String habitCompletetion;
    private ArrayList<String> daysOfTheWeekList;
    private Date local_date;


    public Habit(String habitName) {
        this.habitName = habitName;
        this.habitCreationDate = getHabitCreationDate();
        this.habitUpdateDate = getUpdateDate();
//        this.habitCompletetion = habitCompletion;
    }
//
    public String getDaysOfTheWeek() {
        daysOfTheWeekString = TextUtils.join(", ", daysOfTheWeekList);
        return daysOfTheWeekString;
    }

    public void setDaysOfTheWeek( ArrayList<String> dayList) {
        this.daysOfTheWeekList = dayList;
    }

    public String getName() {
        return this.habitName;
    }

    public String toString() {
        return getName()+"\n"+
                "                    " +
                "("+getDaysOfTheWeek()+")"
                +"\n"+ getHabitCreationDate();
    }

    public boolean equals (Object compareHabit) {
        if (compareHabit != null &&
                compareHabit.getClass() == this.getClass()) {
            return this.equals((Habit) compareHabit);
        } else {
            return false;
        }
    }

    public boolean equals (Habit compareHabit) {
        if(compareHabit == null){
            return false;
        }
        return getName().equals(compareHabit.getName());
    }

    public int hashCode() {
        return ("Habit:"+getName()).hashCode();
    }

//http://stackoverflow.com/questions/7651221/android-how-to-get-the-current-day-of-the-week-monday-etc-in-the-users-l
    public String getHabitCreationDate() {
        local_date = new Date();
        DateFormat aformat = new SimpleDateFormat("yyyy-MM-dd");
        habitCreationDate = "Created On: "+aformat.format(local_date);
        return this.habitCreationDate;
    }

    //Have not figured away to show to show on screen the updated time but
    // this method does return the date, hour and min of the updated habit
    public String getUpdateDate() {
        local_date = new Date();
        DateFormat aformat = new SimpleDateFormat("yyyy-MM-dd HH: mm a");
        habitUpdateDate = aformat.format(local_date);
        return this.habitUpdateDate;
    }
}
