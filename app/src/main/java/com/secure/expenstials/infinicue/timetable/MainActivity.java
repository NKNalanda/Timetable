package com.secure.expenstials.infinicue.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    ListView tableView;
    int seekValue = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setMax(20);
        seekBar.setProgress(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;

                if (progress < min)
                {
                    seekValue = min;
                    seekBar.setProgress(min);
                }
                else {
                    seekValue = progress;
                }
                setTableValues(seekValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setTableValues(10);
    }

    public void setTableValues(int value)
    {
        tableView = (ListView) findViewById(R.id.tableView);

        ArrayList<String> arrayList = new ArrayList<String>();

        for (int i = 1;i <= 10;i++)
        {
            arrayList.add(String.valueOf(seekValue * i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);

        tableView.setAdapter(arrayAdapter);
    }
}
