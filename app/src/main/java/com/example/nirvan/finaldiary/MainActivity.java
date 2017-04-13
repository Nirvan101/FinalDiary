package com.example.nirvan.finaldiary;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

   // FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
    //fragmentDiary fragDiary=new fragmentDiary();
    //fragmentCal fragCal=new fragmentCal();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentCal fragCal=new fragmentCal();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container,fragCal).commit();
    }


    public void callFragmentDiary(int []date)
    {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        fragmentDiary fragDiary=new fragmentDiary();

       Bundle bundle=new Bundle();
        bundle.putInt("day",date[0]);
        bundle.putInt("month",date[1]);
        bundle.putInt("year",date[2]);


        fragDiary.setArguments(bundle);
        ft.replace(R.id.container , fragDiary).commit();
    }

    public void callFragmentCal()
    {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        fragmentCal fragCal=new fragmentCal();


        ft.replace(R.id.container , fragCal).commit();
    }
}
