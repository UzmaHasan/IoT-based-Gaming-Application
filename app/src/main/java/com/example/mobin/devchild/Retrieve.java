package com.example.mobin.devchild;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Retrieve extends Activity {

    private TextView retrieve;
    String test;
    Attempts attempts;
    BarChart b,b2,b3;

    ArrayList<Float> janValues = new ArrayList<>();
    ArrayList<Float> febValues = new ArrayList<>();
    ArrayList<Float> marValues = new ArrayList<>();
    ArrayList<Float> aprValues = new ArrayList<>();
    ArrayList<Float> mayValues = new ArrayList<>();
    ArrayList<Float> junValues = new ArrayList<>();



    ArrayList<Float> may04Values = new ArrayList<>();
    ArrayList<Float> may05Values = new ArrayList<>();
    ArrayList<Float> may06Values = new ArrayList<>();
    ArrayList<Float> may07Values = new ArrayList<>();
    ArrayList<Float> may08Values = new ArrayList<>();
    ArrayList<Float> may09Values = new ArrayList<>();


    float janAvg= 0;
    float febAvg= 0;
    float marAvg= 0;
    float aprAvg= 0;
    float mayAvg= 0;
    float junAvg= 0;

    float may04Avg= 0;
    float may05Avg= 0;
    float may06Avg= 0;
    float may07Avg= 0;
    float may08Avg= 0;
    float may09Avg= 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        b = findViewById(R.id.bargraph);
        b2 = findViewById(R.id.bargraph2);
        b3 = findViewById(R.id.bargraph3);
        test = getIntent().getStringExtra("UserId");


     //   retrieve = findViewById(R.id.retrieve);

        //day by day graph for 6 days



        //------------------------------------------------------------->

        FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game1").child("Date").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String key = ds.getKey().toString();
                    //System.out.println(key);
                    String ans = "";
                    if(key.equals("May 04"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may04Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 05"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may05Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 06"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may06Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 07"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may07Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 08"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may08Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 09"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may09Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    //attempts = ds.getValue(Attempts.class);
                    //String ans = "";
                    //ArrayList<Float> af = new ArrayList<>();
                    //ArrayList<String> tmp = attempts.getAllAttempts();
                    //for (int i = 0; i < attempts.attempts.size(); i++) {
                    //    float a = attempts.attempts.get(i).charAt(0);
                    //    a -= 48;
                    //    af.add(a);

                    //ans += attempts.attempts.get(i);
                    //    ans+=a;
                    //    ans += " ";
                    //}
                    //Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt1(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt2(), Toast.LENGTH_SHORT).show();




                }

//-------------- ekhan theke kaj baki ase. remember?

                for(int i=0;i<may04Values.size();i++)
                {
                    may04Avg+=may04Values.get(i);
                }
                may04Avg = may04Avg / may04Values.size();

                for(int i=0;i<may05Values.size();i++)
                {
                    may05Avg+=may05Values.get(i);
                }
                may05Avg/=may05Values.size();

                for(int i=0;i<may06Values.size();i++)
                {
                    may06Avg+=may06Values.get(i);
                }
                may06Avg/=may06Values.size();

                for(int i=0;i<may07Values.size();i++)
                {
                    may07Avg+=may07Values.get(i);
                }
                may07Avg/=may07Values.size();

                for(int i=0;i<may08Values.size();i++)
                {
                    may08Avg+=may08Values.get(i);
                }
                may08Avg/=may08Values.size();

                for(int i=0;i<may09Values.size();i++)
                {
                    may09Avg+=may09Values.get(i);
                }
                may09Avg/=may09Values.size();

                String a=may04Avg+"";
                String bb=may05Avg+"";


                Toast.makeText(Retrieve.this, a, Toast.LENGTH_SHORT).show();
                Toast.makeText(Retrieve.this, bb, Toast.LENGTH_SHORT).show();




                //        b = findViewById(R.id.bargraph);
                ArrayList<BarEntry> barEntries = new ArrayList<>();
                barEntries.add(new BarEntry(may04Avg, 0));
                barEntries.add(new BarEntry(may05Avg, 1));
                barEntries.add(new BarEntry(may06Avg, 2));
                barEntries.add(new BarEntry(may07Avg, 3));
                barEntries.add(new BarEntry(may08Avg, 4));
                barEntries.add(new BarEntry(may09Avg, 5));

                BarDataSet bardataset = new BarDataSet(barEntries, "Dates");

                ArrayList<String> theDates = new ArrayList<>();
                theDates.add("May 04");
                theDates.add("May 05");
                theDates.add("May 06");
                theDates.add("May 07");
                theDates.add("May 08");
                theDates.add("May 09");

                BarData theData = new BarData(theDates, bardataset);

                b.setData(theData);
                b.setTouchEnabled(true);
                b.setDragEnabled(true);
                b.setScaleEnabled(true);
                b.setScaleY(1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("errorindata");
            }
        });
        ;
        // retrieve.setOnClickListener(this);



        FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game2").child("Date").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                may04Avg=0;
                may05Avg=0;
                may06Avg=0;
                may07Avg=0;
                may08Avg=0;
                may09Avg=0;

                may04Values.clear();
                may05Values.clear();
                may06Values.clear();
                may07Values.clear();
                may08Values.clear();
                may09Values.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String key = ds.getKey().toString();
                    //System.out.println(key);
                    String ans = "";
                    if(key.equals("May 04"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may04Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 05"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may05Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 06"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may06Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 07"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may07Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 08"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may08Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 09"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may09Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    //attempts = ds.getValue(Attempts.class);
                    //String ans = "";
                    //ArrayList<Float> af = new ArrayList<>();
                    //ArrayList<String> tmp = attempts.getAllAttempts();
                    //for (int i = 0; i < attempts.attempts.size(); i++) {
                    //    float a = attempts.attempts.get(i).charAt(0);
                    //    a -= 48;
                    //    af.add(a);

                    //ans += attempts.attempts.get(i);
                    //    ans+=a;
                    //    ans += " ";
                    //}
                    //Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt1(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt2(), Toast.LENGTH_SHORT).show();




                }

//-------------- ekhan theke kaj baki ase. remember?

                for(int i=0;i<may04Values.size();i++)
                {
                    may04Avg+=may04Values.get(i);
                }
                may04Avg = may04Avg / may04Values.size();

                for(int i=0;i<may05Values.size();i++)
                {
                    may05Avg+=may05Values.get(i);
                }
                may05Avg/=may05Values.size();

                for(int i=0;i<may06Values.size();i++)
                {
                    may06Avg+=may06Values.get(i);
                }
                may06Avg/=may06Values.size();

                for(int i=0;i<may07Values.size();i++)
                {
                    may07Avg+=may07Values.get(i);
                }
                may07Avg/=may07Values.size();

                for(int i=0;i<may08Values.size();i++)
                {
                    may08Avg+=may08Values.get(i);
                }
                may08Avg/=may08Values.size();

                for(int i=0;i<may09Values.size();i++)
                {
                    may09Avg+=may09Values.get(i);
                }
                may09Avg/=may09Values.size();



                //        b = findViewById(R.id.bargraph);
                ArrayList<BarEntry> barEntries = new ArrayList<>();
                barEntries.add(new BarEntry(may04Avg, 0));
                barEntries.add(new BarEntry(may05Avg, 1));
                barEntries.add(new BarEntry(may06Avg, 2));
                barEntries.add(new BarEntry(may07Avg, 3));
                barEntries.add(new BarEntry(may08Avg, 4));
                barEntries.add(new BarEntry(may09Avg, 5));

                BarDataSet bardataset = new BarDataSet(barEntries, "Dates");

                ArrayList<String> theDates = new ArrayList<>();
                theDates.add("May 04");
                theDates.add("May 05");
                theDates.add("May 06");
                theDates.add("May 07");
                theDates.add("May 08");
                theDates.add("May 09");

                BarData theData = new BarData(theDates, bardataset);
                b2.setData(theData);

                b2.setTouchEnabled(true);
                b2.setDragEnabled(true);
                b2.setScaleEnabled(true);
                b2.setScaleY(1);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("errorindata");
            }
        });





        //-------------------------------------------------------------->


        //------------------------------------------------------------------------>

        FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game3").child("Date").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                may04Avg=0;
                may05Avg=0;
                may06Avg=0;
                may07Avg=0;
                may08Avg=0;
                may09Avg=0;

                may04Values.clear();
                may05Values.clear();
                may06Values.clear();
                may07Values.clear();
                may08Values.clear();
                may09Values.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String key = ds.getKey().toString();
                    //System.out.println(key);
                    String ans = "";
                    if(key.equals("May 04"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may04Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 05"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may05Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 06"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may06Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 07"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may07Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 08"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may08Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May 09"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            may09Values.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    //attempts = ds.getValue(Attempts.class);
                    //String ans = "";
                    //ArrayList<Float> af = new ArrayList<>();
                    //ArrayList<String> tmp = attempts.getAllAttempts();
                    //for (int i = 0; i < attempts.attempts.size(); i++) {
                    //    float a = attempts.attempts.get(i).charAt(0);
                    //    a -= 48;
                    //    af.add(a);

                    //ans += attempts.attempts.get(i);
                    //    ans+=a;
                    //    ans += " ";
                    //}
                    //Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt1(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt2(), Toast.LENGTH_SHORT).show();




                }

//-------------- ekhan theke kaj baki ase. remember?

                for(int i=0;i<may04Values.size();i++)
                {
                    may04Avg+=may04Values.get(i);
                }
                may04Avg = may04Avg / may04Values.size();

                for(int i=0;i<may05Values.size();i++)
                {
                    may05Avg+=may05Values.get(i);
                }
                may05Avg/=may05Values.size();

                for(int i=0;i<may06Values.size();i++)
                {
                    may06Avg+=may06Values.get(i);
                }
                may06Avg/=may06Values.size();

                for(int i=0;i<may07Values.size();i++)
                {
                    may07Avg+=may07Values.get(i);
                }
                may07Avg/=may07Values.size();

                for(int i=0;i<may08Values.size();i++)
                {
                    may08Avg+=may08Values.get(i);
                }
                may08Avg/=may08Values.size();

                for(int i=0;i<may09Values.size();i++)
                {
                    may09Avg+=may09Values.get(i);
                }
                may09Avg/=may09Values.size();

                String a=may04Avg+"";
                String bb=may05Avg+"";


                Toast.makeText(Retrieve.this, a, Toast.LENGTH_SHORT).show();
                Toast.makeText(Retrieve.this, bb, Toast.LENGTH_SHORT).show();




                //        b = findViewById(R.id.bargraph);
                ArrayList<BarEntry> barEntries = new ArrayList<>();
                barEntries.add(new BarEntry(may04Avg, 0));
                barEntries.add(new BarEntry(may05Avg, 1));
                barEntries.add(new BarEntry(may06Avg, 2));
                barEntries.add(new BarEntry(may07Avg, 3));
                barEntries.add(new BarEntry(may08Avg, 4));
                barEntries.add(new BarEntry(may09Avg, 5));

                BarDataSet bardataset = new BarDataSet(barEntries, "Dates");

                ArrayList<String> theDates = new ArrayList<>();
                theDates.add("May 04");
                theDates.add("May 05");
                theDates.add("May 06");
                theDates.add("May 07");
                theDates.add("May 08");
                theDates.add("May 09");

                BarData theData = new BarData(theDates, bardataset);
                b3.setData(theData);

                b3.setTouchEnabled(true);
                b3.setDragEnabled(true);
                b3.setScaleEnabled(true);
                b3.setScaleY(1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("errorindata");
            }
        });



        //------------------------------------------------------------------------>


        FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game1").child("Date").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String key = ds.getKey().toString().substring(0,3);
                    //System.out.println(key);
                    String ans = "";
                    if(key.equals("Jan"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            janValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("Feb"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            febValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("Mar"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            marValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("Apr"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            aprValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            mayValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("Jun"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            junValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    //attempts = ds.getValue(Attempts.class);
                    //String ans = "";
                    //ArrayList<Float> af = new ArrayList<>();
                    //ArrayList<String> tmp = attempts.getAllAttempts();
                    //for (int i = 0; i < attempts.attempts.size(); i++) {
                    //    float a = attempts.attempts.get(i).charAt(0);
                    //    a -= 48;
                    //    af.add(a);

                        //ans += attempts.attempts.get(i);
                    //    ans+=a;
                    //    ans += " ";
                    //}
                    //Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt1(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt2(), Toast.LENGTH_SHORT).show();




                }


                for(int i=0;i<janValues.size();i++)
                {
                    janAvg+=janValues.get(i);
                }
                janAvg = janAvg / janValues.size();

                for(int i=0;i<febValues.size();i++)
                {
                    febAvg+=febValues.get(i);
                }
                febAvg/=febValues.size();

                for(int i=0;i<marValues.size();i++)
                {
                    marAvg+=marValues.get(i);
                }
                marAvg/=marValues.size();

                for(int i=0;i<aprValues.size();i++)
                {
                    aprAvg+=aprValues.get(i);
                }
                aprAvg/=aprValues.size();

                for(int i=0;i<mayValues.size();i++)
                {
                    mayAvg+=mayValues.get(i);
                }
                mayAvg/=mayValues.size();

                for(int i=0;i<junValues.size();i++)
                {
                    junAvg+=junValues.get(i);
                }
                junAvg/=junValues.size();



        //        b = findViewById(R.id.bargraph);
                ArrayList<BarEntry> barEntries = new ArrayList<>();
                barEntries.add(new BarEntry(janAvg, 0));
                barEntries.add(new BarEntry(febAvg, 1));
                barEntries.add(new BarEntry(marAvg, 2));
                barEntries.add(new BarEntry(aprAvg, 3));
                barEntries.add(new BarEntry(mayAvg, 4));
                barEntries.add(new BarEntry(junAvg, 5));

                BarDataSet bardataset = new BarDataSet(barEntries, "Dates");

                ArrayList<String> theDates = new ArrayList<>();
                theDates.add("January");
                theDates.add("February");
                theDates.add("March");
                theDates.add("April");
                theDates.add("May");
                theDates.add("June");

                BarData theData = new BarData(theDates, bardataset);
                //b.setData(theData);

                //b.setTouchEnabled(true);
                //b.setDragEnabled(true);
                //b.setScaleEnabled(true);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("errorindata");
            }
        });
        ;
        // retrieve.setOnClickListener(this);



        FirebaseDatabase.getInstance().getReference("Game").child(test).child("Game2").child("Date").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                janAvg=0;
                febAvg=0;
                marAvg=0;
                aprAvg=0;
                mayAvg=0;
                junAvg=0;

                janValues.clear();
                febValues.clear();
                marValues.clear();
                aprValues.clear();
                mayValues.clear();
                junValues.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String key = ds.getKey().toString().substring(0,3);
                    //System.out.println(key);
                    String ans = "";
                    if(key.equals("Jan"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            janValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("Feb"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            febValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("Mar"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            marValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("Apr"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            aprValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("May"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            mayValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    ans = "";
                    if(key.equals("Jun"))
                    {
                        //System.out.println("dhukse ekhane");
                        attempts = ds.getValue(Attempts.class);


                        for (int i = 0; i < attempts.attempts.size(); i++) {
                            float a = attempts.attempts.get(i).charAt(0);
                            a -= 48;
                            junValues.add(a);

                            //ans += attempts.attempts.get(i);
                            ans+=a;
                            ans += " ";
                        }

                        Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    }
                    //attempts = ds.getValue(Attempts.class);
                    //String ans = "";
                    //ArrayList<Float> af = new ArrayList<>();
                    //ArrayList<String> tmp = attempts.getAllAttempts();
                    //for (int i = 0; i < attempts.attempts.size(); i++) {
                    //    float a = attempts.attempts.get(i).charAt(0);
                    //    a -= 48;
                    //    af.add(a);

                    //ans += attempts.attempts.get(i);
                    //    ans+=a;
                    //    ans += " ";
                    //}
                    //Toast.makeText(Retrieve.this, ans, Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt1(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(Retrieve.this, attempts.getAt2(), Toast.LENGTH_SHORT).show();




                }


                for(int i=0;i<janValues.size();i++)
                {
                    janAvg+=janValues.get(i);
                }
                janAvg = janAvg / janValues.size();

                for(int i=0;i<febValues.size();i++)
                {
                    febAvg+=febValues.get(i);
                }
                febAvg/=febValues.size();

                for(int i=0;i<marValues.size();i++)
                {
                    marAvg+=marValues.get(i);
                }
                marAvg/=marValues.size();

                for(int i=0;i<aprValues.size();i++)
                {
                    aprAvg+=aprValues.get(i);
                }
                aprAvg/=aprValues.size();

                for(int i=0;i<mayValues.size();i++)
                {
                    mayAvg+=mayValues.get(i);
                }
                mayAvg/=mayValues.size();

                for(int i=0;i<junValues.size();i++)
                {
                    junAvg+=junValues.get(i);
                }
                junAvg/=junValues.size();



            //    b2 = findViewById(R.id.bargraph2);
                ArrayList<BarEntry> barEntries = new ArrayList<>();
                barEntries.add(new BarEntry(janAvg, 0));
                barEntries.add(new BarEntry(febAvg, 1));
                barEntries.add(new BarEntry(marAvg, 2));
                barEntries.add(new BarEntry(aprAvg, 3));
                barEntries.add(new BarEntry(mayAvg, 4));
                barEntries.add(new BarEntry(junAvg, 5));

                BarDataSet bardataset = new BarDataSet(barEntries, "Dates");

                ArrayList<String> theDates = new ArrayList<>();
                theDates.add("January");
                theDates.add("February");
                theDates.add("March");
                theDates.add("April");
                theDates.add("May");
                theDates.add("June");

                BarData theData = new BarData(theDates, bardataset);
                //b2.setData(theData);

                //b2.setTouchEnabled(true);
                //b2.setDragEnabled(true);
                //b2.setScaleEnabled(true);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("errorindata");
            }
        });

    }

}


