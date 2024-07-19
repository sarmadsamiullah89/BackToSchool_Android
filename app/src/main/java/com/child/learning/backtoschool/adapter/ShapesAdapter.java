package com.child.learning.backtoschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.RecyclerViewInterface;
import com.child.learning.backtoschool.models.ShapesModel;

import java.util.ArrayList;

public class ShapesAdapter extends RecyclerView.Adapter<ShapesAdapter.ViewHolder> {
    ArrayList<ShapesModel> shapesList;
    Context context;
    RecyclerViewInterface recyclerViewInterface;

    public ShapesAdapter(ArrayList<ShapesModel> shapesList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.shapesList = shapesList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ShapesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_shapes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShapesAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(shapesList.get(position).getImage());
        holder.title.setText(shapesList.get(position).getTitle());

        holder.itemView.setOnClickListener(view -> {
            recyclerViewInterface.onViewClicked(view.getId(), holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return shapesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
        }
    }
}
