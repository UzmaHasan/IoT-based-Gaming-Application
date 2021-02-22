package com.example.mobin.devchild;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Gameanim32 extends AppCompatActivity {

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

    private String success = "5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameanim32);

        timer = new Timer();


        ivSeq1 = findViewById(R.id.idWea1);
        ivSeq2 = findViewById(R.id.idWea2);
        ivSeq3 = findViewById(R.id.idWea3);
        ivSeq4 = findViewById(R.id.idWea4);
        ivSeq5 = findViewById(R.id.idWea5);
        ivSeq6 = findViewById(R.id.idWea6);


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
