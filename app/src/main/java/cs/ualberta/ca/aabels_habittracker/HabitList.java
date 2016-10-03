package cs.ualberta.ca.aabels_habittracker;

import android.widget.ArrayAdapter;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
//create master list on habit list and then create subclasses monday_array list ...etc etc
//
/**
 * Created by Angus on 9/28/2016.
 */
public class HabitList implements Serializable {

    private static final long serialVersionUID = 12L;

    protected ArrayList<Habit> habitList = null;
    protected transient ArrayList<HabitListener> habitListeners = null;

    public HabitList() {

        habitList = new ArrayList<Habit>();
        habitListeners = new ArrayList<HabitListener>();
    }

    private ArrayList<HabitListener> getHabitListeners() {
        if (habitListeners == null) {
            habitListeners = new ArrayList<HabitListener>();
        }
        return habitListeners;
    }

    public Collection<Habit> getHabits() {
        return habitList;
    }
    
    //Get collection of habit completions
//    public Collection<Habit> getAllHabitCompletions() {
//        return habitCompletions;
//    }


    public void addHabit(Habit testHabit) {
        habitList.add(testHabit);
        notifyListeners();
    }

    public void notifyListeners() {
        for (HabitListener habitListener : getHabitListeners()) {
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
        getHabitListeners().add(l);
    }

    public void removeHabitListener(HabitListener l) {
        getHabitListeners().remove(l);
    }
}
