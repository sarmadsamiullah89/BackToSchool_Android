package com.child.learning.backtoschool.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.adapter.AnimalsAdapter;
import com.child.learning.backtoschool.models.AnimalsModel;

import java.util.ArrayList;

public class AnimalsFragment extends Fragment {

    public AnimalsFragment() {
        // Required empty public constructor
    }
    RecyclerView animalsRV;
    ImageView animalsImg;
    TextView animalsTitle;

    ArrayList<AnimalsModel> animalsModelList;
    AnimalsAdapter animalsAdapter;
    MediaPlayer mpBuffalo, mpCat, mpCobra, mpCock, mpCow, mpCricket, mpElephant, mpGorilla, mpGull
            , mpHorse, mpLion, mpMonkey, mpPeacock, mpPig, mpRedLori, mpRhino, mpTurkey, mpVulture, mpWolf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animals, container, false);
        animalsRV = view.findViewById(R.id.animalsRV);
        animalsImg = view.findViewById(R.id.animalsImg);
        animalsTitle = view.findViewById(R.id.animalsTitle);

        mpBuffalo = MediaPlayer.create(getContext(),R.raw.buffalo);
        mpCat = MediaPlayer.create(getContext(),R.raw.cat);
        mpCobra = MediaPlayer.create(getContext(),R.raw.cobra);
        mpCock = MediaPlayer.create(getContext(),R.raw.cock);
        mpCow = MediaPlayer.create(getContext(),R.raw.cow);
        mpCricket = MediaPlayer.create(getContext(),R.raw.crickets);
        mpElephant = MediaPlayer.create(getContext(),R.raw.elephant);
        mpGorilla = MediaPlayer.create(getContext(),R.raw.gorilla);
        mpGull = MediaPlayer.create(getContext(),R.raw.gull);
        mpHorse = MediaPlayer.create(getContext(),R.raw.horse);
        mpLion = MediaPlayer.create(getContext(),R.raw.lion);
        mpMonkey= MediaPlayer.create(getContext(),R.raw.monkey);
        mpPeacock = MediaPlayer.create(getContext(),R.raw.peacock);
        mpPig = MediaPlayer.create(getContext(),R.raw.pig);
        mpRedLori = MediaPlayer.create(getContext(),R.raw.redlori);
        mpRhino = MediaPlayer.create(getContext(),R.raw.rhino);
        mpTurkey = MediaPlayer.create(getContext(),R.raw.turkey);
        mpVulture = MediaPlayer.create(getContext(),R.raw.vulture);
        mpWolf = MediaPlayer.create(getContext(),R.raw.wolf);

        animalsModelList = new ArrayList<>();
        animalsModelList.add(new AnimalsModel(R.drawable.buffalo));
        animalsModelList.add(new AnimalsModel(R.drawable.cat));
        animalsModelList.add(new AnimalsModel(R.drawable.cobra));
        animalsModelList.add(new AnimalsModel(R.drawable.cock));
        animalsModelList.add(new AnimalsModel(R.drawable.cow));
        animalsModelList.add(new AnimalsModel(R.drawable.cricket));
        animalsModelList.add(new AnimalsModel(R.drawable.elephant));
        animalsModelList.add(new AnimalsModel(R.drawable.gorilla));
        animalsModelList.add(new AnimalsModel(R.drawable.gull));
        animalsModelList.add(new AnimalsModel(R.drawable.horse));
        animalsModelList.add(new AnimalsModel(R.drawable.lion));
        animalsModelList.add(new AnimalsModel(R.drawable.monkey));
        animalsModelList.add(new AnimalsModel(R.drawable.peacock));
        animalsModelList.add(new AnimalsModel(R.drawable.pig));
        animalsModelList.add(new AnimalsModel(R.drawable.redlori));
        animalsModelList.add(new AnimalsModel(R.drawable.rhino));
        animalsModelList.add(new AnimalsModel(R.drawable.turkey));
        animalsModelList.add(new AnimalsModel(R.drawable.vulture));
        animalsModelList.add(new AnimalsModel(R.drawable.wolf));

        animalsAdapter = new AnimalsAdapter(getContext(), animalsModelList, (clickedViewId, clickedItemPosition) -> {

            switch (clickedItemPosition)
            {
                case 0:
                    mpBuffalo.start(); animalsImg.setImageResource(R.drawable.buffalo);animalsTitle.setText("Buffalo");
                    break;
                case 1:
                    mpCat.start(); animalsImg.setImageResource(R.drawable.cat);animalsTitle.setText("Cat");
                    break;
                case 2:
                    mpCobra.start(); animalsImg.setImageResource(R.drawable.cobra);animalsTitle.setText("Cobra");
                    break;
                case 3:
                    mpCock.start(); animalsImg.setImageResource(R.drawable.cock);animalsTitle.setText("Cock");
                    break;
                case 4:
                    mpCow.start(); animalsImg.setImageResource(R.drawable.cow);animalsTitle.setText("Cow");
                    break;
                case 5:
                    mpCricket.start(); animalsImg.setImageResource(R.drawable.cricket);animalsTitle.setText("Cricket");
                    break;
                case 6:
                    mpElephant.start(); animalsImg.setImageResource(R.drawable.elephant);animalsTitle.setText("Elephant");
                    break;
                case 7:
                    mpGorilla.start(); animalsImg.setImageResource(R.drawable.gorilla);animalsTitle.setText("Gorilla");
                    break;
                case 8:
                    mpGull.start(); animalsImg.setImageResource(R.drawable.gull);animalsTitle.setText("Gull");
                    break;
                case 9:
                    mpHorse.start(); animalsImg.setImageResource(R.drawable.horse);animalsTitle.setText("Horse");
                    break;
                case 10:
                    mpLion.start(); animalsImg.setImageResource(R.drawable.lion);animalsTitle.setText("Lion");
                    break;
                case 11:
                    mpMonkey.start(); animalsImg.setImageResource(R.drawable.monkey);animalsTitle.setText("Monkey");
                    break;
                case 12:
                    mpPeacock.start(); animalsImg.setImageResource(R.drawable.peacock);animalsTitle.setText("Peacock");
                    break;
                case 13:
                    mpPig.start(); animalsImg.setImageResource(R.drawable.pig);animalsTitle.setText("Pig");
                    break;
                case 14:
                    mpRedLori.start(); animalsImg.setImageResource(R.drawable.redlori);animalsTitle.setText("Red Lori");
                    break;
                case 15:
                    mpRhino.start(); animalsImg.setImageResource(R.drawable.rhino);animalsTitle.setText("Rhino");
                    break;
                case 16:
                    mpTurkey.start(); animalsImg.setImageResource(R.drawable.turkey);animalsTitle.setText("Turkey");
                    break;
                case 17:
                    mpVulture.start(); animalsImg.setImageResource(R.drawable.vulture);animalsTitle.setText("Vulture");
                    break;
                case 18:
                    mpWolf.start(); animalsImg.setImageResource(R.drawable.wolf);animalsTitle.setText("Wolf");
                    break;
            }
        });
        animalsRV.setAdapter(animalsAdapter);

//        stopBtn.setOnClickListener(view1 -> {
//            if (mpBuffalo.isPlaying() || mpCat.isPlaying() || mpCobra.isPlaying() || mpCock.isPlaying() || mpCow.isPlaying() || mpCricket.isPlaying()
//                    || mpElephant.isPlaying() || mpGorilla.isPlaying() || mpGull.isPlaying() || mpHorse.isPlaying() || mpLion.isPlaying() ||
//                    mpMonkey.isPlaying() || mpPeacock.isPlaying() || mpPig.isPlaying() || mpRedLori.isPlaying() || mpRhino.isPlaying() || mpTurkey.isPlaying()
//                    || mpVulture.isPlaying() || mpWolf.isPlaying()){
//                mpBuffalo.stop(); mpCat.stop(); mpCobra.stop(); mpCock.stop(); mpCow.stop(); mpCricket.stop(); mpElephant.stop(); mpGorilla.stop(); mpGull.stop();
//                mpHorse.stop(); mpLion.stop(); mpMonkey.stop(); mpPeacock.stop(); mpPig.stop(); mpRedLori.stop(); mpRhino.stop(); mpTurkey.stop(); mpVulture.stop(); mpWolf.stop();
//            }
//        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mpBuffalo.release(); mpCat.release(); mpCobra.release(); mpCock.release(); mpCow.release(); mpCricket.release(); mpElephant.release();
        mpGorilla.release(); mpGull.release(); mpHorse.release(); mpLion.release(); mpMonkey.release(); mpPeacock.release(); mpPig.release();
        mpRedLori.release(); mpRhino.release(); mpTurkey.release(); mpVulture.release(); mpWolf.release();
    }
}