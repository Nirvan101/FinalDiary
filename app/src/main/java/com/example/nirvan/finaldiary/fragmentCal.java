package com.example.nirvan.finaldiary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;



/**
 * Created by NIRVAN on 01-04-2017.
 */
public class fragmentCal extends Fragment
{
    int[] date=new int[3];     //3 integers: 0-> day    1->month     2->year

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {


        View parentHolder=inflater.inflate(R.layout.fragmentcal,container,false);
//        View parentHolder=super.onCreateView(inflater, container, savedInstanceState);
        Button button = (Button) parentHolder.findViewById(R.id.button);
        Log.d("w", "reached here");
//        Button button= (Button)(new MainActivity()).findViewById(R.id.button);
        CalendarView calendarView=(CalendarView)parentHolder.findViewById(R.id.calenderView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2)
            {
                date[0]=i2;
                date[1]=i1;
                date[2]=i;
            }
        });

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


                ( (MainActivity)(getActivity())).callFragmentDiary(date);
            }
        });

        return parentHolder;
    }

    public fragmentCal() {}
}
