package com.example.nirvan.finaldiary;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by NIRVAN on 01-04-2017.
 */
public class fragmentDiary extends Fragment
{
    int day,month,year;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        //inflate the fragment
        View parentHolder=inflater.inflate(R.layout.fragmentdiary,container,false);

       //create the toolbar
        Toolbar toolbar = (Toolbar) parentHolder.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //receive the date from fragmentCal
        Bundle bundle=getArguments();
        day=bundle.getInt("day");
        month=bundle.getInt("month");
        year=bundle.getInt("year");


        //test
        Log.e("TAG","day:"+ day);
        Log.e("TAG","month:"+ month);
        Log.e("TAG","year:"+ year);
        //test


        setHasOptionsMenu(true);
        toolbar.setTitle(day+"/"+month+"/"+year);

        EditText text=(EditText)parentHolder.findViewById(R.id.text);

        //display the saved data
        SharedPreferences sharedPreferences= getContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
        text.setText(sharedPreferences.getString(day+"/"+month+"/"+year,null)  );

        return parentHolder;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();


        switch(id)
        {
            case R.id.backButton:
                ((MainActivity)getActivity()).callFragmentCal();
                break;
            case R.id.saveToolbarButton:
                EditText text=   (EditText) getView().findViewById(R.id.text);
                SharedPreferences sharedPreferences= getContext().getSharedPreferences("pref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(day+"/"+month+"/"+year,text.getText().toString());
                editor.commit();
                break;


            case R.id.image:
                ;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        Log.e("TAG","in onCreateOptionsMenu");
        getActivity().getMenuInflater().inflate(R.menu.diary_menu,menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    public fragmentDiary() {}
}
