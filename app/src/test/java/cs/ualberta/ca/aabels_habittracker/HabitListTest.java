package cs.ualberta.ca.aabels_habittracker;

import junit.framework.TestCase;

import java.util.Collection;

/**
 * Created by Angus on 9/28/2016.
 */
public class HabitListTest extends TestCase {
    public void testEmptyHabitList() {
        HabitList habitList = new HabitList();
        Collection<Habit> habits = habitList.getHabits();
        assertTrue("Empty Habit List", habits.size() == 0);
    }

    public void testAddHabit() {
        HabitList habitList = new HabitList();
        String habitName = "A Habit Name";
        Habit testHabit = new Habit(habitName);
        habitList.addHabit(testHabit);
        Collection<Habit> habits = habitList.getHabits();
        assertTrue("Habit List Size", habits.size() == 1);
        assertTrue("", habits.contains(testHabit));
    }

    public void testRemoveHabit() {
        HabitList habitList = new HabitList();
        String habitName = "A Habit Name";
        Habit testHabit = new Habit(habitName);
        habitList.addHabit(testHabit);
        Collection<Habit> habits = habitList.getHabits();
        assertTrue("Habit List Size is too big", habits.size() == 1);
        assertTrue("", habits.contains(testHabit));
        habitList.deleteHabit(testHabit);
        habits = habitList.getHabits();
        assertTrue("Habit List Size is too small", habits.size() == 0);
        assertFalse("Habit is still contained", habits.contains(testHabit));
    }
}
