package cs.ualberta.ca.aabels_habittracker;

import android.test.AndroidTestCase;

/**
 * Created by Angus on 10/1/2016.
 */
public class HabitListManagerTest  extends AndroidTestCase {

    public void testHabitListManager() {
        HabitList thl = new HabitList();
        Habit testHabit = new Habit("I am a test habit");
        thl.addHabit(testHabit);
        HabitListManager hlm = new HabitListManager(getContext());
        hlm.saveHabitList(thl);
        HabitList thl2 = hlm.loadHabitList();
        assertTrue("Test Habit is in student list2", thl2.contains(testHabit));
        assertTrue("Test Habit is in student list2", thl.contains(testHabit));
    }
}

