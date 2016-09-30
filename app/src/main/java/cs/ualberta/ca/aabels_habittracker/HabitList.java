package cs.ualberta.ca.aabels_habittracker;

import java.util.ArrayList;
import java.util.Collection;
//create master list on habit list and then create subclasses monday_array list ...etc etc
//
/**
 * Created by Angus on 9/28/2016.
 */
public class HabitList {

    protected ArrayList<Habit> habitList;

    public HabitList() {
        habitList = new ArrayList<Habit>();
    }

    public Collection<Habit> getHabits() {
        return habitList;
    }

    public void addHabit(Habit testHabit) {
        habitList.add(testHabit);
    }

    public void deleteHabit(Habit testHabit) {
        habitList.remove(testHabit);
    }

    public Habit pickHabit() {
        //need to impliment how to return index selected
        return habitList.get(0);
    }

    public int size() {
        return habitList.size();
    }

    public boolean contains(Habit testHabit) {
        return habitList.contains(testHabit);
    }
}
