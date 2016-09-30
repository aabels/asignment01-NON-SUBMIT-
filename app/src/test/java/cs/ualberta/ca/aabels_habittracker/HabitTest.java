package cs.ualberta.ca.aabels_habittracker;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.Date;
import java.util.prefs.Preferences;

import cs.ualberta.ca.aabels_habittracker.Habit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class HabitTest extends TestCase{

    public void testHabit() {
        String habitName = "A habit";
        Habit habit = new Habit(habitName);
        assertTrue("Habit name is not equal", habitName.equals(habit.getName()));
    }
    public void testCreationDateHabit() {
        String habitName = "A habit";
        String habitCreationDate = "2016-09-29";
        Habit habit = new Habit(habitName);
        assertTrue("Habit name is not equal", habitName.equals(habit.getName()));
        assertTrue("Habit name is null", habit.getHabitCreationDate().equals("2016-09-29"));
        assertTrue("Habit date is not equal", habitCreationDate.equals(habit.getHabitCreationDate()));
    }

//    public void testDayOfWeek() {
//        Date habitCreationDate = new Date();
//        Habit habit = new Habit(habitName, habitCreationDate);
//        assertTrue("Habit name is not equal", habitName.equals(habit.getName()));
//        assertTrue("Habbit date is not equal", habitCreationDate.equals(habit.getCreationHabitDate()));
//    }
}