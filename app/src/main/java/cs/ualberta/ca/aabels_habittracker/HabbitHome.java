/*
{ HabitTracker is a easy way to Display all important tasks, duties, or hobbies that you want to do}
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
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;

public class HabbitHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habbit_home);

        //Initializes habit manager to save/load the habit list
        HabitListManager.initHabitManager(this.getApplicationContext());


        final ListView listView = (ListView) findViewById(R.id.habitListView);
        //Collection of habits is grabed by the HabitListController to populate
        //the habit Array Adapter inside the habitListView
        Collection<Habit> habits = HabitListController.getHabitList().getHabits();
        final ArrayList list = new ArrayList<Habit>(habits);
        final ArrayAdapter<Habit> habitAdapter = new ArrayAdapter<Habit>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(habitAdapter);

        //Added a Habit Change observer to tell when the list needs to be updated
        HabitListController.getHabitList().addHabitListener(new HabitListener() {
            @Override
            public void update() {
                list.clear();
                Collection<Habit> habits = HabitListController.getHabitList().getHabits();
                list.addAll(habits);
                habitAdapter.notifyDataSetChanged();
            }
        });

        //Long click Deletes the the habit object from the app and then the adapter is updated
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
    //This will be for individual item history
    // item history will have a button for completing and will have most recent updated date and days set
    public void historyLog (View v) {
        Intent intent = new Intent (HabbitHome.this,HabitHistory.class);
        startActivity(intent);
    }
    //Add habit view page
    public void addAHabit(View v) {
        Intent intent = new Intent(HabbitHome.this,Add_Habbit.class);
        startActivity(intent);
    }
}
