package cs.ualberta.ca.aabels_habittracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Angus on 10/1/2016.
 */
public class HabitListManager {
    static final String prefile = "HabitList";
    static final String hlKey = "habitList";

    Context context;

    public HabitListManager(Context context) {
        this.context = context;
    }

    public HabitList loadHabitList() throws IOException, ClassNotFoundException {
        SharedPreferences settings = context.getSharedPreferences(prefile, Context.MODE_PRIVATE);
        String habitListData = settings.getString(hlKey, "");
        if (habitListData.equals("")) {
            return new HabitList();
        }
            else {
                return habitListFromString(habitListData);
            }
        }

    private HabitList habitListFromString(String habitListData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(habitListData.getBytes());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (HabitList) oi.readObject();
    }
    private String habitListToString(HabitList thl) throws IOException{
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(thl);
        oo.close();
        byte habitBytes [] = bo.toByteArray();
        return new String(habitBytes);
    }

    public void saveHabitList(HabitList thl) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(prefile, Context.MODE_PRIVATE);
        Editor editor = settings.edit();
        editor.putString(hlKey, habitListToString(thl));
        editor.commit();

    }



}
