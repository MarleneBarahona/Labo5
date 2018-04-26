package com.barahona.labo5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 18/04/2018.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {
    private ArrayList<Serie> series;
    private static boolean serieFav = false;
    private Context mCtx;

    public SeriesAdapter(ArrayList<Serie> series, Context context){
        this.series = series;
        this.mCtx = context;
    }


    public static class SeriesViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView name;
        ImageView img;
        ImageButton toast;

        public SeriesViewHolder(View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card_view);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
            toast = itemView.findViewById(R.id.button);

        }
    }

    @Override
    public  SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        return (new SeriesViewHolder(v));
    }
    @Override
    public void onBindViewHolder(final SeriesViewHolder holder, final int position){
        holder.name.setText(series.get(position).getName());
        holder.img.setImageResource(series.get(position).getImg());

        if(series.get(position).verificarFav())
            holder.toast.setImageResource(R.drawable.starfav);
        else
            holder.toast.setImageResource(R.drawable.estrella_gris);

        holder.toast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (favserie(position)) {
                    holder.toast.setImageResource(R.drawable.starfav);
                    ((MainActivity)mCtx).addFavList(series.get(position));
                }else {
                    holder.toast.setImageResource(R.drawable.estrella_gris);
                }
            }
        });
    }
    @Override
    public int getItemCount(){
        return series.size();
    }


    public boolean favserie(int position){
        series.get(position).set(!series.get(position).verificarFav());
        return series.get(position).verificarFav();
    }
    public void setTrue(){
        serieFav=true;
    }

    public void setFalse(){
        serieFav=false;
    }
}
