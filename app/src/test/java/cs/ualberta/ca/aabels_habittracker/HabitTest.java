package cs.ualberta.ca.aabels_habittracker;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.Date;

import cs.ualberta.ca.aabels_habittracker.Habit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class HabitTest extends TestCase{
    String habitName = "A habit";
    Date habitCreationDate;
    public void testHabit() {
        Habit habit = new Habit(habitName, habitCreationDate);
        assertTrue("Habit name is not equal", habitName.equals(habit.getName()));
    }
    public void testCreationDateHabit() {
        Date habitCreationDate = new Date();
        Habit habit = new Habit(habitName, habitCreationDate);
        assertTrue("Habit name is not equal", habitName.equals(habit.getName()));
        assertTrue("Habbit date is not equal", habitCreationDate.equals(habit.getCreationHabitDate()));
    }

//    public void testDayOfWeek() {
//        Date habitCreationDate = new Date();
//        Habit habit = new Habit(habitName, habitCreationDate);
//        assertTrue("Habit name is not equal", habitName.equals(habit.getName()));
//        assertTrue("Habbit date is not equal", habitCreationDate.equals(habit.getCreationHabitDate()));
//    }
}