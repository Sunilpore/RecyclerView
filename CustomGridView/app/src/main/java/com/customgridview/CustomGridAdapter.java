package com.customgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CustomGridAdapter extends RecyclerView.Adapter<CustomGridAdapter.ItemViewHolder>{

    private Context mContext;
    private ArrayList<String> imgListName;
    private int height;


    CustomGridAdapter(Context context, ArrayList<String> imgListName, int headerLayoutHeight) {

        mContext = context;
        this.imgListName = imgListName;
        height = headerLayoutHeight;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup vg, int viewType) {

        View view = LayoutInflater.from(vg.getContext()).inflate(R.layout.list_item,vg,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        ViewGroup.LayoutParams lp = holder.mLay.getLayoutParams();
        lp.height = height;
        holder.mLay.setLayoutParams(lp);

        holder.imgName.setText(imgListName.get(position));
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return imgListName.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout mLay;
        ImageView icon;
        TextView imgName;

        ItemViewHolder(View itemView) {
            super(itemView);

            mLay = itemView.findViewById(R.id.child_lay);
            icon = itemView.findViewById(R.id.item_imgvw);
            imgName = itemView.findViewById(R.id.item_name_tv);
        }
    }


}
