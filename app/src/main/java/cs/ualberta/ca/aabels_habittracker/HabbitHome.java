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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class HabbitHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habbit_home);
        ListView listView = (ListView) findViewById(R.id.habitListView);
        Collection<Habit> habits = HabitListController.getHabitList().getHabits();
        final ArrayList list = new ArrayList<Habit>(habits);
        final ArrayAdapter<Habit> habitAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(habitAdapter);

        //Added a Habit Change observer
        // need to implement a way to remove the habit listener when we clean up
        HabitListController.getHabitList().addHabitListener(new HabitListener() {
            @Override
            public void update() {
                list.clear();
                Collection<Habit> habits = HabitListController.getHabitList().getHabits();
                list.addAll(habits);
                habitAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(HabbitHome.this, "Deleting " + list.get(i).toString(), Toast.LENGTH_SHORT).show();
                Habit habit = (Habit) list.get(i);
                HabitListController.getHabitList().deleteHabit(habit);
                habitAdapter.notifyDataSetChanged();
                return false;
            }
        });

        }

//        //This will be for individual item history
//        // item history will have a button for completing and will have most recent updated date and days set
//        //still need to impliment saveing/loading either from file using gson



//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(HabbitHome.this, "History of " + list.get(i).toString(), Toast.LENGTH_SHORT).show();
//                Habit habit = (Habit) list.get(i);
//            }
//        });

    public void addAHabit(View v) {

//        HabitListController ht = new HabitListController();
        Button addButton = (Button)findViewById(R.id.Add_Habit_Button);
        Intent intent = new Intent(getApplicationContext(),Add_Habbit.class);startActivity(intent);
    }
}
