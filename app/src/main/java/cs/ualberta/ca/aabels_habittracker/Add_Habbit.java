package cs.ualberta.ca.aabels_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Habbit extends AppCompatActivity {

    private EditText habitText;
    HabitList habitList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
        habitList = new HabitList();
        Button addButton = (Button)findViewById(R.id.createHabbitButton);
        if (addButton != null) {
            addButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(),HabbitHome.class);
                    habitText = (EditText) findViewById(R.id.createHabitView);
                    String text = habitText.getText().toString();
                    Habit habit = new Habit(text);
                    habitList.addHabit(habit);
                    startActivity(intent);
                }
            });
        }
    }
}
