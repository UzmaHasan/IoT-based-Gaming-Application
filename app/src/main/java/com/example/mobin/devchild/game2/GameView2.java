package com.example.mobin.devchild.game2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mobin.devchild.Animation;
import com.example.mobin.devchild.BluetoothHandle;
import com.example.mobin.devchild.Gameanim2;
import com.example.mobin.devchild.R;

import java.sql.SQLOutput;

public class GameView2 extends View{

    int canvasHeight;
    int canvasWidth;

    public static String cardTag="xx";

    public static String knock="x";
    public static String tag="f1c60a1e";

    Bitmap bg;
    Paint emptyPaint = new Paint();
    Paint p1Paint = new Paint();
    Paint p2Paint = new Paint();

    Bitmap p101, p102, p103, p104;
    Bitmap p201, p202, p203, p204;

    Context mContext;

    //private String cardTag="3exyz";
    private String resultPosition="";

    public GameView2(Context context) {
        super(context);

        mContext = context;

        bg = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

        p101 = BitmapFactory.decodeResource(getResources(), R.drawable.p);
        p102 = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        p103 = BitmapFactory.decodeResource(getResources(), R.drawable.c);
        p104 = BitmapFactory.decodeResource(getResources(), R.drawable.v);

        p201 = BitmapFactory.decodeResource(getResources(), R.drawable.umbrella);
        p202 = BitmapFactory.decodeResource(getResources(), R.drawable.chair);
        p203 = BitmapFactory.decodeResource(getResources(), R.drawable.table);
        p204 = BitmapFactory.decodeResource(getResources(), R.drawable.lamp);

        emptyPaint.setColor(Color.BLACK);
        emptyPaint.setTypeface(Typeface.DEFAULT_BOLD);
        emptyPaint.setTextSize(50);
        emptyPaint.setAntiAlias(true);

        p1Paint.setColor(Color.BLACK);
        p1Paint.setTypeface(Typeface.DEFAULT_BOLD);
        p1Paint.setTextSize(100);
        p1Paint.setAntiAlias(true);

        p2Paint.setColor(Color.BLACK);
        p2Paint.setTypeface(Typeface.DEFAULT_BOLD);
        p2Paint.setTextSize(100);
        p2Paint.setAntiAlias(true);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        canvasHeight = canvas.getHeight();
        canvasWidth = canvas.getWidth();



        System.out.println("Set CArd--->"+knock);
        System.out.println("SET CARD--->"+cardTag);

        setCardAndKnock();

        //canvas.drawBitmap(bg , 0 , 0 , null);

        canvas.drawText("Please set a CARD first", (canvasWidth/4), (canvasHeight/2)-50, emptyPaint );
        //canvas.drawBitmap(bg, null, new RectF(0, 0, canvasWidth/2, canvasHeight/2), null);

        if(cardTag.equals("f1c60a1e"))
        {
            System.out.println("Set CArd2222--->"+knock);
            System.out.println("SET CARD2222--->"+cardTag);

            canvas.drawBitmap(p101, null, new RectF(0, 0, canvasWidth/2, (canvasHeight/2)-200), null);
            canvas.drawBitmap(p102, null, new RectF(canvasWidth/2, 0, canvasWidth, (canvasHeight/2)-200), null);

            canvas.drawBitmap(p103, null, new RectF(0, (canvasHeight/2)-200, canvasWidth/2, canvasHeight-200), null);
            canvas.drawBitmap(p104, null, new RectF(canvasWidth/2, canvasHeight/2, canvasWidth, canvasHeight-200), null);


            if(knock.equals("2"))
            {
                //Gameanim2.timer.cancel();
                //Gameanim2.timer.purge();

                Log.d("GameView2", "Card paise");
                Gameanim2.activityPaltao = 1;

                Gameanim2.success = "1";
                Intent i = new Intent(mContext, Animation.class);
                i.putExtra("UserId",Gameanim2.test2);
                i.putExtra("success", Gameanim2.success);
                mContext.startActivity(i);
            }
            else if(knock.equals("0") || knock.equals("1") || knock.equals("3"))
            {

           //     Gameanim2.timer.cancel();
           //     Gameanim2.timer.purge();

                Log.d("ELSE_IF1","wrong ans paise1");
                Gameanim2.success = "0";
                Intent i = new Intent(mContext, Animation.class);
                i.putExtra("UserId",Gameanim2.test2);
                i.putExtra("success", Gameanim2.success);
                mContext.startActivity(i);
            }

        }
        else if(cardTag.equals("e1cb07d5"))
        {
            canvas.drawBitmap(p201, null, new RectF(0, 0, canvasWidth/2, (canvasHeight/2)-200), null);
            canvas.drawBitmap(p202, null, new RectF(canvasWidth/2, 0, canvasWidth, (canvasHeight/2)-200), null);

            canvas.drawBitmap(p203, null, new RectF(0, (canvasHeight/2)-200, canvasWidth/2, canvasHeight-200), null);
            canvas.drawBitmap(p204, null, new RectF(canvasWidth/2, canvasHeight/2, canvasWidth, canvasHeight-200), null);

            canvas.drawText("- Find Chair -", (canvasWidth/4), (canvasHeight)-100, p1Paint );

            if(knock.equals("1"))
            {


                Log.d("GameView2", "Card paise");
                Gameanim2.activityPaltao = 1;

                Gameanim2.success = "1";

            //    Gameanim2.timer.cancel();
            //    Gameanim2.timer.purge();

                Intent i = new Intent(mContext, Animation.class);
                i.putExtra("UserId",Gameanim2.test2);
                i.putExtra("success", Gameanim2.success);
                mContext.startActivity(i);
            }

            else if(knock.equals("0") || knock.equals("2") || knock.equals("3"))
            {
                Log.d("ELSE_IF","wrong ans paise");
                Gameanim2.success = "0";
            //    Gameanim2.timer.cancel();
            //    Gameanim2.timer.purge();

                Intent i = new Intent(mContext, Animation.class);
                i.putExtra("UserId",Gameanim2.test2);
                i.putExtra("success", Gameanim2.success);
                mContext.startActivity(i);
            }


        }

    }

    private void setCardAndKnock() {

        tag = BluetoothHandle.value;

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

        if(tag.length()>=10){
            knock = tag.substring(9,10);
            //System.out.println("--->"+knock);
            Log.d("press", "2 press hoise");
        }
        System.out.println("--->"+knock);
        System.out.println("Tag is-->"+cardTag);

    }
}
