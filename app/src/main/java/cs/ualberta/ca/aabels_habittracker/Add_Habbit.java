package cs.ualberta.ca.aabels_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class Add_Habbit extends AppCompatActivity {

    final ArrayList<String> dayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
        HabitListManager.initHabitManager(this.getApplicationContext());
    }

    public void creatHabitAction(View v) {
        Toast.makeText(this, "Creating Habit", Toast.LENGTH_SHORT).show();

        HabitListController ht = new HabitListController();

        EditText habitText = (EditText) findViewById(R.id.createHabitView);
        //Grabs the habitName and creates new instance of the Habit
        Habit habit = new Habit((habitText.getText().toString()));
        //Have not figured how to display the Days Selected but they are saved to the Habit.
        habit.setDaysOfTheWeek(dayList);
        ht.addHabit(habit);
        finish();
    }

    public void sundaySwitch(View v) {
        // somehow get the value of the switch the got turned on
        Toast.makeText(this, "Added Habit to: Sunday", Toast.LENGTH_SHORT).show();
        boolean on = ((Switch) v).isChecked();
        if (on) {
            dayList.add("Sun");
        }
        else {
            dayList.remove("Sun");
        }
    }

    public void mondaySwitch(View v) {
        // somehow get the value of the switch the got turned on
        Toast.makeText(this, "Added Habit to: Monday", Toast.LENGTH_SHORT).show();
        boolean on = ((Switch) v).isChecked();
        if (on) {
            dayList.add("Mon");
        }
        else {
            dayList.remove("Mon");
        }
    }

    public void tuesdaySwitch(View v) {
        // somehow get the value of the switch the got turned on
        Toast.makeText(this, "Added Habit to: Tuesday", Toast.LENGTH_SHORT).show();
        boolean on = ((Switch) v).isChecked();
        if (on) {
            dayList.add("Tues");
        }
        else {
            dayList.remove("Tues");
        }
    }

    public void wednesdaySwitch(View v) {
        // somehow get the value of the switch the got turned on
        Toast.makeText(this, "Added Habit to: Wednesday", Toast.LENGTH_SHORT).show();
        boolean on = ((Switch) v).isChecked();
        if (on) {
            dayList.add("Wed");
        }
        else {
            dayList.remove("Wed");
        }
    }

    public void thursdaySwitch(View v) {
        // somehow get the value of the switch the got turned on
        Toast.makeText(this, "Added Habit to: Thursday", Toast.LENGTH_SHORT).show();
        boolean on = ((Switch) v).isChecked();
        if (on) {
            dayList.add("Thr");
        }
        else {
            dayList.remove("Thr");
        }
    }

    public void fridaySwitch(View v) {
        // somehow get the value of the switch the got turned on
        Toast.makeText(this, "Added Habit to: Friday", Toast.LENGTH_SHORT).show();
        boolean on = ((Switch) v).isChecked();
        if (on) {
            dayList.add("Fri");
        }
        else {
            dayList.remove("Fri");
        }
    }

    public void saturdaySwitch(View v) {
        // somehow get the value of the switch the got turned on
        Toast.makeText(this, "Added Habit to: Saturday", Toast.LENGTH_SHORT).show();
        boolean on = ((Switch) v).isChecked();
        if (on) {
            dayList.add("Sat");
        }
        else {
            dayList.remove("Sat");
        }
    }
}

