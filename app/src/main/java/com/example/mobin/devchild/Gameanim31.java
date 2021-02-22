package com.example.mobin.devchild;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.RectF;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;




public class Gameanim31 extends AppCompatActivity {

    private String cardTag="xx";
    private char cardNumber='y';


    public String[] Tags = {"11","22","33","44","55","66"};

    private int canvasHeight;
    private int canvasWidth;

    private Handler handler = new Handler();
    private final static long TIMER_INTERVAL = 30;
    public static long prevMilis;
    public static long curMilis;

    public ImageView ivSeq1, ivSeq2, ivSeq3, ivSeq4, ivSeq5, ivSeq6;

    public Timer timer;
    public static String dateStr = "";
    public static String gameNo;
    public static String success = "5";
    public String month, date;
    public ArrayList<String> att;

    //private String success = "5";
    public String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameanim31);


        timer = new Timer();
        test=getIntent().getStringExtra("UserId");

        ivSeq1 = findViewById(R.id.idSeq1);
        ivSeq2 = findViewById(R.id.idSeq2);
        ivSeq3 = findViewById(R.id.idSeq3);
        ivSeq4 = findViewById(R.id.idSeq4);
        ivSeq5 = findViewById(R.id.idSeq5);
        ivSeq6 = findViewById(R.id.idSeq6);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        canvasHeight = displayMetrics.heightPixels;
        canvasWidth = displayMetrics.widthPixels;


        ivSeq1.setX(canvasWidth+10);
        ivSeq2.setX(canvasWidth+10);
        ivSeq3.setX(canvasWidth+10);
        ivSeq4.setX(canvasWidth+10);
        ivSeq5.setX(canvasWidth+10);
        ivSeq6.setX(canvasWidth+10);


        System.out.println("canvas---->"+canvasWidth);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //gameView2.invalidate();
                        runGame();
                    }
                });


            }
        }, 0, TIMER_INTERVAL);

    }




    public void runGame()
    {
        setCardAndKnock();


        if(cardNumber == '0')
        {
            cardNumber='4';
            Tags[4] = cardTag;

        }
        else if(cardNumber == '1')
        {
            cardNumber='1';
            Tags[1] = cardTag;

        }
        else if(cardNumber == '2')
        {
            cardNumber='3';
            Tags[3] = cardTag;

        }
        else if(cardNumber == '3')
        {
            cardNumber='2';
            Tags[2] = cardTag;

        }
        else if(cardNumber == '4')
        {
            cardNumber='5';
            Tags[5] = cardTag;

        }
        else if(cardNumber == '5')
        {
            cardNumber='0';
            Tags[0] = cardTag;

        }








        if(Tags[0].equals("1bdc550d"))
        {

            ivSeq1.setX(0);
            ivSeq1.setY(0);
            //canvas.drawBitmap(p101, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[0].equals("8ba6610a"))
        {

            ivSeq2.setX(0);
            ivSeq2.setY(0);
            //canvas.drawBitmap(p102, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[0].equals("e9310364"))
        {

            ivSeq3.setX(0);
            ivSeq3.setY(0);
            //canvas.drawBitmap(p103, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[0].equals("5b61cb0c"))
        {

            ivSeq4.setX(0);
            ivSeq4.setY(0);
            //canvas.drawBitmap(p104, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[0].equals("6b3c5a0a"))
        {

            ivSeq5.setX(0);
            ivSeq5.setY(0);
            //canvas.drawBitmap(p201, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[0].equals("8b31bf0c"))
        {

            ivSeq6.setX(0);
            ivSeq6.setY(0);
            //canvas.drawBitmap(p202, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }







        //////////////////// TAG  1   ////////////////


        if(Tags[1].equals("1bdc550d"))
        {

            ivSeq1.setX(canvasWidth/3);
            ivSeq1.setY(0);
            //canvas.drawBitmap(p101, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[1].equals("8ba6610a"))
        {

            ivSeq2.setX(canvasWidth/3);
            ivSeq2.setY(0);
            //canvas.drawBitmap(p102, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[1].equals("e9310364"))
        {

            ivSeq3.setX(canvasWidth/3);
            ivSeq3.setY(0);
            //canvas.drawBitmap(p103, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[1].equals("5b61cb0c"))
        {

            ivSeq4.setX(canvasWidth/3);
            ivSeq4.setY(0);
            //canvas.drawBitmap(p104, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[1].equals("6b3c5a0a"))
        {

            ivSeq5.setX(canvasWidth/3);
            ivSeq5.setY(0);
            //canvas.drawBitmap(p201, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[1].equals("8b31bf0c"))
        {

            ivSeq6.setX(canvasWidth/3);
            ivSeq6.setY(0);
            //canvas.drawBitmap(p202, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }




        
        

        //////////////////// TAG  2   ////////////////


        if(Tags[2].equals("1bdc550d"))
        {

            ivSeq1.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq1.setY(0);
            //canvas.drawBitmap(p101, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[2].equals("8ba6610a"))
        {

            ivSeq2.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq2.setY(0);
            //canvas.drawBitmap(p102, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[2].equals("e9310364"))
        {

            ivSeq3.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq3.setY(0);
            //canvas.drawBitmap(p103, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[2].equals("5b61cb0c"))
        {

            ivSeq4.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq4.setY(0);
            //canvas.drawBitmap(p104, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[2].equals("6b3c5a0a"))
        {

            ivSeq5.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq5.setY(0);
            //canvas.drawBitmap(p201, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[2].equals("8b31bf0c"))
        {

            ivSeq6.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq6.setY(0);
            //canvas.drawBitmap(p202, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }







        //////////////////// TAG  3   ////////////////


        if(Tags[3].equals("1bdc550d"))
        {

            ivSeq1.setX(0);
            ivSeq1.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p101, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[3].equals("8ba6610a"))
        {

            ivSeq2.setX(0);
            ivSeq2.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p102, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[3].equals("e9310364"))
        {

            ivSeq3.setX(0);
            ivSeq3.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p103, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[3].equals("5b61cb0c"))
        {

            ivSeq4.setX(0);
            ivSeq4.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p104, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[3].equals("6b3c5a0a"))
        {

            ivSeq5.setX(0);
            ivSeq5.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p201, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[3].equals("8b31bf0c"))
        {

            ivSeq6.setX(0);
            ivSeq6.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p202, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }






        //////////////////// TAG  4   ////////////////


        if(Tags[4].equals("1bdc550d"))
        {

            ivSeq1.setX(canvasWidth/3);
            ivSeq1.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p101, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[4].equals("8ba6610a"))
        {

            ivSeq2.setX(canvasWidth/3);
            ivSeq2.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p102, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[4].equals("e9310364"))
        {

            ivSeq3.setX(canvasWidth/3);
            ivSeq3.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p103, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[4].equals("5b61cb0c"))
        {

            ivSeq4.setX(canvasWidth/3);
            ivSeq4.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p104, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[4].equals("6b3c5a0a"))
        {

            ivSeq5.setX(canvasWidth/3);
            ivSeq5.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p201, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[4].equals("8b31bf0c"))
        {

            ivSeq6.setX(canvasWidth/3);
            ivSeq6.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p202, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }




        //////////////////// TAG  5   ////////////////


        if(Tags[5].equals("1bdc550d"))
        {

            ivSeq1.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq1.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p101, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[5].equals("8ba6610a"))
        {

            ivSeq2.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq2.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p102, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[5].equals("e9310364"))
        {

            ivSeq3.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq3.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p103, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[5].equals("5b61cb0c"))
        {

            ivSeq4.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq4.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p104, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[5].equals("6b3c5a0a"))
        {

            ivSeq5.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq5.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p201, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }
        if(Tags[5].equals("8b31bf0c"))
        {

            ivSeq6.setX(canvasWidth/3 + canvasWidth/3);
            ivSeq6.setY(canvasHeight/2 - 100);
            //canvas.drawBitmap(p202, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
        }







        if(Tags[0].equals("11") || Tags[1].equals("22") || Tags[2].equals("33") || Tags[3].equals("44") || Tags[4].equals("55") || Tags[5].equals("66"))
        {
            success = "5";
        }
        else if(Tags[0].equals("1bdc550d") && Tags[1].equals("8ba6610a") && Tags[2].equals("e9310364") && Tags[3].equals("5b61cb0c") && Tags[4].equals("6b3c5a0a") && Tags[5].equals("8b31bf0c")) {
            System.out.println("Milse re Milseeee!!!!!\n\n\n");
            success = "1";

            ///Save in Database
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
                            //Toast.makeText(Gameanim3.this, "Saved for Game 2", Toast.LENGTH_SHORT).show();

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
                  //          Toast.makeText(Gameanim3.this, "Saved for game 2", Toast.LENGTH_SHORT).show();

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





            Intent i = new Intent(getApplicationContext(), PuzzleGameFinished.class);
            if(timer != null)
            {
                timer.cancel();
                timer = null;
            }
            startActivity(i);

            //Toast.makeText(getApplicationContext(), "Correct Sequence. Congrats!!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            success = "0";
        }




    }


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




    private void setCardAndKnock() {

        String tag = BluetoothHandle.value;//static string var in bluetooth handle class
        if(tag == null) return;

        System.out.println(tag);

        //if(tag.length()>0)
        //{
//            System.out.println("yes");
        //   cardTag = tag.substring(0, 8);
        //   System.out.println("in-->"+cardTag);
        //}
        //System.out.println("out-->"+cardTag);

        if(tag.length()>=8)
        {
            cardTag = tag.substring(0, 8);
        }
        cardNumber = tag.charAt(9);


        System.out.println("Tag is-->"+cardTag);

    }

    @Override
    public void onBackPressed() {

        if(timer != null)
        {
            timer.cancel();
            timer = null;
        }

        super.onBackPressed();
    }
}
