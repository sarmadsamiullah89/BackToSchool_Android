package com.child.learning.backtoschool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.RecyclerViewInterface;
import com.child.learning.backtoschool.models.AnimalsModel;

import java.util.ArrayList;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.ViewHolder> {
    Context context;
    ArrayList<AnimalsModel> animalsModelList;
    RecyclerViewInterface recyclerViewInterface;

    public AnimalsAdapter(Context context, ArrayList<AnimalsModel> animalsModelList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.animalsModelList = animalsModelList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public AnimalsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_animals,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalsAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(animalsModelList.get(position).getImage());

        holder.itemView.setOnClickListener(view -> {
            recyclerViewInterface.onViewClicked(view.getId(), holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return animalsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
