package com.example.mobin.devchild;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.example.mobin.devchild.game2.GameView2;

import java.util.Timer;
import java.util.TimerTask;

public class Gameanim2 extends AppCompatActivity {

    public static String test2;
    private String arduinoData="";
    GameView2 gameView2;
    private Handler handler = new Handler();
    private final static long TIMER_INTERVAL = 30;
    public static long prevMilis;
    public static long curMilis;

    public String test;
    public static int activityPaltao = 0;
    public static String success = "5";



    public static String cardTag="xx";

    public String knock="x";
    public static String tag="f1c60a1e";

    public ImageView collageABC, collageCat, collageMango, collageChair;

    private int canvasHeight;
    private int canvasWidth;

    public Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameanim2);

        timer = new Timer();


        collageABC = findViewById(R.id.collageABC);
        collageCat = findViewById(R.id.collageCat);
        collageChair = findViewById(R.id.collageChair);
        collageMango = findViewById(R.id.collageMango);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        canvasHeight = displayMetrics.heightPixels;
        canvasWidth = displayMetrics.widthPixels;

        System.out.println("canvas---->"+canvasWidth);

        collageMango.setX(canvasWidth+10);
        collageCat.setX(canvasWidth+10);
        collageChair.setX(canvasWidth+10);
        collageABC.setX(canvasWidth+10);



        test=getIntent().getStringExtra("UserId");
        success = "5";
        test2=test;

        activityPaltao = 0;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        runGame();
                    }
                });


            }
        }, 0, TIMER_INTERVAL);

    }


    @Override
    protected void onRestart() {
        Log.d("restart", "restart e dukse");
        super.onRestart();
    }

    public void runGame()
    {

        setCardAndKnock();

        Log.d("Run", knock+"");

        if(cardTag.equals("f1c60a1e"))
        {
            collageABC.setX(0);
            collageMango.setX(canvasWidth+10);
            collageCat.setX(canvasWidth+10);
            collageChair.setX(canvasWidth+10);

            if(knock.equals("2"))
            {

                Log.d("GameView2", "Card paise");
                activityPaltao = 1;
                success = "1";
                Intent i = new Intent(Gameanim2.this, Animation.class);
                i.putExtra("UserId",test2);
                i.putExtra("success",success);
                i.putExtra("cardTag",cardTag);
                Log.d("AGEY",cardTag);
                if(timer != null)
                {
                    timer.cancel();
                    timer = null;
                }

                startActivity(i);
            }
            else if(knock.equals("0") || knock.equals("1") || knock.equals("3"))
            {

                activityPaltao = 1;
                success = "0";
                Intent i = new Intent(Gameanim2.this, Animation.class);
                i.putExtra("UserId",test2);
                i.putExtra("success",success);
                i.putExtra("cardTag",cardTag);

                if(timer != null)
                {
                    timer.cancel();
                    timer = null;

                }

                startActivity(i);
            }

        }

        else if(cardTag.equals("e1cb07d5"))
        {
            collageMango.setX(canvasWidth+10);
            collageCat.setX(canvasWidth+10);
            collageChair.setX(0);
            collageABC.setX(canvasWidth+10);


            if(knock.equals("3"))
            {

                Log.d("GameView2", "Card paise");
                activityPaltao = 1;
                success = "1";

                if(timer != null)
                {
                    timer.cancel();
                    timer = null;

                }

                Intent i = new Intent(Gameanim2.this, Animation.class);
                i.putExtra("UserId", test2);
                i.putExtra("success", success);
                i.putExtra("cardTag",cardTag);
                startActivity(i);
            }

            else if(knock.equals("0") || knock.equals("2") || knock.equals("1"))
            {
                Log.d("ELSE_IF","wrong ans paise");
                success = "0";

                if(timer != null)
                {
                    timer.cancel();
                    timer = null;

                }

                Intent i = new Intent(Gameanim2.this, Animation.class);
                i.putExtra("UserId", test2);
                i.putExtra("success", success);
                i.putExtra("cardTag",cardTag);
                startActivity(i);
            }


        }


        else if(cardTag.equals("71e74cd5"))
        {
            collageMango.setX(canvasWidth+10);
            collageCat.setX(0);
            collageChair.setX(canvasWidth+10);
            collageABC.setX(canvasWidth+10);


            if(knock.equals("0"))
            {

                Log.d("GameView2", "Card paise");
                activityPaltao = 1;
                success = "1";

                if(timer != null)
                {
                    timer.cancel();
                    timer = null;

                }

                Intent i = new Intent(Gameanim2.this, Animation.class);
                i.putExtra("UserId", test2);
                i.putExtra("success", success);
                i.putExtra("cardTag",cardTag);
                startActivity(i);
            }

            else if(knock.equals("3") || knock.equals("2") || knock.equals("1"))
            {
                Log.d("ELSE_IF","wrong ans paise");
                success = "0";

                if(timer != null)
                {
                    timer.cancel();
                    timer = null;

                }

                Intent i = new Intent(Gameanim2.this, Animation.class);
                i.putExtra("UserId", test2);
                i.putExtra("success", success);
                i.putExtra("cardTag",cardTag);
                startActivity(i);
            }


        }

        else if(cardTag.equals("d3ee611a"))
        {
            collageMango.setX(0);
            collageCat.setX(canvasWidth+10);
            collageChair.setX(canvasWidth+10);
            collageABC.setX(canvasWidth+10);


            if(knock.equals("1"))
            {

                Log.d("GameView2", "Card paise");
                activityPaltao = 1;
                success = "1";

                if(timer != null)
                {
                    timer.cancel();
                    timer = null;

                }

                Intent i = new Intent(Gameanim2.this, Animation.class);
                i.putExtra("UserId", test2);
                i.putExtra("success", success);
                i.putExtra("cardTag",cardTag);
                startActivity(i);
            }

            else if(knock.equals("0") || knock.equals("2") || knock.equals("3"))
            {
                Log.d("ELSE_IF","wrong ans paise");
                success = "0";

                if(timer != null)
                {
                    timer.cancel();
                    timer = null;

                }

                Intent i = new Intent(Gameanim2.this, Animation.class);
                i.putExtra("UserId", test2);
                i.putExtra("success", success);
                i.putExtra("cardTag",cardTag);
                startActivity(i);
            }


        }


    }



    private void setCardAndKnock() {

        tag = BluetoothHandle.value;

        System.out.println(tag);


        if(tag.length()>=8)
        {
            cardTag = tag.substring(0, 8);
        }

        if(tag.length()>=10){
            knock = tag.substring(9,10);
            //System.out.println("--->"+knock);
            Log.d("press", "--->"+knock+"<---");
        }


        //Log.d("press", knock+"val");

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
