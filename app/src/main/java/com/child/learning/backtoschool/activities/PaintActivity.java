package com.child.learning.backtoschool.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.child.leaning.backtoschool.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.kyanogen.signatureview.SignatureView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import yuku.ambilwarna.AmbilWarnaDialog;

public class PaintActivity extends AppCompatActivity {

    ImageButton pBtnSave,pBtnColor,pBtnErazer,pBtnSize
            ,pBtnBrown,pBtnRed,pBtnOrange,pBtnYellow,pBtnGreen,pBtnSkyBlue
            ,pBtnBlue,pBtnPurple,pBtnWhite,pBtnBlack;
    TextView pTextSize;
    SignatureView signature_view;
    SeekBar pSeekbarSize;

    int defaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        //hide above toolBar
        getSupportActionBar().hide();

        pBtnSave = findViewById(R.id.pBtnSave);
        pBtnColor = findViewById(R.id.pBtnColor);
        pBtnErazer = findViewById(R.id.pBtnErazer);
        pBtnSize = findViewById(R.id.pBtnSize);
        pTextSize = findViewById(R.id.pTextSize);
        signature_view = findViewById(R.id.signature_view);
        pSeekbarSize = findViewById(R.id.pSeekbarSize);

        pBtnBrown = findViewById(R.id.pBtnBrown);
        pBtnRed = findViewById(R.id.pBtnRed);
        pBtnOrange = findViewById(R.id.pBtnOrange);
        pBtnYellow = findViewById(R.id.pBtnYellow);
        pBtnGreen = findViewById(R.id.pBtnGreen);
        pBtnSkyBlue = findViewById(R.id.pBtnSkyBlue);
        pBtnBlue = findViewById(R.id.pBtnBlue);
        pBtnPurple = findViewById(R.id.pBtnPurple);
        pBtnWhite = findViewById(R.id.pBtnWhite);
        pBtnBlack = findViewById(R.id.pBtnBlack);

        askPermission();

        //color work
        defaultColor = ContextCompat.getColor(PaintActivity.this,R.color.black);
        pBtnColor.setOnClickListener(view -> {
            AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(PaintActivity.this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                @Override
                public void onCancel(AmbilWarnaDialog dialog) {
                }

                @Override
                public void onOk(AmbilWarnaDialog dialog, int color) {
                    defaultColor = color;
                    signature_view.setPenColor(color);
                }
            });
            ambilWarnaDialog.show();
        });

        pBtnBrown.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.brown)));
        pBtnRed.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.red)));
        pBtnOrange.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.orange)));
        pBtnYellow.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.yellow)));
        pBtnGreen.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.green)));
        pBtnSkyBlue.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.skyBlue)));
        pBtnBlue.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.blue)));
        pBtnPurple.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.purple)));
        pBtnWhite.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.white)));
        pBtnBlack.setOnClickListener(view -> signature_view.setPenColor(ContextCompat.getColor(PaintActivity.this,R.color.black)));
        //clear all view
        pBtnErazer.setOnClickListener(view -> {
            signature_view.clearCanvas();
        });
        //brush size work
        pBtnSize.setOnClickListener(view -> {
            pSeekbarSize.setVisibility(View.VISIBLE);
            pBtnSize.setImageResource(R.drawable.brushsizecross);
            pSeekbarSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    pTextSize.setText(i+"dp");
                    signature_view.setPenSize(i);
                    seekBar.setMax(50);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        });
        pBtnSize.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                pSeekbarSize.setVisibility(View.INVISIBLE);
                pBtnSize.setImageResource(R.drawable.brushsize);
                return false;
            }
        });
        //save the painting
        pBtnSave.setOnClickListener(view -> {
            File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/BackToSchool/Paints");
            String date = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
            String filename = path+"/"+date+".png";

            if (!path.exists()){
                path.mkdirs();
            }

            File file = new File(filename);
            Bitmap bitmap = signature_view.getSignatureBitmap();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            bitmap.compress(Bitmap.CompressFormat.PNG,0,bos);
            byte[] bitMapData = bos.toByteArray();
            
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(bitMapData);
                fos.flush();
                fos.close();
                Toast.makeText(this, "Image is saved. Check BackToSchool folder", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Image not saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void askPermission() {
        Dexter.withContext(PaintActivity.this)
                .withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        Toast.makeText(PaintActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }
}