package cs.ualberta.ca.aabels_habittracker;

import android.widget.ArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
//create master list on habit list and then create subclasses monday_array list ...etc etc
//
/**
 * Created by Angus on 9/28/2016.
 */
public class HabitList implements Serializable {

    protected ArrayList<Habit> habitList;
    protected ArrayList<HabitListener> habitListeners;

    public HabitList() {

        habitList = new ArrayList<Habit>();
        habitListeners = new ArrayList<HabitListener>();
    }

    public Collection<Habit> getHabits() {
        return habitList;
    }

    public void addHabit(Habit testHabit) {
        habitList.add(testHabit);
        notifyListeners();
    }

    private void notifyListeners() {
        for (HabitListener habitListener : habitListeners) {
            habitListener.update();
        }
    }

    public void deleteHabit(Habit testHabit) {
        habitList.remove(testHabit);
        notifyListeners();
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

    public void addHabitListener(HabitListener l) {
        habitListeners.add(l);
    }

    public void removeHabitListener(HabitListener l) {
        habitListeners.remove(l);
    }
}
