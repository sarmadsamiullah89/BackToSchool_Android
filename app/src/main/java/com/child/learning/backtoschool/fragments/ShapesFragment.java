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
import com.child.learning.backtoschool.adapter.ShapesAdapter;
import com.child.learning.backtoschool.models.ShapesModel;


import java.util.ArrayList;

public class ShapesFragment extends Fragment {

    public ShapesFragment() {
        // Required empty public constructor
    }
    ViewPager2 shapeVP;
    ArrayList<ShapesModel> shapesModelList;
    ShapesAdapter shapesAdapter;
    MediaPlayer mpCircle, mpSquare, mpTriangle, mpStar, mpRectangle, mpOval, mpDiamond, mpHexagon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shapes, container, false);
        shapeVP = view.findViewById(R.id.shapeVP);

        mpCircle = MediaPlayer.create(getContext(),R.raw.circle);
        mpSquare = MediaPlayer.create(getContext(),R.raw.square);
        mpTriangle = MediaPlayer.create(getContext(),R.raw.triangle);
        mpStar = MediaPlayer.create(getContext(),R.raw.star);
        mpRectangle = MediaPlayer.create(getContext(),R.raw.rectangle);
        mpOval = MediaPlayer.create(getContext(),R.raw.oval);
        mpDiamond = MediaPlayer.create(getContext(),R.raw.diamond);
        mpHexagon = MediaPlayer.create(getContext(),R.raw.hexagon);

        shapesModelList = new ArrayList<>();
        shapesModelList.add(new ShapesModel(R.drawable.circle,"Circle"));
        shapesModelList.add(new ShapesModel(R.drawable.square,"Square"));
        shapesModelList.add(new ShapesModel(R.drawable.triangle,"Triangle"));
        shapesModelList.add(new ShapesModel(R.drawable.star,"Star"));
        shapesModelList.add(new ShapesModel(R.drawable.rectangle,"Rectangle"));
        shapesModelList.add(new ShapesModel(R.drawable.oval,"Oval"));
        shapesModelList.add(new ShapesModel(R.drawable.diamond,"Diamond"));
        shapesModelList.add(new ShapesModel(R.drawable.hexagon,"Hexagon"));

        shapesAdapter = new ShapesAdapter(shapesModelList,getContext(), new RecyclerViewInterface() {
            @Override
            public void onViewClicked(int clickedViewId, int clickedItemPosition) {
                switch (clickedItemPosition){
                    case 0: mpCircle.start();break;
                    case 1: mpSquare.start();break;
                    case 2: mpTriangle.start();break;
                    case 3: mpStar.start();break;
                    case 4: mpRectangle.start();break;
                    case 5: mpOval.start();break;
                    case 6: mpDiamond.start();break;
                    case 7: mpHexagon.start();break;
                }
            }
        });
        shapeVP.setAdapter(shapesAdapter);
        shapeVP.setClipToPadding(false);
        shapeVP.setClipChildren(false);
        shapeVP.setOffscreenPageLimit(3);
        shapeVP.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(40));
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.15f);
            }
        });
        shapeVP.setPageTransformer(transformer);
        return view;
    }
}