package com.example.covid19_news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView link;
        public TextView pubdate;

        public MyViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            link = v.findViewById(R.id.link);
            pubdate = v.findViewById(R.id.pubdate);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    private ArrayList<Item> item;
    public MyAdapter(ArrayList<Item> item) {
        this.item = item;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder)holder;
        myViewHolder.title.setText(item.get(position).getTitle());
        myViewHolder.link.setText(item.get(position).getLink());
        myViewHolder.pubdate.setText(item.get(position).getPubdate());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return item.size();
    }
}
