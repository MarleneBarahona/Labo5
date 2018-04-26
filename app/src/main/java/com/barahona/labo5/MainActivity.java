package com.barahona.labo5;

import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series, fvlst;
    LinearLayoutManager IManager;
    Button menu_series, menu_favs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        series = new ArrayList<>();
        fvlst = new ArrayList<>();
        menu_series = findViewById(R.id.bttn_series);
        menu_favs = findViewById(R.id.bttn_favs);

        rv = findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        IManager = new LinearLayoutManager(this);
        rv.setLayoutManager(IManager);

        prepareSeries();
        adapter = new SeriesAdapter(series, this);
        rv.setAdapter(adapter);
    }
    public void menu_list_series(View v){
        adapter.setFalse();
        adapter = new SeriesAdapter(series, v.getContext());
        rv.setAdapter(adapter);
    }
    public void menu_list_favs(View v){
        adapter.setTrue();
        adapter = new SeriesAdapter(fvlst, v.getContext());
        rv.setAdapter(adapter);
    }

    private void prepareSeries() {
        String TAG = "Mensaje";
        series = new ArrayList<>();
        series.add(new Serie("BONES","22", R.drawable.bones_banner, "Emitida en FOX\n" + "Temporada producida en 2005"));
        series.add(new Serie("This is us","24", R.drawable.this_is_us, "Emitida en CBS\n" + "Temporada producida en 2010"));
        series.add(new Serie("Hawaii Five-0","18", R.drawable.hawaii_five_0, "Emitida en NBC\n" + "Temporada producida en 2016"));
        series.add(new Serie("Breaking Bad","20", R.drawable.breaking_bad, "Emitida en AMC\n" + "Temporada producida en 2008"));
    }
    public void addFavList(Serie FavsList){
        fvlst.add(FavsList);
    }
}