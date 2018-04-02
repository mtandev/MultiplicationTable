package com.example.android.multiplicationtable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTable;

    public void generateTimesTable(int timesTableNumber) {

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int j = 2; j <= 10; j++) {
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timesTable.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final SeekBar seekBar = findViewById(R.id.seekBar);
       timesTable = findViewById(R.id.timesTable);

       int max = 20;
       int startPosition = 10;

       seekBar.setMax(max);
       seekBar.setProgress(startPosition);

       generateTimesTable(startPosition);

       seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

               int min = 2;
               int timesTableNumber;

               if (i < min) {
                  timesTableNumber = min;
                  seekBar.setProgress(min);
               } else {
                   timesTableNumber = i;
               }

               Log.i("Seekbar Value", Integer.toString(timesTableNumber));

               generateTimesTable(timesTableNumber);



           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });
    }
}
