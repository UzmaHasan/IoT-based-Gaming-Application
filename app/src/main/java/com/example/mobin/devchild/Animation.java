package com.example.mobin.devchild;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobin.devchild.game2.GameView2;
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

import pl.droidsonroids.gif.GifImageView;

public class Animation extends AppCompatActivity {


    public String test;
    public String success;

    public String cardTag="xx";

    public String knock="x";
    public String tag="f1c60a1e";
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
    public int songSelect=0;

    public GifImageView gifDog, gifGrape, gifA, gifUmbrella, gifWrong;
    private int canvasHeight;
    private int canvasWeight;
    MediaPlayer song, song2;
    TextView txtAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        gifDog = findViewById(R.id.gifDog);
        gifA = findViewById(R.id.gifA);
        gifGrape = findViewById(R.id.gifGrape);
        gifUmbrella = findViewById(R.id.gifUmbrella);
        gifWrong = findViewById(R.id.gifWrong);

        txtAns = findViewById(R.id.txtAns);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        canvasHeight = displayMetrics.heightPixels;
        canvasWeight = displayMetrics.widthPixels;

        gifUmbrella.setX(canvasWeight + 10);
        gifDog.setX(canvasWeight + 10);
        gifA.setX(canvasWeight + 10);
        gifGrape.setX(canvasWeight + 10);

        GameView2.knock = "x";
        GameView2.cardTag = "xx";
        GameView2.tag = "f1c60a1e";
        Gameanim2.success = "5";
        test=getIntent().getStringExtra("UserId");
        success = getIntent().getStringExtra("success");
        cardTag = getIntent().getStringExtra("cardTag");

        Log.d("POREY",cardTag);


        att = new ArrayList<>();
        Date c = Calendar.getInstance().getTime();
        //System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        dateStr = df.format(c);

        if(success.equals("1"))
        {

            if(cardTag.equals("f1c60a1e"))
            {
                gifUmbrella.setX(canvasWeight + 10);
                gifDog.setX(canvasWeight + 10);
                gifA.setX(0);
                gifGrape.setX(canvasWeight + 10);
                gifWrong.setX(canvasWeight+10);
            }
            else if(cardTag.equals("e1cb07d5"))
            {
                gifUmbrella.setX(0);
                gifDog.setX(canvasWeight + 10);
                gifA.setX(canvasWeight + 10);
                gifGrape.setX(canvasWeight + 10);
                gifWrong.setX(canvasWeight+10);
            }
            else if(cardTag.equals("71e74cd5"))
            {
                gifUmbrella.setX(canvasWeight + 10);
                gifDog.setX(0);
                gifA.setX(canvasWeight + 10);
                gifGrape.setX(canvasWeight + 10);
                gifWrong.setX(canvasWeight+10);
            }
            else if(cardTag.equals("d3ee611a"))
            {
                gifUmbrella.setX(canvasWeight + 10);
                gifDog.setX(canvasWeight + 10);
                gifA.setX(canvasWeight + 10);
                gifGrape.setX(0);
                gifWrong.setX(canvasWeight+10);
            }

            txtAns.setText("Correct Answer!!!!");
            song=MediaPlayer.create(Animation.this,R.raw.bb);
            song.start();
            songSelect=1;
            //Show correct animation
        }
        else
        {
            //if(cardTag.equals("f1c60a1e"))
            //{
            //    gifUmbrella.setX(canvasWeight + 10);
            //    gifDog.setX(canvasWeight + 10);
            //    gifA.setX(0);
            //    gifGrape.setX(canvasWeight + 10);
            //}
            //else if(cardTag.equals("e1cb07d5"))
            //{
            //    gifUmbrella.setX(0);
            //    gifDog.setX(canvasWeight + 10);
            //    gifA.setX(canvasWeight + 10);
            //    gifGrape.setX(canvasWeight + 10);
            //}
            //else if(cardTag.equals("71e74cd5"))
            //{
            //    gifUmbrella.setX(canvasWeight + 10);
            //    gifDog.setX(0);
            //    gifA.setX(canvasWeight + 10);
            //    gifGrape.setX(canvasWeight + 10);
            //}
            //else if(cardTag.equals("d3ee611a"))
            //{
            //    gifUmbrella.setX(canvasWeight + 10);
            //    gifDog.setX(canvasWeight + 10);
            //    gifA.setX(canvasWeight + 10);
            //    gifGrape.setX(0);
            //}
            gifUmbrella.setX(canvasWeight + 10);
            gifA.setX(canvasWeight+10);
            gifDog.setX(canvasWeight + 10);
            gifWrong.setX(0);
            gifGrape.setX(canvasWeight + 10);
            songSelect=2;
            txtAns.setText("Wrong Answer :(");
            song2=MediaPlayer.create(Animation.this,R.raw.aa);
            song2.start();
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
            att = getArrayList("array1");
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
            saveArrayList(att, "array1");
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
            System.out.println("AJAIRA1");
            System.out.print(test + " " + month + "\n");
            FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game1").child("Date").child(month)
                    .setValue(attempts).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Animation.this, "Saved for Game 1", Toast.LENGTH_SHORT).show();

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
            att = getArrayList("array1");

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
            saveArrayList(att, "array1");
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
            FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game1").child("Date").child(month)
                    .setValue(attempts).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Animation.this, "Saved for Game 1", Toast.LENGTH_SHORT).show();

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



        //Intent i = new Intent(Animation.this, Gameanim2.class);
        //i.putExtra("UserId",test);
        //onDestroy();
        //startActivity(i);

        ////////////////////////////////////

        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(songSelect==1) song.release();
        else if(songSelect==2) song2.release();
    }
}
