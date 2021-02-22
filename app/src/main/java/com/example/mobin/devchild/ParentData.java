package com.example.mobin.devchild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ParentData extends AppCompatActivity {


    public String test;
    Button btnRetrieve1, btnRetrieve2, btnRetrieve3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_data);

        test=getIntent().getStringExtra("UserId");

        btnRetrieve1 = findViewById(R.id.btnRetrieve1);
        btnRetrieve2 = findViewById(R.id.btnRetrieve2);
        btnRetrieve3 = findViewById(R.id.btnRetrieve3);


        btnRetrieve1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ParentData.this, Retrieve.class);
                i.putExtra("UserId",test);
                startActivity(i);
            }
        });

        btnRetrieve2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnRetrieve3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
