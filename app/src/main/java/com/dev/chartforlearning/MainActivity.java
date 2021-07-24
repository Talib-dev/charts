package com.dev.chartforlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LineChart chart;
    List<Entry> entries=new ArrayList<Entry>();

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 10;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart=findViewById(R.id.chart);
        setChart(chart, Color.rgb(89, 199, 250));

        dummyData();


    }

    void dummyData(){
        Random rand = new Random();

        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                Random rand = new Random();
                count++;

                // Generate random integers in range 0 to 999
                int rand_int1 = rand.nextInt(100);
                entries.add(new Entry(count,rand_int1));
                setData(entries);

                handler.postDelayed(runnable, delay);
            }
        }, delay);





    }

    void setData(List<Entry> entries){
        LineData lineData = new LineData(createDataSet(entries));

        chart.setData(lineData);
        chart.invalidate(); // refresh

    }

    LineChart setChart(LineChart chart,int color){

//        ((LineDataSet) data.getDataSetByIndex(0)).setCircleHoleColor(color);

        // no description text
        chart.getDescription().setEnabled(false);

        // chart.setDrawHorizontalGrid(false);
        //
        // enable / disable grid background
        chart.setDrawGridBackground(false);
//        chart.getRenderer().getGridPaint().setGridColor(Color.WHITE & 0x70FFFFFF);

        // enable touch gestures
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setBackgroundColor(color);

        // set custom chart offsets (automatic offset calculation is hereby disabled)
        chart.setViewPortOffsets(10, 0, 10, 0);

//        // add data
//        chart.setData(data);

        // get the legend (only possible after setting data)
        Legend l = chart.getLegend();
        l.setEnabled(false);

        XAxis x = chart.getXAxis();
        x.setLabelCount(6, false);
        x.setTextColor(Color.BLACK);
        x.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        x.setDrawGridLines(false);
        x.setAxisLineColor(Color.WHITE);

        YAxis y = chart.getAxisLeft();
        y.setLabelCount(6, false);
        y.setTextColor(Color.BLACK);
        y.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        y.setDrawGridLines(false);
        y.setAxisLineColor(Color.WHITE);
//        y.setAxisMinimum(0f);


//        chart.getAxisLeft().setEnabled(false);
//        chart.getAxisLeft().setSpaceTop(40);
//        chart.getAxisLeft().setSpaceBottom(40);
//        chart.getAxisRight().setEnabled(false);

//        chart.getXAxis().setEnabled(false);

        // animate calls invalidate()...
        chart.animateX(2500);
        chart.invalidate(); // refresh


        return chart;
    }

    LineDataSet createDataSet(List<Entry> entries){
        LineDataSet set1=new LineDataSet(entries,"Test");

        set1.setMode(LineDataSet.Mode.LINEAR);
        set1.setLineWidth(3f);
        set1.setColor(Color.WHITE);



//        set1.setCubicIntensity(0.2f);
//        set1.setDrawFilled(true);

        //circles on top config
        set1.setDrawCircles(false);
//        set1.setCircleRadius(4f);
//        set1.setCircleColor(Color.WHITE);
//        set1.setHighLightColor(Color.rgb(244, 117, 117));
//        set1.setFillColor(Color.WHITE);



//        set1.setFillAlpha(100);
//        set1.setDrawHorizontalHighlightIndicator(false);
//        set1.setFillFormatter(new IFillFormatter() {
//            @Override
//            public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
//                return chart.getAxisLeft().getAxisMinimum();
//            }
//        });



//        dataSet.setLineWidth(1.75f);
//        dataSet.setCircleRadius(5f);
//        dataSet.setCircleHoleRadius(2.5f);
//        dataSet.setColor(Color.WHITE);
//        dataSet.setCircleColor(Color.WHITE);
//        dataSet.setHighLightColor(Color.WHITE);
//        dataSet.setDrawValues(false);


        return set1;

    }
}