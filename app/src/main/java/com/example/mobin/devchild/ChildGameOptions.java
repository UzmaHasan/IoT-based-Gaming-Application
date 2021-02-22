package com.example.mobin.devchild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildGameOptions extends AppCompatActivity {

    Button btn1,btn2,btn3;

    public String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_game_options);


        test=getIntent().getStringExtra("UserId");

        btn1 = findViewById(R.id.btnGame01);
        btn2 = findViewById(R.id.btnGame02);
        btn3 = findViewById(R.id.btnGame03);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildGameOptions.this, Gameanim1.class);
                intent.putExtra("UserId",test);
                startActivity(intent);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildGameOptions.this, Gameanim2.class);
                intent.putExtra("UserId",test);
                startActivity(intent);
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildGameOptions.this, MultiSequence.class);
                intent.putExtra("UserId",test);
                startActivity(intent);
            }
        });
    }
}
