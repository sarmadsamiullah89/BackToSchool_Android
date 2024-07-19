package com.child.learning.backtoschool.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;


import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.RecyclerViewInterface;
import com.child.learning.backtoschool.models.NumbersModel;

import java.util.ArrayList;

public class NumbersAdapter extends RecyclerView.Adapter<NumbersAdapter.ViewHolder> {
    ArrayList<NumbersModel> numbersList;
    Context context;
    RecyclerViewInterface recyclerViewInterface;

    public NumbersAdapter(ArrayList<NumbersModel> numbersList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.numbersList = numbersList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public NumbersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_numbers,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersAdapter.ViewHolder holder, int position) {
        holder.numTitle.setText(numbersList.get(position).getTitle());
        if (holder.numTitle.getText().toString().equals("1")){
            holder.numTitle.setTextColor(Color.parseColor("#FE0000"));
        }
        if (holder.numTitle.getText().toString().equals("2")){
            holder.numTitle.setTextColor(Color.parseColor("#FE6100"));
        }
        if (holder.numTitle.getText().toString().equals("3")){
            holder.numTitle.setTextColor(Color.parseColor("#FE9900"));
        }
        if (holder.numTitle.getText().toString().equals("4")){
            holder.numTitle.setTextColor(Color.parseColor("#FED100"));
        }
        if (holder.numTitle.getText().toString().equals("5")){
            holder.numTitle.setTextColor(Color.parseColor("#FEFA00"));
        }
        if (holder.numTitle.getText().toString().equals("6")){
            holder.numTitle.setTextColor(Color.parseColor("#CAFE00"));
        }
        if (holder.numTitle.getText().toString().equals("7")){
            holder.numTitle.setTextColor(Color.parseColor("#8BFE00"));
        }
        if (holder.numTitle.getText().toString().equals("8")){
            holder.numTitle.setTextColor(Color.parseColor("#05FE00"));
        }
        if (holder.numTitle.getText().toString().equals("9")){
            holder.numTitle.setTextColor(Color.parseColor("#00FE5C"));
        }
        if (holder.numTitle.getText().toString().equals("10")){
            holder.numTitle.setTextColor(Color.parseColor("#00FE9B"));
        }
        if (holder.numTitle.getText().toString().equals("11")){
            holder.numTitle.setTextColor(Color.parseColor("#00FEC8"));
        }
        if (holder.numTitle.getText().toString().equals("12")){
            holder.numTitle.setTextColor(Color.parseColor("#00F8FE"));
        }
        if (holder.numTitle.getText().toString().equals("13")){
            holder.numTitle.setTextColor(Color.parseColor("#00CFFE"));
        }
        if (holder.numTitle.getText().toString().equals("14")){
            holder.numTitle.setTextColor(Color.parseColor("#009FFE"));
        }
        if (holder.numTitle.getText().toString().equals("15")){
            holder.numTitle.setTextColor(Color.parseColor("#007AFE"));
        }
        if (holder.numTitle.getText().toString().equals("16")){
            holder.numTitle.setTextColor(Color.parseColor("#0037FE"));
        }
        if (holder.numTitle.getText().toString().equals("17")){
            holder.numTitle.setTextColor(Color.parseColor("#0500FE"));
        }
        if (holder.numTitle.getText().toString().equals("18")){
            holder.numTitle.setTextColor(Color.parseColor("#AD00FE"));
        }
        if (holder.numTitle.getText().toString().equals("19")){
            holder.numTitle.setTextColor(Color.parseColor("#FE00DC"));
        }
        if (holder.numTitle.getText().toString().equals("20")){
            holder.numTitle.setTextColor(Color.parseColor("#FE006C"));
        }

        holder.itemView.setOnClickListener(view -> {
            recyclerViewInterface.onViewClicked(view.getId(), holder.getAdapterPosition());
        });

    }

    @Override
    public int getItemCount() {
        return numbersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout numBg;
        TextView numTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numBg = itemView.findViewById(R.id.numBg);
            numTitle = itemView.findViewById(R.id.numTitle);
        }
    }
}
