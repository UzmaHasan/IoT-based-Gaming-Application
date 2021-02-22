package com.example.mobin.devchild;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private EditText etname,etEmail,etpass,etPhone;
    private ProgressDialog p1;
    // private TextView t1;
    String id1;
    String id2;//default
    public String userid;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etEmail=findViewById(R.id.editTextEmail);
        etname=findViewById(R.id.editTextName);
        etpass=findViewById(R.id.editTextPassword);
        etPhone=findViewById(R.id.edit_text_phone);
        //    t1=findViewById(R.id.txt1);

        mAuth= FirebaseAuth.getInstance();
        p1= new ProgressDialog(this);

        findViewById(R.id.btn1).setOnClickListener(this);

        findViewById(R.id.txtuser).setOnClickListener(this);



    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser()==null){
            id2="No";
            //cvshb
            //   Intent intent = new Intent(getApplicationContext(),Retrieve.class);
            //   intent.putExtra("EXTRA_SESSION_ID", id1);
            //  intent.putExtra("UserName",id2);
            // startActivity(intent);

        }

    }

    private void registerUser(){
        final String name = etname.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        String password = etpass.getText().toString().trim();
        final String phone = etPhone.getText().toString().trim();

        p1.setMessage("Registering user...");
        p1.show();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        p1.dismiss();
                        if(task.isSuccessful()){

                            final User user = new User(
                                    name,
                                    email,
                                    phone
                            );

                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        String username=user.getName();

                                        String userid= FirebaseAuth.getInstance().getCurrentUser().getUid();

                                        Intent i = new Intent(getApplicationContext(), ChildParentOption.class);
                                        i.putExtra("UserId",userid);
                                        startActivity(i);
                                        //  Toast.makeText(MainActivity.this, "Success ! Done", Toast.LENGTH_SHORT).show();
                                        //   Intent intent = new Intent(getApplicationContext(),UserLoginPg.class);
                                        //   intent.putExtra("EXTRA_SESSION_ID", id1);
                                        //   intent.putExtra("UserName",username);
                                        //  startActivity(intent);
                                    }
                                }
                            });



                        }
                        else {
                            Toast.makeText(Register.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void registerServiceProvider(){
        final String name = etname.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        String password = etpass.getText().toString().trim();
        final String phone = etPhone.getText().toString().trim();

        p1.setMessage("Registering provider...");
        p1.show();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        p1.dismiss();
                        if(task.isSuccessful()){

                            final User user = new User(
                                    name,
                                    email,
                                    phone
                            );

                            userid= FirebaseAuth.getInstance().getCurrentUser().getUid();
                            FirebaseDatabase.getInstance().getReference("ServiceProviders")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        id1=user.getName();
                                        String uid= FirebaseAuth.getInstance().getCurrentUser().getUid();
                                        // id1=user.getEmail();
                                       /* Intent intent = new Intent(getApplicationContext(), MyServices.class);
                                        intent.putExtra("EXTRA_SESSION_ID", id1);
                                        intent.putExtra("Uid",uid);
                                        startActivity(intent);*/
                                        // finish();
                                        // startActivity(new Intent(getApplicationContext(),MyServices.class));
                                    }
                                }
                            });

                            //   FirebaseDatabase.getInstance().getReference("Services").setValue(user.getName());



                        }
                        else {
                            Toast.makeText(Register.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn1){
            registerUser();
            //startActivity(new Intent(this, Gif.class));
        }

        else if(v.getId()==R.id.txtuser){
            finish();
            //   startActivity(new Intent(this,UserLoginPg.class));
            // Intent i=new Intent(this,Retrieve.class);
            // startActivity(i);
        }


    }

}
