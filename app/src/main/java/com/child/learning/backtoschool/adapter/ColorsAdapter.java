package com.child.learning.backtoschool.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.RecyclerViewInterface;
import com.child.learning.backtoschool.models.ColorsModel;

import java.util.ArrayList;

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ViewHolder> {
    ArrayList<ColorsModel> colorsList;
    Context context;
    RecyclerViewInterface recyclerViewInterface;

    public ColorsAdapter(ArrayList<ColorsModel> colorsList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.colorsList = colorsList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_colors,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.clrBg.setBackgroundResource(colorsList.get(position).getImage());
        holder.clrTitle.setText(colorsList.get(position).getTitle());
        if (holder.clrTitle.getText().toString().equals("White")){
            holder.clrTitle.setTextColor(Color.parseColor("#000000"));
        }

        holder.itemView.setOnClickListener(view -> {
            recyclerViewInterface.onViewClicked(view.getId(), holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return colorsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout clrBg;
        TextView clrTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            clrBg = itemView.findViewById(R.id.clrBg);
            clrTitle = itemView.findViewById(R.id.clrTitle);
        }
    }
}
