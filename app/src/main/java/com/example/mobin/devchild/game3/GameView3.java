package com.example.mobin.devchild.game3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Toast;

import com.example.mobin.devchild.BluetoothHandle;
import com.example.mobin.devchild.Gameanim3;
import com.example.mobin.devchild.R;



public class GameView3 extends View {
    int canvasHeight;
    int canvasWidth;

    private String cardTag="xx";
    private char cardNumber='y';

    public String[] Tags = {"11","22","33","44","55","66"};
    Bitmap bg;
    Paint emptyPaint = new Paint();
    Paint p1Paint = new Paint();
    Paint p2Paint = new Paint();

    Bitmap p101, p102, p103, p104;
    Bitmap p201, p202, p203, p204;

    Context mContext;

    //private String cardTag="3exyz";
    private String resultPosition="";

    public GameView3(Context context) {
        super(context);

        mContext = context;

        bg = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

        p101 = BitmapFactory.decodeResource(getResources(), R.drawable.seq_1);
        p102 = BitmapFactory.decodeResource(getResources(), R.drawable.seq_2);
        p103 = BitmapFactory.decodeResource(getResources(), R.drawable.seq_3);
        p104 = BitmapFactory.decodeResource(getResources(), R.drawable.seq_4);

        p201 = BitmapFactory.decodeResource(getResources(), R.drawable.seq_5);
        p202 = BitmapFactory.decodeResource(getResources(), R.drawable.seq_6);
        //p203 = BitmapFactory.decodeResource(getResources(), R.drawable.table);
        //p204 = BitmapFactory.decodeResource(getResources(), R.drawable.lamp);

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

        setCardAndKnock();

        //canvas.drawBitmap(bg , 0 , 0 , null);

        canvas.drawText("Please set a CARD first", (canvasWidth/4), (canvasHeight/2)-50, emptyPaint );
        //canvas.drawBitmap(bg, null, new RectF(0, 0, canvasWidth/2, canvasHeight/2), null);

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
                canvas.drawBitmap(p101, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[0].equals("8ba6610a"))
            {
                canvas.drawBitmap(p102, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[0].equals("e9310364"))
            {
                canvas.drawBitmap(p103, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[0].equals("5b61cb0c"))
            {
                canvas.drawBitmap(p104, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[0].equals("6b3c5a0a"))
            {
                canvas.drawBitmap(p201, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[0].equals("8b31bf0c"))
            {
                canvas.drawBitmap(p202, null, new RectF(0, 0, canvasWidth/3, (canvasHeight/2)-200), null);
            }


            if(Tags[1].equals("1bdc550d"))
            {
                canvas.drawBitmap(p101, null, new RectF(canvasWidth/3, 0, 2*canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[1].equals("8ba6610a"))
            {
                canvas.drawBitmap(p102, null, new RectF(canvasWidth/3, 0, 2*canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[1].equals("e9310364"))
            {
                canvas.drawBitmap(p103, null, new RectF(canvasWidth/3, 0, 2*canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[1].equals("5b61cb0c"))
            {
                canvas.drawBitmap(p104, null, new RectF(canvasWidth/3, 0, 2*canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[1].equals("6b3c5a0a"))
            {
                canvas.drawBitmap(p201, null, new RectF(canvasWidth/3, 0, 2*canvasWidth/3, (canvasHeight/2)-200), null);
            }
            if(Tags[1].equals("8b31bf0c"))
            {
                canvas.drawBitmap(p202, null, new RectF(canvasWidth/3, 0, 2*canvasWidth/3, (canvasHeight/2)-200), null);
            }

            if(Tags[2].equals("1bdc550d"))
            {
                canvas.drawBitmap(p101, null, new RectF(2*canvasWidth/3, 0, canvasWidth, (canvasHeight/2)-200), null);
            }
            if(Tags[2].equals("8ba6610a"))
            {
                canvas.drawBitmap(p102, null, new RectF(2*canvasWidth/3, 0, canvasWidth, (canvasHeight/2)-200), null);
            }
            if(Tags[2].equals("e9310364"))
            {
                canvas.drawBitmap(p103, null, new RectF(2*canvasWidth/3, 0, canvasWidth, (canvasHeight/2)-200), null);
            }
            if(Tags[2].equals("5b61cb0c"))
            {
                canvas.drawBitmap(p104, null, new RectF(2*canvasWidth/3, 0, canvasWidth, (canvasHeight/2)-200), null);
            }
            if(Tags[2].equals("6b3c5a0a"))
            {
                canvas.drawBitmap(p201, null, new RectF(2*canvasWidth/3, 0, canvasWidth, (canvasHeight/2)-200), null);
            }
            if(Tags[2].equals("8b31bf0c"))
            {
                canvas.drawBitmap(p202, null, new RectF(2*canvasWidth/3, 0, canvasWidth, (canvasHeight/2)-200), null);
            }

            if(Tags[3].equals("1bdc550d"))
            {
                canvas.drawBitmap(p101, null, new RectF(0, (canvasHeight/2)-200, canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[3].equals("8ba6610a"))
            {
                canvas.drawBitmap(p102, null, new RectF(0, (canvasHeight/2)-200, canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[3].equals("e9310364"))
            {
                canvas.drawBitmap(p103, null, new RectF(0, (canvasHeight/2)-200, canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[3].equals("5b61cb0c"))
            {
                canvas.drawBitmap(p104, null, new RectF(0, (canvasHeight/2)-200, canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[3].equals("6b3c5a0a"))
            {
                canvas.drawBitmap(p201, null, new RectF(0, (canvasHeight/2)-200, canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[3].equals("8b31bf0c"))
            {
                canvas.drawBitmap(p202, null, new RectF(0, (canvasHeight/2)-200, canvasWidth/3, canvasHeight-200), null);
            }

            if(Tags[4].equals("1bdc550d"))
            {
                canvas.drawBitmap(p101, null, new RectF(canvasWidth/3, (canvasHeight/2)-200, 2*canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[4].equals("8ba6610a"))
            {
                canvas.drawBitmap(p102, null, new RectF(canvasWidth/3, (canvasHeight/2)-200, 2*canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[4].equals("e9310364"))
            {
                canvas.drawBitmap(p103, null, new RectF(canvasWidth/3, (canvasHeight/2)-200, 2*canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[4].equals("5b61cb0c"))
            {
                canvas.drawBitmap(p104, null, new RectF(canvasWidth/3, (canvasHeight/2)-200, 2*canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[4].equals("6b3c5a0a"))
            {
                canvas.drawBitmap(p201, null, new RectF(canvasWidth/3, (canvasHeight/2)-200, 2*canvasWidth/3, canvasHeight-200), null);
            }
            if(Tags[4].equals("8b31bf0c"))
            {
                canvas.drawBitmap(p202, null, new RectF(canvasWidth/3, (canvasHeight/2)-200, 2*canvasWidth/3, canvasHeight-200), null);
            }

            if(Tags[5].equals("1bdc550d"))
            {
                canvas.drawBitmap(p101, null, new RectF(2*canvasWidth/3, (canvasHeight/2)-200, canvasWidth, canvasHeight-200), null);
            }
            if(Tags[5].equals("8ba6610a"))
            {
                canvas.drawBitmap(p102, null, new RectF(2*canvasWidth/3, (canvasHeight/2)-200, canvasWidth, canvasHeight-200), null);
            }
            if(Tags[5].equals("e9310364"))
            {
                canvas.drawBitmap(p103, null, new RectF(2*canvasWidth/3, (canvasHeight/2)-200, canvasWidth, canvasHeight-200), null);
            }
            if(Tags[5].equals("5b61cb0c"))
            {
                canvas.drawBitmap(p104, null, new RectF(2*canvasWidth/3, (canvasHeight/2)-200, canvasWidth, canvasHeight-200), null);
            }
            if(Tags[5].equals("6b3c5a0a"))
            {
                canvas.drawBitmap(p201, null, new RectF(2*canvasWidth/3, (canvasHeight/2)-200, canvasWidth, canvasHeight-200), null);
            }
            if(Tags[5].equals("8b31bf0c"))
            {
                canvas.drawBitmap(p202, null, new RectF(2*canvasWidth/3, (canvasHeight/2)-200, canvasWidth, canvasHeight-200), null);
            }


        if(Tags[0].equals("11") || Tags[1].equals("22") || Tags[2].equals("33") || Tags[3].equals("44") || Tags[4].equals("55") || Tags[5].equals("66"))
        {
            Gameanim3.success = "5";
        }
        else if(Tags[0].equals("1bdc550d") && Tags[1].equals("8ba6610a") && Tags[2].equals("e9310364") && Tags[3].equals("5b61cb0c") && Tags[4].equals("6b3c5a0a") && Tags[5].equals("8b31bf0c")) {
            System.out.println("Milse re Milseeee!!!!!\n\n\n");
            Gameanim3.success = "1";
            //Toast.makeText(getApplicationContext(), "Correct Sequence. Congrats!!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Gameanim3.success = "0";
        }



        if(cardTag.equals("e1cb07d5"))
        {
            canvas.drawBitmap(p201, null, new RectF(0, 0, canvasWidth/2, (canvasHeight/2)-200), null);
            canvas.drawBitmap(p202, null, new RectF(canvasWidth/2, 0, canvasWidth, (canvasHeight/2)-200), null);

            canvas.drawBitmap(p203, null, new RectF(0, (canvasHeight/2)-200, canvasWidth/2, canvasHeight-200), null);
            canvas.drawBitmap(p204, null, new RectF(canvasWidth/2, canvasHeight/2, canvasWidth, canvasHeight-200), null);

            canvas.drawText("- Find Chair -", (canvasWidth/4), (canvasHeight)-100, p1Paint );

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


}
