package com.child.learning.backtoschool.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.child.leaning.backtoschool.R;
import com.child.learning.backtoschool.adapter.AlphabetsAdapter;


public class AlphabetsActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    int[] images = {
            R.drawable.as,
            R.drawable.bs,
            R.drawable.cs,
            R.drawable.ds,
            R.drawable.es,
            R.drawable.fs,
            R.drawable.gs,
            R.drawable.hs,
            R.drawable.is,
            R.drawable.js,
            R.drawable.ks,
            R.drawable.ls,
            R.drawable.ms,
            R.drawable.ns,
            R.drawable.os,
            R.drawable.ps,
            R.drawable.qs,
            R.drawable.rs,
            R.drawable.ss,
            R.drawable.ts,
            R.drawable.us,
            R.drawable.vs,
            R.drawable.ws,
            R.drawable.xs,
            R.drawable.ys,
            R.drawable.zs,
    };
    AlphabetsAdapter adapter;
    MediaPlayer mpA, mpB, mpC, mpD,mpE, mpF, mpG, mpH, mpI, mpJ, mpK, mpL, mpM, mpN,mpO,mpP,mpQ,mpR,mpS,mpT,mpU,mpV
            ,mpW,mpX,mpY,mpZ;
    int cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);

        viewPager2 = findViewById(R.id.viewPager2);
        adapter = new AlphabetsAdapter(images);

        mpA = MediaPlayer.create(AlphabetsActivity.this,R.raw.as);
        mpB = MediaPlayer.create(AlphabetsActivity.this,R.raw.bs);
        mpC = MediaPlayer.create(AlphabetsActivity.this,R.raw.cs);
        mpD = MediaPlayer.create(AlphabetsActivity.this,R.raw.ds);
        mpE = MediaPlayer.create(AlphabetsActivity.this,R.raw.es);
        mpF = MediaPlayer.create(AlphabetsActivity.this,R.raw.fs);
        mpG = MediaPlayer.create(AlphabetsActivity.this,R.raw.gs);
        mpH = MediaPlayer.create(AlphabetsActivity.this,R.raw.hs);
        mpI = MediaPlayer.create(AlphabetsActivity.this,R.raw.is);
        mpJ = MediaPlayer.create(AlphabetsActivity.this,R.raw.js);
        mpK = MediaPlayer.create(AlphabetsActivity.this,R.raw.ks);
        mpL = MediaPlayer.create(AlphabetsActivity.this,R.raw.ls);
        mpM = MediaPlayer.create(AlphabetsActivity.this,R.raw.ms);
        mpN = MediaPlayer.create(AlphabetsActivity.this,R.raw.ns);
        mpO = MediaPlayer.create(AlphabetsActivity.this,R.raw.os);
        mpP = MediaPlayer.create(AlphabetsActivity.this,R.raw.ps);
        mpQ = MediaPlayer.create(AlphabetsActivity.this,R.raw.qs);
        mpR = MediaPlayer.create(AlphabetsActivity.this,R.raw.rs);
        mpS = MediaPlayer.create(AlphabetsActivity.this,R.raw.ss);
        mpT = MediaPlayer.create(AlphabetsActivity.this,R.raw.ts);
        mpU = MediaPlayer.create(AlphabetsActivity.this,R.raw.us);
        mpV = MediaPlayer.create(AlphabetsActivity.this,R.raw.vs);
        mpW = MediaPlayer.create(AlphabetsActivity.this,R.raw.ws);
        mpX = MediaPlayer.create(AlphabetsActivity.this,R.raw.xs);
        mpY = MediaPlayer.create(AlphabetsActivity.this,R.raw.ys);
        mpZ = MediaPlayer.create(AlphabetsActivity.this,R.raw.zs);

        //adjust padding
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        //end blow shade off
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        //muber of items
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.setAdapter(adapter);

        CompositePageTransformer transformer = new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(40));     //set margin b/w pages
        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1 - Math.abs(position);
                page.setScaleY(0.95f + r*0.15f);
                page.setOnClickListener(view -> {
                    switch (cont){
                        case 1: mpA.start();break;
                        case 2: mpB.start();break;
                        case 3: mpC.start();break;
                        case 4: mpD.start();break;
                        case 5: mpE.start();break;
                        case 6: mpF.start();break;
                        case 7: mpG.start();break;
                        case 8: mpH.start();break;
                        case 9: mpI.start();break;
                        case 10: mpJ.start();break;
                        case 11: mpK.start();break;
                        case 12: mpL.start();break;
                        case 13: mpM.start();break;
                        case 14: mpN.start();break;
                        case 15: mpO.start();break;
                        case 16: mpP.start();break;
                        case 17: mpQ.start();break;
                        case 18: mpR.start();break;
                        case 19: mpS.start();break;
                        case 20: mpT.start();break;
                        case 21: mpU.start();break;
                        case 22: mpV.start();break;
                        case 23: mpW.start();break;
                        case 24: mpX.start();break;
                        case 25: mpY.start();break;
                        case 26: mpZ.start();break;
                    }
                });
            }
        });
        viewPager2.setPageTransformer(transformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0: cont =1; break;
                    case 1: cont =2; break;
                    case 2: cont =3; break;
                    case 3: cont =4; break;
                    case 4: cont =5; break;
                    case 5: cont =6; break;
                    case 6: cont =7; break;
                    case 7: cont =8; break;
                    case 8: cont =9; break;
                    case 9: cont =10; break;
                    case 10: cont =11; break;
                    case 11: cont =12; break;
                    case 12: cont =13; break;
                    case 13: cont =14; break;
                    case 14: cont =15; break;
                    case 15: cont =16; break;
                    case 16: cont =17; break;
                    case 17: cont =18; break;
                    case 18: cont =19; break;
                    case 19: cont =20; break;
                    case 20: cont =21; break;
                    case 21: cont =22; break;
                    case 22: cont =23; break;
                    case 23: cont =24; break;
                    case 24: cont =25; break;
                    case 25: cont =26; break;
                }
            }
        });
    }
}