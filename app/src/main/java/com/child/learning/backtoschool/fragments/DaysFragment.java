package com.child.learning.backtoschool.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.RecyclerViewInterface;
import com.child.learning.backtoschool.adapter.DaysAdapter;
import com.child.learning.backtoschool.models.DaysModel;

import java.util.ArrayList;

public class DaysFragment extends Fragment {

    public DaysFragment() {
        // Required empty public constructor
    }

    RecyclerView daysRV;
    ArrayList<DaysModel> daysModelList;
    DaysAdapter daysAdapter;
    MediaPlayer mpSunday, mpMonday, mpTuesday, mpWednesday, mpThursday, mpFriday, mpSaturday;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_days, container, false);
        daysRV = view.findViewById(R.id.daysRV);

        mpSunday = MediaPlayer.create(getContext(),R.raw.sunday);
        mpMonday = MediaPlayer.create(getContext(),R.raw.monday);
        mpTuesday = MediaPlayer.create(getContext(),R.raw.tuesday);
        mpWednesday = MediaPlayer.create(getContext(),R.raw.wednesday);
        mpThursday = MediaPlayer.create(getContext(),R.raw.thursday);
        mpFriday = MediaPlayer.create(getContext(),R.raw.friday);
        mpSaturday = MediaPlayer.create(getContext(),R.raw.saturday);

        daysModelList = new ArrayList<>();
        daysModelList.add(new DaysModel(R.drawable.sunday));
        daysModelList.add(new DaysModel(R.drawable.monday));
        daysModelList.add(new DaysModel(R.drawable.tuesday));
        daysModelList.add(new DaysModel(R.drawable.wednesday));
        daysModelList.add(new DaysModel(R.drawable.thursday));
        daysModelList.add(new DaysModel(R.drawable.friday));
        daysModelList.add(new DaysModel(R.drawable.saturday));

        daysAdapter = new DaysAdapter(getContext(), daysModelList, new RecyclerViewInterface() {
            @Override
            public void onViewClicked(int clickedViewId, int clickedItemPosition) {
                switch (clickedItemPosition){
                    case 0: mpSunday.start();break;
                    case 1: mpMonday.start();break;
                    case 2: mpTuesday.start();break;
                    case 3: mpWednesday.start();break;
                    case 4: mpThursday.start();break;
                    case 5: mpFriday.start();break;
                    case 6: mpSaturday.start();break;
                }
            }
        });
        daysRV.setAdapter(daysAdapter);
        return view;
    }
}