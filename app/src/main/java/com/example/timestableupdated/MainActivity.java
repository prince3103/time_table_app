package com.example.timestableupdated;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int max = 20;
        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(max);
        seekBar.setProgress(10);
        generateTimesTable(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                if(i<min){
                    i=min;
                    seekBar.setProgress(i);
                }
                generateTimesTable(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void generateTimesTable(int TimesTableNumber){
        System.out.println("function starts");
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i=1;i<=100;i++){
            arrayList.add(Integer.toString(i*TimesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new  ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }
}
