package com.example.mobin.devchild;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

//import com.example.mobin.devchild.game2.GameView2;
import com.example.mobin.devchild.game3.GameView3;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class Gameanim3 extends AppCompatActivity {
    private String arduinoData="";

    GameView3 gameView3;
    private Handler handler = new Handler();
    private final static long TIMER_INTERVAL = 30;
    public static long prevMilis;
    public static long curMilis;

    public static Timer timer;
    String month;
    String date;
    public ArrayList<String> att;
    String at1="0";
    String at2="1";
    String at3="1";
    int count=1;
    int count2=1;
    public static String dateStr = "";
    public static String gameNo;
    public static String success = "5";
    public String test;


    //public static final String MY_PREFS_NAME = "MyPrefsFile";
//    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

    //SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
   // SharedPreferences.Editor mEdit1 = sp.edit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        success = "5";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameanim3);



        att = new ArrayList<>();
        test=getIntent().getStringExtra("UserId");


        Date c = Calendar.getInstance().getTime();
        //System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        dateStr = df.format(c);


        gameView3 = new GameView3(this);

        setContentView(gameView3);

       // getActionBar().hide();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {


                        gameView3.invalidate();



                    }
                });

            }
        }, 0, TIMER_INTERVAL);


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

    @Override
    public void onBackPressed() {




        /////////////////////////////////////


/*        if (timer != null) {
            timer.cancel();
        }*/

        if(success.equals("1"))
        {
            //att.clear();
            month = dateStr.substring(3,6);
            month += " ";
            month += dateStr.substring(0,2);
            date = dateStr;


                //SharedPreferences mSharedPreference1 =   PreferenceManager.getDefaultSharedPreferences(mContext);
                att.clear();
                att = getArrayList("array");
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
            saveArrayList(att, "array");
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
            FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game2").child("Date").child(month)
                    .setValue(attempts).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Gameanim3.this, "Saved for Game 2", Toast.LENGTH_SHORT).show();

                    }
                }
            });



        }
        else if(success.equals("0"))
        {
            month = dateStr.substring(3,6);
            month += " ";
            month += dateStr.substring(0,2);
            date = dateStr;

            att.clear();
            att = getArrayList("array");

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
            saveArrayList(att, "array");
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
            FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game2").child("Date").child(month)
                    .setValue(attempts).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Gameanim3.this, "Saved for game 2", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
        else
        {
            Log.d("g3", "error");

            System.out.println("do nothing");
            //do nothing
        }


        ////////////////////////////////////






        super.onBackPressed();
    }
}
