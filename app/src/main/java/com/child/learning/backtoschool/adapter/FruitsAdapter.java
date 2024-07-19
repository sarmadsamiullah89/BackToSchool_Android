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
import com.child.learning.backtoschool.models.FruitsModel;

import java.util.ArrayList;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsAdapter.ViewHolder> {
    Context context;
    ArrayList<FruitsModel> fruitsModelList;
    RecyclerViewInterface recyclerViewInterface;

    public FruitsAdapter(Context context, ArrayList<FruitsModel> fruitsModelList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.fruitsModelList = fruitsModelList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public FruitsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fruits,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FruitsAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(fruitsModelList.get(position).getImage());
        holder.title.setText(fruitsModelList.get(position).getTitle());

        holder.itemView.setOnClickListener(view -> {
            recyclerViewInterface.onViewClicked(view.getId(), holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return fruitsModelList.size();
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
