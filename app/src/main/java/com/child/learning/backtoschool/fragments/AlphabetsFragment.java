package com.child.learning.backtoschool.fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.activities.AlphabetsActivity;

public class AlphabetsFragment extends Fragment {

    public AlphabetsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_alphabets, container, false);

        String alpha[] = new String[26];
        for (int i=0,j=65;i<26;i++,j++){
            alpha[i] = Character.toString((char) j);
        }

        GridView gv = view.findViewById(R.id.gv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1,alpha);
        gv.setAdapter(adapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String abc = alpha[i].toLowerCase();
                int mid = getResources().getIdentifier(abc,"raw",getActivity().getPackageName());
                MediaPlayer mp = MediaPlayer.create(getContext(),mid);
                mp.start();
            }
        });

        LinearLayout ll = view.findViewById(R.id.ll);
        ll.setOnClickListener(view1 -> {
            startActivity(new Intent(getContext(), AlphabetsActivity.class));
        });

        return view;
    }
}