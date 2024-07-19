package com.child.learning.backtoschool.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.activities.PaintActivity;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    CardView alphabetsC,colorsC,numbersC,shapesC,daysC,fruitsC,animalsC,paintC,poemsC;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        alphabetsC = view.findViewById(R.id.alphabetsC);
        colorsC = view.findViewById(R.id.colorsC);
        numbersC = view.findViewById(R.id.numbersC);
        shapesC = view.findViewById(R.id.shapesC);
        daysC = view.findViewById(R.id.daysC);
        fruitsC = view.findViewById(R.id.fruitsC);
        animalsC = view.findViewById(R.id.animalsC);
        paintC = view.findViewById(R.id.paintC);

        alphabetsC.setOnClickListener(view1 -> {
            AlphabetsFragment fragment = new AlphabetsFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main,fragment,null)
                    .addToBackStack(null) //this and above null is for the purpose that onBackPress go to HomeFragment
                    .commit();
        });
        colorsC.setOnClickListener(view1 -> {
            ColorsFragment fragment = new ColorsFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main,fragment,null)
                    .addToBackStack(null) //this and above null is for the purpose that onBackPress go to HomeFragment
                    .commit();
        });
        numbersC.setOnClickListener(view1 -> {
            NumbersFragment fragment = new NumbersFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main,fragment,null)
                    .addToBackStack(null) //this and above null is for the purpose that onBackPress go to HomeFragment
                    .commit();
        });
        shapesC.setOnClickListener(view1 -> {
            ShapesFragment fragment = new ShapesFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main,fragment,null)
                    .addToBackStack(null) //this and above null is for the purpose that onBackPress go to HomeFragment
                    .commit();
        });
        daysC.setOnClickListener(view1 -> {
            DaysFragment fragment = new DaysFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main,fragment,null)
                    .addToBackStack(null) //this and above null is for the purpose that onBackPress go to HomeFragment
                    .commit();
        });
        fruitsC.setOnClickListener(view1 -> {
            FruitsFragment fragment = new FruitsFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main,fragment,null)
                    .addToBackStack(null) //this and above null is for the purpose that onBackPress go to HomeFragment
                    .commit();
        });
        animalsC.setOnClickListener(view1 -> {
            AnimalsFragment fragment = new AnimalsFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main,fragment,null)
                    .addToBackStack(null) //this and above null is for the purpose that onBackPress go to HomeFragment
                    .commit();
        });
        paintC.setOnClickListener(view1 -> {
//            PaintFragment fragment = new PaintFragment();
//            getFragmentManager().beginTransaction()
//                    .replace(R.id.nav_host_fragment_content_main,fragment,null)
//                    .addToBackStack(null) //this and above null is for the purpose that onBackPress go to HomeFragment
//                    .commit();
            startActivity(new Intent(getContext(), PaintActivity.class));
        });

        return view;
    }
}