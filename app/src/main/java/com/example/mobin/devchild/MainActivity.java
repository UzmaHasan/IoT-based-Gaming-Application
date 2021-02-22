package com.example.mobin.devchild;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // private Button b1;
    private EditText e1;
    private EditText e2;
    private TextView t1,t2;
    private ProgressDialog p1;
    private FirebaseAuth f1;
    private CardView cv;
    //private FirebaseDatabase d1;
    private BluetoothAdapter mBTAdapter;
    public String userid;
    User user;
    String username,usermail;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f1= FirebaseAuth.getInstance();

        mBTAdapter = BluetoothAdapter.getDefaultAdapter();
        //if(BluetoothHandle.value == "")
        //{
        //    if ( mBTAdapter.isEnabled()) {
        //        mBTAdapter.disable();
        //    }
        //}

        p1= new ProgressDialog(this);
        t1= findViewById(R.id.textView2);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        //t1=findViewById(R.id.textView2);

        cv = findViewById(R.id.cardView);

        cv.setOnClickListener(this);
        t1.setOnClickListener(this);

    }


    private void userlog(){
        String email = e1.getText().toString().trim();
        String pass = e2.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter your mail", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Enter pass pls", Toast.LENGTH_SHORT).show();
            return;
        }

        p1.setMessage("Logging user...");
        p1.show();

        f1.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        p1.dismiss();
                        Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                        if(task.isSuccessful()){



                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(f1.getCurrentUser().getUid())
                                    .addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            user=dataSnapshot.getValue(User.class);
                 //                           username=user.getName();
                  //                          usermail=user.getEmail();
                                            userid= FirebaseAuth.getInstance().getCurrentUser().getUid();
                                        /*    Intent intent = new Intent(getApplicationContext(), Retrieve.class);
                                            //  Toast.makeText(UserLoginPg.this,username, Toast.LENGTH_SHORT).show();
                                            intent.putExtra("UserName",username);
                                            intent.putExtra("Email",usermail);
                                            startActivity(intent);*/

                                            Log.d("MainActivity", userid);

                                        Intent i = new Intent(getApplicationContext(), ChildParentOption.class);
                                        i.putExtra("UserId",userid);
                                        startActivity(i);
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                        }
                    }
                });


    }
    @Override
    public void onClick(View view) {
        if(view==cv){
            userlog();
            //startActivity(new Intent(this, Gif.class));
        }
        if(view==t1){
            finish();
            startActivity(new Intent(this,Register.class));
        }
    }

}


