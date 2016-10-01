/*
{one line to give the program's name and a brief idea of what it does.}
        Copyright (C) {2016}  {Angus Abels}

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.
*/
package cs.ualberta.ca.aabels_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HabbitHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habbit_home);
    }

    public void addAHabit(View v) {
        Toast.makeText(this, "Adding a Habit", Toast.LENGTH_SHORT).show();
        HabitListController ht = new HabitListController();
        Button addButton = (Button)findViewById(R.id.Add_Habit_Button);
        Intent intent = new Intent(getApplicationContext(),Add_Habbit.class);startActivity(intent);
    }

//    public void chooseAHabit(View v) {
//        Toast.makeText(this, "Added a Habit", Toast.LENGTH_SHORT).show();
//    }
}
