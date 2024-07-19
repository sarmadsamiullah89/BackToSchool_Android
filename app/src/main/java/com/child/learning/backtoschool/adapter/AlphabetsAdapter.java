package com.child.learning.backtoschool.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.child.leaning.backtoschool.R;


public class AlphabetsAdapter extends RecyclerView.Adapter<AlphabetsAdapter.ViewHolder> {
    int[] images;

    public AlphabetsAdapter(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public AlphabetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.
                from(parent.getContext())
                .inflate(R.layout.item_alphabet,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlphabetsAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
