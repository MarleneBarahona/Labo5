package com.barahona.labo5;

import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

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
        adapter=new SeriesAdapter(series, new SeriesAdapter.MyAdapterListener(){
            @Override
            public void toastOnClick(View v, int position) {
                Toast.makeText(getApplicationContext() ,series.get(position).getDesc()+"\nPages: "+series.get(position).getCaps() ,Toast.LENGTH_SHORT).show();

            }
        });
        rv.setAdapter(adapter);
    }

    private void prepareSeries() {
        String TAG = "Mensaje";
        series = new ArrayList<>();
        series.add(new Serie("BONES","22", R.drawable.bones_banner, "Emitida en FOX\n" + "Temporada producida en 2005"));
        series.add(new Serie("This is us","24", R.drawable.this_is_us, "Emitida en CBS\n" + "Temporada producida en 2010"));
        series.add(new Serie("Hawaii Five-0","18", R.drawable.hawaii_five_0, "Emitida en NBC\n" + "Temporada producida en 2016"));
    }
}
