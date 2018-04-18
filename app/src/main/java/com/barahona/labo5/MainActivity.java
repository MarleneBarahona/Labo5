package com.barahona.labo5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;
    LinearLayoutManager IManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        series = new ArrayList<>();

        rv = findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        IManager= new LinearLayoutManager(this);
        rv.setLayoutManager(IManager);

        prepareSeries();

        adapter = new SeriesAdapter(series, this);
        rv.setAdapter(adapter);
    }

    private void prepareSeries() {
        String TAG = "Mensaje";
        series = new ArrayList<>();
        series.add(new Serie("BONES","20", R.drawable.bones_banner, "TV show blah blah blah"));
        series.add(new Serie("This is us","20", R.drawable.this_is_us, "TV show blah blah blah"));
        series.add(new Serie("Hawaii Five-0","20", R.drawable.hawaii_five_0, "TV show blah blah blah"));
    }
}
