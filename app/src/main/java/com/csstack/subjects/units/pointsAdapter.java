package com.csstack.subjects.units;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csstack.R;

import java.util.ArrayList;

/**
 * Created by nandhu on 25/5/16.
 */
public class pointsAdapter extends RecyclerView.Adapter<pointsAdapter.ItemHolder> {

        public ArrayList<String > points;
        public PositionClick callback;

    public pointsAdapter(ArrayList<String> points,final PositionClick listener) {
        Log.d("COM_CSTACK","Inside Adapter");
        this.callback=listener;
        this.points=points;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.points,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder,int position) {
        holder.textview.setText(points.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (callback==null){
                Log.d("COM_CSTACK","call back is null");
            }
                else {
                Log.d("COM_CSTACK","call back not null");
                callback.positionClicked(holder.getAdapterPosition());
            }
            }
        });





    }

    @Override
    public int getItemCount() {
        return points.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textview;

        public ItemHolder(View itemView) {
            super(itemView);
            cardView =(CardView)itemView.findViewById(R.id.view);
            textview=(TextView)itemView.findViewById(R.id.textpoints);
        }


    }
    public interface PositionClick{
        void positionClicked(int position);
    }
}
