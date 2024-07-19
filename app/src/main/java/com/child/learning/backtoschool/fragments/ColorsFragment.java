package com.child.learning.backtoschool.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.RecyclerViewInterface;
import com.child.learning.backtoschool.adapter.ColorsAdapter;
import com.child.learning.backtoschool.models.ColorsModel;


import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ColorsFragment extends Fragment {

    RecyclerView clrRV;
    ArrayList<ColorsModel> colorsModelList;
    ColorsAdapter colorsAdapter;

    MediaPlayer mpRed,mpGreen,mpPurple,mpBlue,mpPink,mpYellow,mpOrange,mpBrown,mpBlack,mpWhite;
    public ColorsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_colors, container, false);
        clrRV = view.findViewById(R.id.clrRV);

        mpRed = MediaPlayer.create(getContext(),R.raw.red1);
        mpGreen = MediaPlayer.create(getContext(),R.raw.green1);
        mpPurple = MediaPlayer.create(getContext(),R.raw.purple1);
        mpBlue = MediaPlayer.create(getContext(),R.raw.blue1);
        mpPink = MediaPlayer.create(getContext(),R.raw.pink1);
        mpYellow = MediaPlayer.create(getContext(),R.raw.yellow1);
        mpOrange = MediaPlayer.create(getContext(),R.raw.orange1);
        mpBrown = MediaPlayer.create(getContext(),R.raw.brown1);
        mpBlack = MediaPlayer.create(getContext(),R.raw.black1);
        mpWhite = MediaPlayer.create(getContext(),R.raw.white1);

        colorsModelList = new ArrayList<>();
        colorsModelList.add(new ColorsModel(R.drawable.red1,"Red"));
        colorsModelList.add(new ColorsModel(R.drawable.green1,"Green"));
        colorsModelList.add(new ColorsModel(R.drawable.purple1,"Purple"));
        colorsModelList.add(new ColorsModel(R.drawable.blue1,"Blue"));
        colorsModelList.add(new ColorsModel(R.drawable.pink1,"Pink"));
        colorsModelList.add(new ColorsModel(R.drawable.yellow1,"Yellow"));
        colorsModelList.add(new ColorsModel(R.drawable.orange1,"Orange"));
        colorsModelList.add(new ColorsModel(R.drawable.brown1,"Brown"));
        colorsModelList.add(new ColorsModel(R.drawable.black1,"Black"));
        colorsModelList.add(new ColorsModel(R.drawable.white1,"White"));

        colorsAdapter = new ColorsAdapter(colorsModelList, getContext(), new RecyclerViewInterface() {
            @Override
            public void onViewClicked(int clickedViewId, int clickedItemPosition) {
                switch (clickedItemPosition){

                    case 0: mpRed.start(); break;
                    case 1: mpGreen.start(); break;
                    case 2: mpPurple.start(); break;
                    case 3: mpBlue.start(); break;
                    case 4: mpPink.start(); break;
                    case 5: mpYellow.start(); break;
                    case 6: mpOrange.start(); break;
                    case 7: mpBrown.start(); break;
                    case 8: mpBlack.start(); break;
                    case 9: mpWhite.start(); break;
                }
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
        clrRV.setLayoutManager(gridLayoutManager);
        clrRV.setAdapter(colorsAdapter);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mpBlue.release();
        mpGreen.release();
        mpPink.release();
        mpPurple.release();
        mpWhite.release();
        mpRed.release();
        mpYellow.release();
        mpWhite.release();
        mpBrown.release();
        mpOrange.release();
    }
}