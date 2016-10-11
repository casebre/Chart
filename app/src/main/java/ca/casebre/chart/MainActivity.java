package ca.casebre.chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LineChart chart = (LineChart) findViewById(R.id.chart);

        List<Entry> entries = new ArrayList<Entry>();

        List<Pair<Integer, Integer>> list = new LinkedList<>();
        list.add(new Pair<Integer, Integer>(1, 2));
        list.add(new Pair<Integer, Integer>(2, 5));
        list.add(new Pair<Integer, Integer>(3, 10));
        list.add(new Pair<Integer, Integer>(4, 1));

        for (Pair<Integer, Integer> data : list) {

            // turn your data into Entry objects
            entries.add(new Entry(data.first, data.second));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Profile"); // add entries to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh
    }
}
