package cs.ualberta.ca.aabels_habittracker;

import java.io.IOException;

/**
 * Created by Angus on 9/30/2016.
 */
public class HabitListController {

    //Lazy Singleton
    private static HabitList habitList = null;
    //If a habit list isnt created yet it will catch error otherwise
    // it will grab the habits from the habitmanager and save the habitlist
    static public HabitList getHabitList() {
        if (habitList == null) {
            try {
                habitList = HabitListManager.getHabitManager().loadHabitList();
                habitList.addHabitListener(new HabitListener() {
                    @Override
                    public void update() {
                        saveHabitList();
                    }
                });
            }
            catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Couldnt deserialize HabitList from HabitListManager");
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Couldnt deserialize HabitList from HabitListManager");
            }
        }
        return habitList;
    }

    static public void saveHabitList() {
        try {
            HabitListManager.getHabitManager().saveHabitList(getHabitList());
            }
        catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Couldnt deserialize HabitList from HabitListManager");
            }
    }

    public void addHabit(Habit habit) {
        getHabitList().addHabit(habit);
    }
}
