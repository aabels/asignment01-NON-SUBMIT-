package cs.ualberta.ca.aabels_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HabbitHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habbit_home);

        Button addButton = (Button)findViewById(R.id.Add_Habit_Button);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),Add_Habbit.class);
                startActivity(intent);
            }
        });


    }
}
