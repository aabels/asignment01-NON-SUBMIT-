package cs.ualberta.ca.aabels_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Add_Habbit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        Button addButton = (Button)findViewById(R.id.createHabbitButton);
        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),HabbitHome.class);
                startActivity(intent);
            }
        });
    }
}
