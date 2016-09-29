package cs.ualberta.ca.aabels_habittracker;

import java.util.ArrayList;
import java.util.Collection;

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
}
