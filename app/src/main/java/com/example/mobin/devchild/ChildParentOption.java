package com.example.mobin.devchild;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildParentOption extends AppCompatActivity {



    Button btnP, btnC;
    private BluetoothAdapter mBTAdapter;

    public String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_parent_option);


        test=getIntent().getStringExtra("UserId");

        mBTAdapter = BluetoothAdapter.getDefaultAdapter(); // get a handle on the bluetooth radio

        //BluetoothAdapter mBtAdapter = BluetoothAdapter.getDefaultAdapter();




        btnP = findViewById(R.id.btnParent);
        btnC = findViewById(R.id.btnChild);


        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChildParentOption.this, ParentData.class);
                i.putExtra("UserId",test);
                startActivity(i);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (!mBTAdapter.isEnabled()){
                    Intent i = new Intent(getApplicationContext(), BluetoothHandle.class);
                    i.putExtra("UserId",test);
                    startActivity(i);
                //}



                //Intent i = new Intent(ChildParentOption.this, ChildGameOptions.class);
                //i.putExtra("UserId",test);
                //startActivity(i);
            }
        });

    }
}
