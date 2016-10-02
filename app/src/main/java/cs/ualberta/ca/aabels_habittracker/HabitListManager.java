package cs.ualberta.ca.aabels_habittracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;

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

    static private HabitListManager habitListManager = null;

    public static void initHabitManager(Context context) {
        if (habitListManager == null){
            if (context == null) {
                throw new RuntimeException("missing context for HabitListManager");
            }
            habitListManager = new HabitListManager(context);
        }
    }

    public static HabitListManager getHabitManager() {
        if (habitListManager == null) {
            throw new RuntimeException("Did not initialize HabitListManager");
        }
        return habitListManager;
    }


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

    static public HabitList habitListFromString(String habitListData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(habitListData, Base64.DEFAULT));
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (HabitList) oi.readObject();
    }
    static public String habitListToString(HabitList thl) throws IOException{
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(thl);
        oo.close();
        byte habitBytes [] = bo.toByteArray();
        return Base64.encodeToString(habitBytes, Base64.DEFAULT);
    }

    public void saveHabitList(HabitList thl) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(prefile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(hlKey, habitListToString(thl));
        editor.commit();

    }



}
