package com.example.sunil.recyclervieweg10;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sunil on 1/9/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    private String[] data;
    public MyAdapter(String[] data) {
        this.data=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup vg, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(vg.getContext());
        View view =inflater.inflate(R.layout.list_item,vg,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        String title=data[position];
        holder.title.setText(title);
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            icon= itemView.findViewById(R.id.image_icon);
            title= itemView.findViewById(R.id.text_title);
        }
    }



}
