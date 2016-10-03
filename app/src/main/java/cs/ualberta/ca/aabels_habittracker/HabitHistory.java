package cs.ualberta.ca.aabels_habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;

//Was going to implement an ArrayList for each habit showing completions
//along with updatedHabitDate
public class HabitHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_history);
        HabitListManager.initHabitManager(this.getApplicationContext());
        Collection<Habit> habits = HabitListController.getHabitList().getHabits();
        final ArrayList list = new ArrayList<Habit>(habits);
    }
}
