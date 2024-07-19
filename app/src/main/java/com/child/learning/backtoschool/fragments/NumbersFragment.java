package com.child.learning.backtoschool.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.RecyclerViewInterface;
import com.child.learning.backtoschool.adapter.NumbersAdapter;
import com.child.learning.backtoschool.models.NumbersModel;

import java.util.ArrayList;

public class NumbersFragment extends Fragment {

    RecyclerView numbersRV;
    ArrayList<NumbersModel> numbersModelList;
    NumbersAdapter numbersAdapter;
    MediaPlayer mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp15,mp16,mp17,mp18,mp19,mp20;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers,container,false);
        numbersRV = view.findViewById(R.id.numbersRV);

        numbersModelList = new ArrayList<>();
        numbersModelList.add(new NumbersModel("1"));
        numbersModelList.add(new NumbersModel("2"));
        numbersModelList.add(new NumbersModel("3"));
        numbersModelList.add(new NumbersModel("4"));
        numbersModelList.add(new NumbersModel("5"));
        numbersModelList.add(new NumbersModel("6"));
        numbersModelList.add(new NumbersModel("7"));
        numbersModelList.add(new NumbersModel("8"));
        numbersModelList.add(new NumbersModel("9"));
        numbersModelList.add(new NumbersModel("10"));
        numbersModelList.add(new NumbersModel("11"));
        numbersModelList.add(new NumbersModel("12"));
        numbersModelList.add(new NumbersModel("13"));
        numbersModelList.add(new NumbersModel("14"));
        numbersModelList.add(new NumbersModel("15"));
        numbersModelList.add(new NumbersModel("16"));
        numbersModelList.add(new NumbersModel("17"));
        numbersModelList.add(new NumbersModel("18"));
        numbersModelList.add(new NumbersModel("19"));
        numbersModelList.add(new NumbersModel("20"));

        mp1 = MediaPlayer.create(getContext(),R.raw.a01);
        mp2 = MediaPlayer.create(getContext(),R.raw.a02);
        mp3 = MediaPlayer.create(getContext(),R.raw.a03);
        mp4 = MediaPlayer.create(getContext(),R.raw.a04);
        mp5 = MediaPlayer.create(getContext(),R.raw.a05);
        mp6 = MediaPlayer.create(getContext(),R.raw.a06);
        mp7 = MediaPlayer.create(getContext(),R.raw.a07);
        mp8 = MediaPlayer.create(getContext(),R.raw.a08);
        mp9 = MediaPlayer.create(getContext(),R.raw.a09);
        mp10 = MediaPlayer.create(getContext(),R.raw.a10);
        mp11 = MediaPlayer.create(getContext(),R.raw.a11);
        mp12 = MediaPlayer.create(getContext(),R.raw.a12);
        mp13 = MediaPlayer.create(getContext(),R.raw.a13);
        mp14 = MediaPlayer.create(getContext(),R.raw.a14);
        mp15 = MediaPlayer.create(getContext(),R.raw.a15);
        mp16 = MediaPlayer.create(getContext(),R.raw.a16);
        mp17 = MediaPlayer.create(getContext(),R.raw.a17);
        mp18 = MediaPlayer.create(getContext(),R.raw.a18);
        mp19 = MediaPlayer.create(getContext(),R.raw.a19);
        mp20 = MediaPlayer.create(getContext(),R.raw.a20);

        numbersAdapter = new NumbersAdapter(numbersModelList, getContext(), new RecyclerViewInterface() {
            @Override
            public void onViewClicked(int clickedViewId, int clickedItemPosition) {
                switch (clickedItemPosition){
                    case 0: mp1.start();break;
                    case 1: mp2.start();break;
                    case 2: mp3.start();break;
                    case 3: mp4.start();break;
                    case 4: mp5.start();break;
                    case 5: mp6.start();break;
                    case 6: mp7.start();break;
                    case 7: mp8.start();break;
                    case 8: mp9.start();break;
                    case 9: mp10.start();break;
                    case 10: mp11.start();break;
                    case 11: mp12.start();break;
                    case 12: mp13.start();break;
                    case 13: mp14.start();break;
                    case 14: mp15.start();break;
                    case 15: mp16.start();break;
                    case 16: mp17.start();break;
                    case 17: mp18.start();break;
                    case 18: mp19.start();break;
                    case 19: mp20.start();break;
                }
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false);
        numbersRV.setLayoutManager(gridLayoutManager);
        numbersRV.setAdapter(numbersAdapter);
        return view;
    }
}