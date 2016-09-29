package cs.ualberta.ca.aabels_habittracker;

import junit.framework.TestCase;

import org.junit.Test;
import cs.ualberta.ca.aabels_habittracker.Habit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class HabitTest extends TestCase{
    String habitName = "A habit";
    public void testHabit() {
        Habit habit = new Habit(habitName);
        assertTrue("Habit name is not equal", habitName.equals(habit.getName()));
    }
}