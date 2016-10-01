package cs.ualberta.ca.aabels_habittracker;

/**
 * Created by Angus on 9/30/2016.
 */
public class HabitListController {

    //Lazy Singleton
    private static HabitList habitList = null;
    static public HabitList getHabitList() {
        if (habitList == null) {
            habitList = new HabitList();
        }
        return habitList;
    }

//    public Habit pickHabit() {
//        return getHabitList().pickHabit();
//    }

    public void addHabit(Habit habit) {
        getHabitList().addHabit(habit);
    }

    public void deleteHabit(Habit habit) {
        getHabitList().deleteHabit(habit);
    }
}
