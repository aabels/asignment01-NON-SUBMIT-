package cs.ualberta.ca.aabels_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class Add_Habbit extends AppCompatActivity {

//    private EditText habitText;
//    HabitList habitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
        HabitListManager.initHabitManager(this.getApplicationContext());
    }

    public void creatHabitAction(View v) {
        Toast.makeText(this, "Creating Habit", Toast.LENGTH_SHORT).show();
//        habitList = new HabitList();
        HabitListController ht = new HabitListController();

        // somehow get the value of the switch the got turned on
//        Switch sunDay = (Switch) findViewById(R.id.SundaySwitch);
//        Toast.makeText(this, "Added Habit to: Sunday", Toast.LENGTH_SHORT).show();
//        ht.addDay(new Habit(sunDay.isChecked()));

        EditText habitText = (EditText) findViewById(R.id.createHabitView);
        ht.addHabit(new Habit(habitText.getText().toString()));
        finish();
    }
}
//        Button addButton = (Button)findViewById(R.id.createHabbitButton);
//        if (addButton != null) {
//            addButton.setOnClickListener(new View.OnClickListener() {
//
//                public void onClick(View v){
//                    Intent intent = new Intent(getApplicationContext(),HabbitHome.class);
//                    habitText = (EditText) findViewById(R.id.createHabitView);
//                    String text = habitText.getText().toString();
//                    Habit habit = new Habit(text);
//                    habitList.addHabit(habit);
//                    finish();
//                    startActivity(intent);
//                }
//            });
//        }
//    }
//}
