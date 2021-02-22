package com.example.mobin.devchild.game1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.mobin.devchild.BluetoothHandle;
import com.example.mobin.devchild.R;

import java.util.Random;

public class GameView extends View {

    private int canvasHeight;
    private int canvasWeight;

    private Bitmap human, bg;
    private Paint scorePaint = new Paint();

    private int cartoonX = 90;
    private int cartoonY = 90;

    public GameView(Context context) {
        super(context);

        human = BitmapFactory.decodeResource(getResources(), R.drawable.cartoon_human);
        bg = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(50);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        //ran = new Random(100);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        getXYvalue();

        canvas.drawBitmap(bg, 0, 0, null);
        canvas.drawBitmap(human, cartoonX, cartoonY, null);

        canvas.drawText("Score : 0", 20, 60, scorePaint);
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


            if(Integer.parseInt(valueX) == 2) cartoonX += 5;
            if(Integer.parseInt(valueX) == 1 ) cartoonX -= 5;

            if(Integer.parseInt(valueY) == 7) cartoonY += 5;
            if(Integer.parseInt(valueY) == 6) cartoonY -= 5;
        }



    }

}
