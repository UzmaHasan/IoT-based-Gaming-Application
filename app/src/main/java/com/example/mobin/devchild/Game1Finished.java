package com.example.mobin.devchild;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Game1Finished extends AppCompatActivity {

    TextView txt3;
    public String success, test, dateStr, month, date;
    public ArrayList<String> att;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1_finished);

        txt3 = findViewById(R.id.txt3);
        success = getIntent().getStringExtra("success");
        test = getIntent().getStringExtra("UserId");

        att = new ArrayList<>();
        Date c = Calendar.getInstance().getTime();
        //System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        dateStr = df.format(c);



        if(success.equals("1"))
        {

            txt3.setText("Well Done! You did it!!!");
            month = dateStr.substring(3,6);
            month += " ";
            month += dateStr.substring(0,2);
            date = dateStr;


            //SharedPreferences mSharedPreference1 =   PreferenceManager.getDefaultSharedPreferences(mContext);
            att.clear();
            att = getArrayList("array3");
            if(att == null)
            {
                att = new ArrayList<>();
            }

            //int size = sp.getInt("Status_size", 0);

            //for(int i=0;i<size;i++)
            //{
            //    att.add(sp.getString("Status_" + i, null));
            //}



            att.add(success);
            saveArrayList(att, "array3");
            //editor.putString("name", "Elena");
            //editor.putInt("idName", 12);
            //editor.apply();
            /* sKey is an array */
            //mEdit1.putInt("Status_size", att.size());

            //for(int i=0;i<att.size();i++)
            //{
            //    mEdit1.remove("Status_" + i);
            //    mEdit1.putString("Status_" + i, att.get(i));
            //}

            //mEdit1.commit();

            Attempts attempts = new Attempts(att);
            System.out.println("AJAIRA");
            System.out.print(test + " " + month + "\n");
            FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game3").child("Date").child(month)
                    .setValue(attempts).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Game1Finished.this, "Saved for Game 3", Toast.LENGTH_SHORT).show();

                    }
                }
            });





        }
        else if(success.equals("0"))
        {
            txt3.setText("Too bad! You had an accident :(");

            month = dateStr.substring(3,6);
            month += " ";
            month += dateStr.substring(0,2);
            date = dateStr;

            att.clear();
            att = getArrayList("array3");

            if(att == null)
            {
                att = new ArrayList<>();
            }
            //int size = sp.getInt("Status_size", 0);

            //for(int i=0;i<size;i++)
            //{
            //    att.add(sp.getString("Status_" + i, null));
            //}



            att.add(success);
            saveArrayList(att, "array3");
            //editor.putString("name", "Elena");
            //editor.putInt("idName", 12);
            //editor.apply();
            /* sKey is an array */
            //mEdit1.putInt("Status_size", att.size());

            //for(int i=0;i<att.size();i++)
            //{
            //    mEdit1.remove("Status_" + i);
            //    mEdit1.putString("Status_" + i, att.get(i));
            //}

            //mEdit1.commit();

            Attempts attempts = new Attempts(att);

            System.out.println("-----------------> "+ month );
            System.out.println("<-------------" + test);
            FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game3").child("Date").child(month)
                    .setValue(attempts).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Game1Finished.this, "Saved for game 3", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }


    }

    /**
     *     Save and get ArrayList in SharedPreference
     */

    public void saveArrayList(ArrayList<String> list, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }




}
