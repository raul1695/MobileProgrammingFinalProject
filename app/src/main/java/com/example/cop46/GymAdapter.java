//Recycler objects require special adapters in order to handle/display them correctly. 


package com.example.cop46;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class GymAdapter extends RecyclerView.Adapter < GymAdapter.MyViewHolder > {
    private Context context;

    // An ArrayList is of type Gym is used to handle the multiple gym objects that are 
    //placed inside recycler views
    private ArrayList < Gym > dataModel;
    private int width,
    height;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text_title;
        TextView rating;
        View itemView;
        public MyViewHolder(View view) {
            super(view);
            this.text_title = (TextView) view.findViewById(R.id.title);
            this.rating = (TextView) view.findViewById(R.id.rating_gym);
            this.itemView = view;
        }
    }

    // Two versions of the Gym adapter with An ArrayList as argument (multiple gyms) 
    //and a single Gym obj version

    public GymAdapter(Context _context, ArrayList < Gym > data) {
        this.context = _context;
        this.dataModel = data;
        this.width = 160;
        this.height = 100;
    }

    public GymAdapter(Context _context, ArrayList < Gym > data, int _width, int _height) {
        this.context = _context;
        this.dataModel = data;
        this.width = _width;
        this.height = _height;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gym, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        try {

} catch(Exception e) {
            e.printStackTrace();
        }
    }
    private int getImage(String imageName) {
        int drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return drawableResourceId;
    }

    @Override
    public int getItemCount() {
        return dataModel.size();
    }

}