package com.example.mobin.devchild;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MultiSequence extends Activity {

    Button btnBrush, btnWeather;
    public String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_sequence);

        btnBrush = findViewById(R.id.idBrushSeq);
        btnWeather = findViewById(R.id.idWeather);

        test=getIntent().getStringExtra("UserId");
        btnBrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Gameanim31.class);
                i.putExtra("UserId",test);
                startActivity(i);
            }
        });


        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Gameanim32.class);
                i.putExtra("UserId",test);
                startActivity(i);
            }
        });

    }

}
