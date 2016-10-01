package cs.ualberta.ca.aabels_habittracker;

import junit.framework.TestCase;

import java.util.Collection;

/**
 * Created by Angus on 9/28/2016.
 */
public class HabitListTest extends TestCase {
    public void testEmptyHabitList() {
        HabitList habitList = new HabitList();
        assertTrue("Empty Habit List", habitList.size() == 0);
    }

    public void testAddHabit() {
        HabitList habitList = new HabitList();
        String habitName = "A Habit Name";
        Habit testHabit = new Habit(habitName);
        habitList.addHabit(testHabit);
        assertTrue("Habit List Size", habitList.size() == 1);
        assertTrue("Test Habit not contained", habitList.contains(testHabit));
    }

    public void testGetHabit() {
        HabitList habitList = new HabitList();
        String habitName = "A Habit Name";
        Habit testHabit = new Habit(habitName);
        habitList.addHabit(testHabit);
        Collection<Habit> habits = habitList.getHabits();
        assertTrue("Habit List Size", habits.size() == 1);
        assertTrue("Test Habit not contained", habits.contains(testHabit));
    }

    public void testRemoveHabit() {
        HabitList habitList = new HabitList();
        String habitName = "A Habit Name";
        Habit testHabit = new Habit(habitName);
        habitList.addHabit(testHabit);
        assertTrue("Habit List Size is too big", habitList.size() == 1);
        assertTrue("", habitList.contains(testHabit));
        habitList.deleteHabit(testHabit);
        assertTrue("Habit List Size is too small", habitList.size() == 0);
        assertFalse("Test Habit is still contained", habitList.contains(testHabit));
    }

    public void testPickHabit() {
        HabitList habitList = new HabitList();
        String habitName = "A Habit Name";
        Habit testHabit = new Habit(habitName);
        habitList.addHabit(testHabit);
        Habit habit = habitList.pickHabit();
        assertTrue("Habit is not null", habit != null);
        assertTrue("Didnt choose right habit", habit.equals(testHabit));
    }

    boolean updated = false;
    public void testNotifyListeners() {
        HabitList habitList = new HabitList();
        updated = false;
        HabitListener l = new HabitListener() {
            public void update() {
                HabitListTest.this.updated = true;
            }
        };
        habitList.addHabitListener(l);
        Habit testHabit = new Habit("NEWWWWW");
        habitList.addHabit(testHabit);
        assertTrue("Habit didnt got an update", this.updated);
        updated = false;
        habitList.deleteHabit(testHabit);
        assertTrue("Removing a Habit didnt got an update", this.updated);
    }

    public void testRemoveListeners() {
        HabitList habitList = new HabitList();
        updated = false;
        HabitListener l = new HabitListener() {
            public void update() {
                HabitListTest.this.updated = true;
            }
        };
        habitList.addHabitListener(l);
        habitList.removeHabitListener(l);
        habitList.addHabit(new Habit("NEWWWWWW"));
        assertFalse("Habit didnt get an update ", this.updated);
    }

}
