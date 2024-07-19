package com.child.learning.backtoschool.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.RecyclerViewInterface;
import com.child.learning.backtoschool.adapter.FruitsAdapter;
import com.child.learning.backtoschool.models.FruitsModel;

import java.util.ArrayList;

public class FruitsFragment extends Fragment {

    public FruitsFragment() {
        // Required empty public constructor
    }

    ViewPager2 fruitsVP;
    ArrayList<FruitsModel> fruitsModelList;
    FruitsAdapter fruitsAdapter;
    MediaPlayer mpApple, mpBanana, mpGrapes, mpOrange, mpPineapple, mpStrawberry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruits, container, false);
        fruitsVP = view.findViewById(R.id.fruitsVP);

        mpApple = MediaPlayer.create(getContext(),R.raw.apple);
        mpBanana = MediaPlayer.create(getContext(),R.raw.banana);
        mpGrapes = MediaPlayer.create(getContext(),R.raw.grapes);
        mpOrange = MediaPlayer.create(getContext(),R.raw.orange);
        mpPineapple = MediaPlayer.create(getContext(),R.raw.pineapple);
        mpStrawberry = MediaPlayer.create(getContext(),R.raw.strawberry);

        fruitsModelList = new ArrayList<>();
        fruitsModelList.add(new FruitsModel(R.drawable.apple,"Apple"));
        fruitsModelList.add(new FruitsModel(R.drawable.banana,"Banana"));
        fruitsModelList.add(new FruitsModel(R.drawable.grapes,"Grapes"));
        fruitsModelList.add(new FruitsModel(R.drawable.orange,"Orange"));
        fruitsModelList.add(new FruitsModel(R.drawable.pineapple,"Pineapple"));
        fruitsModelList.add(new FruitsModel(R.drawable.strawberry,"Strawberry"));

        fruitsAdapter = new FruitsAdapter(getContext(), fruitsModelList, new RecyclerViewInterface() {
            @Override
            public void onViewClicked(int clickedViewId, int clickedItemPosition) {
                switch (clickedItemPosition){
                    case 0: mpApple.start(); break;
                    case 1: mpBanana.start(); break;
                    case 2: mpGrapes.start(); break;
                    case 3: mpOrange.start(); break;
                    case 4: mpPineapple.start(); break;
                    case 5: mpStrawberry.start(); break;
                }
            }
        });

        fruitsVP.setAdapter(fruitsAdapter);
        fruitsVP.setClipToPadding(false);
        fruitsVP.setClipChildren(false);
        fruitsVP.setOffscreenPageLimit(3);
        fruitsVP.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(40));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.15f);
            }
        });
        fruitsVP.setPageTransformer(transformer);
        return view;
    }
}