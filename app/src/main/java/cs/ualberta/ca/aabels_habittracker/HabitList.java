package cs.ualberta.ca.aabels_habittracker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Angus on 9/28/2016.
 */
public class HabitList implements Serializable {

    private static final long serialVersionUID = 12L;

    protected ArrayList<Habit> habitList = null;
    //HabitManager doesnt need to save the habitListeners
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

    //returns a list of all Habits
    public Collection<Habit> getHabits() {
        return habitList;
    }

    public void addHabit(Habit testHabit) {
        habitList.add(testHabit);
        notifyListeners();
    }

    //called when a habit is updated/modified
    public void notifyListeners() {
        for (HabitListener habitListener : getHabitListeners()) {
            habitListener.update();
        }
    }

    public void deleteHabit(Habit testHabit) {
        habitList.remove(testHabit);
        notifyListeners();
    }

    public Habit pickHabit(int index) {
        return habitList.get(index);
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
