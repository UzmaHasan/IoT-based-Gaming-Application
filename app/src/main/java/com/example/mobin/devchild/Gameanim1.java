package com.example.mobin.devchild;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mobin.devchild.game1.GameView;

import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Gameanim1 extends AppCompatActivity {

    private String arduinoData="";


    private int canvasHeight;
    private int canvasWidth;

    private FrameLayout frameLayout;
    private LinearLayout linearLayout;

    private GameView gameview;
    private Handler handler = new Handler();
    private final static long TIMER_INTERVAL = 30;
    public static long prevMilis;
    public static long curMilis;


    public String success = "5";

    private int cartoonX = 2;
    private int cartoonY = 20;

    private int carX = 2;
    private int carY = 320;

    private int car2X = -500;
    private int car2Y = 500;


    Timer timer = new Timer();

    private int carPX;
    private int carPY;

    private int carP2X;
    private int carP2Y;


    public String test;

    private ImageView ivCartoon;
    private ImageView ivRedCar;
    private ImageView ivRedCar2;
    private ImageView ivPinkCar;
    private ImageView ivPinkCar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameanim1);

        test=getIntent().getStringExtra("UserId");

        ivCartoon = findViewById(R.id.idCartoon);
        ivRedCar = findViewById(R.id.idRedCar);
        ivRedCar2 = findViewById(R.id.idRedCar2);

        ivPinkCar = findViewById(R.id.idPinkCar);
        ivPinkCar2 = findViewById(R.id.idPinkCar2);

        frameLayout = findViewById(R.id.frame);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        canvasHeight = displayMetrics.heightPixels;
        canvasWidth = displayMetrics.widthPixels;


        carPX = canvasWidth + 50;
        carPY = 1300;
        carP2X = canvasWidth + 500;
        carP2Y = 1450;


        success = "5";
        System.out.println("canvas---->"+canvasWidth);

        ivCartoon.setX(cartoonX);
        ivCartoon.setY(cartoonY);

        ivRedCar.setX(carX);
        ivRedCar.setY(carY);

        ivRedCar2.setX(car2X);
        ivRedCar2.setY(car2Y);




        ivPinkCar.setX(carPX);
        ivPinkCar.setY(carPY);

        ivPinkCar2.setX(carP2X);
        ivPinkCar2.setY(carP2Y);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //gameview.invalidate();
                        runGame();
                    }
                });

            }
        }, 0, TIMER_INTERVAL);


    }


    public void runGame()
    {
        getXYvalue();

        ivCartoon.setX(cartoonX);
        ivCartoon.setY(cartoonY);

        /////// red car
        ivRedCar.setX(carX);
        ivRedCar.setY(carY);

        ivRedCar2.setX(car2X);
        ivRedCar2.setY(car2Y);

        //////pink car
        ivPinkCar.setX(carPX);
        ivPinkCar.setY(carPY);

        ivPinkCar2.setX(carP2X);
        ivPinkCar2.setY(carP2Y);



        boolean isCollision = checkCollision();

        if(isCollision){
            Log.d("col", "hoise");
            System.out.println("----> Accident!!!");

            if(timer!=null)
            {
                timer.cancel();
                timer = null;
            }

            success = "0";
            ////// success 0 kore put extra jabe
            Intent i = new Intent(getApplicationContext(), Game1Finished.class);
            i.putExtra("success",success);
            i.putExtra("UserId",test);

            startActivity(i);

        }

        boolean isGoalFound = checkGoalFound();
        if(isGoalFound){
            if(timer!=null)
            {
                timer.cancel();
                timer = null;
            }
            success = "1";
            ////// success 1 kore put extra jabe
            Intent i = new Intent(getApplicationContext(), Game1Finished.class);
            i.putExtra("success",success);
            i.putExtra("UserId",test);
            startActivity(i);

        }

    }

    private boolean checkGoalFound() {

        int sX, sY;
        sX = (int)ivCartoon.getX() + 30;
        sY = (int)ivCartoon.getY() + 200;

        int goalY = canvasHeight - 320;

        if(sY > goalY) return true;


        return false;

    }

    private boolean checkCollision() {

        int sX, sY;
        sX = (int)ivCartoon.getX();
        sY = (int)ivCartoon.getY();


        if(sX > (int)ivRedCar.getX() && sX < ((int)ivRedCar.getX() + 80) && sY > (int)ivRedCar.getY() && sY < (int)ivRedCar.getY() + 40 ) return true;
        if(sX > (int)ivRedCar2.getX() && sX < ((int)ivRedCar2.getX() + 80) && sY > (int)ivRedCar2.getY() && sY < (int)ivRedCar2.getY() + 40 ) return true;
        if(sX > (int)ivPinkCar.getX() && sX < ((int)ivPinkCar.getX() + 80) && sY > (int)ivPinkCar.getY() && sY < (int)ivPinkCar.getY() + 40 ) return true;
        if(sX > (int)ivPinkCar2.getX() && sX < ((int)ivPinkCar2.getX() + 80) && sY > (int)ivPinkCar2.getY() && sY < (int)ivPinkCar2.getY() + 40 ) return true;


        sX = (int)ivCartoon.getX() + 15;
        sY = (int)ivCartoon.getY();

        if(sX > (int)ivRedCar.getX() && sX < ((int)ivRedCar.getX() + 80) && sY > (int)ivRedCar.getY() && sY < (int)ivRedCar.getY() + 40 ) return true;
        if(sX > (int)ivRedCar2.getX() && sX < ((int)ivRedCar2.getX() + 80) && sY > (int)ivRedCar2.getY() && sY < (int)ivRedCar2.getY() + 40 ) return true;
        if(sX > (int)ivPinkCar.getX() && sX < ((int)ivPinkCar.getX() + 80) && sY > (int)ivPinkCar.getY() && sY < (int)ivPinkCar.getY() + 40 ) return true;
        if(sX > (int)ivPinkCar2.getX() && sX < ((int)ivPinkCar2.getX() + 80) && sY > (int)ivPinkCar2.getY() && sY < (int)ivPinkCar2.getY() + 40 ) return true;


        sX = (int)ivCartoon.getX();
        sY = (int)ivCartoon.getY() + 30;
        
        if(sX > (int)ivRedCar.getX() && sX < ((int)ivRedCar.getX() + 80) && sY > (int)ivRedCar.getY() && sY < (int)ivRedCar.getY() + 40 ) return true;
        if(sX > (int)ivRedCar2.getX() && sX < ((int)ivRedCar2.getX() + 80) && sY > (int)ivRedCar2.getY() && sY < (int)ivRedCar2.getY() + 40 ) return true;
        if(sX > (int)ivPinkCar.getX() && sX < ((int)ivPinkCar.getX() + 80) && sY > (int)ivPinkCar.getY() && sY < (int)ivPinkCar.getY() + 40 ) return true;
        if(sX > (int)ivPinkCar2.getX() && sX < ((int)ivPinkCar2.getX() + 80) && sY > (int)ivPinkCar2.getY() && sY < (int)ivPinkCar2.getY() + 40 ) return true;


        sX = (int)ivCartoon.getX() + 15;
        sY = (int)ivCartoon.getY() + 30;

        if(sX > (int)ivRedCar.getX() && sX < ((int)ivRedCar.getX() + 80) && sY > (int)ivRedCar.getY() && sY < (int)ivRedCar.getY() + 40 ) return true;
        if(sX > (int)ivRedCar2.getX() && sX < ((int)ivRedCar2.getX() + 80) && sY > (int)ivRedCar2.getY() && sY < (int)ivRedCar2.getY() + 40 ) return true;
        if(sX > (int)ivPinkCar.getX() && sX < ((int)ivPinkCar.getX() + 80) && sY > (int)ivPinkCar.getY() && sY < (int)ivPinkCar.getY() + 40 ) return true;
        if(sX > (int)ivPinkCar2.getX() && sX < ((int)ivPinkCar2.getX() + 80) && sY > (int)ivPinkCar2.getY() && sY < (int)ivPinkCar2.getY() + 40 ) return true;



        return false;

    }


    private void getXYvalue()
    {

        String calculatingString = BluetoothHandle.value;

        String valueX = calculatingString.substring(0, 1);
        String valueY = calculatingString.substring(2, 3);

        System.out.println("x is -->"+valueX);
        System.out.println("y is -->"+valueY);


        if((valueX.equals("0") || valueX.equals("1") || valueX.equals("2") ) && (valueY.equals("5") || valueY.equals("6")|| valueY.equals("7")))
        {
            System.out.println(valueX + "<---->" + valueY);

            int addingValue = 8;

         //   if(ivCartoon.getX() < 0) addingValue = 0;
         //   if(ivCartoon.getY() < 0) addingValue = 0;

         //   if(ivCartoon.getX() > canvasWidth) addingValue = -10;
         //   if(ivCartoon.getY() > canvasHeight) addingValue = -10;

            if(Integer.parseInt(valueX) == 2) cartoonX += addingValue;
            if(Integer.parseInt(valueX) == 1 ) cartoonX -= addingValue;

            if(Integer.parseInt(valueY) == 7) cartoonY += addingValue;
            if(Integer.parseInt(valueY) == 6) cartoonY -= addingValue;
        }

        carX += 5;
        car2X += 5;

        carPX -= 5;
        carP2X -= 5;


        if(carX >= canvasWidth) carX = -100;
        if(car2X >= canvasWidth) car2X = -100;

        if(carPX <= 0 ) carPX =  canvasWidth + 100;
        if(carP2X <= 0 ) carP2X =  canvasWidth + 100;

    }



}

