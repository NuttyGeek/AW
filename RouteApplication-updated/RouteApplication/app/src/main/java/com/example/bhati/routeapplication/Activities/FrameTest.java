package com.example.bhati.routeapplication.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhati.routeapplication.Pojo.FramesResult;
import com.example.bhati.routeapplication.R;
import com.example.bhati.routeapplication.helpers.FramesHelper;

import java.util.Random;

public class FrameTest extends AppCompatActivity {

    String videoUri;
    FramesHelper helper;
    ImageView image;
    Button extractButton, uploadButton;
    ProgressBar loading;
    TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_test);

        loading = findViewById(R.id.loading);
        answerText = findViewById(R.id.answer);
        loading.setVisibility(View.GONE);

        uploadButton = findViewById(R.id.upload);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading.setVisibility(View.VISIBLE);
                try{
                    int max = 15000;
                    int min = 7000;
                    final int random = new Random().nextInt((max - min) + 1) + min;
                    Thread.sleep(random);
                    loading.setVisibility(View.GONE);
                    Toast.makeText(FrameTest.this, "Done !", Toast.LENGTH_SHORT).show();

                    FramesResult res = helper.getFramesData();
                    String ans_str = " Car: "+res.getCar() + "\n"
                            +" Vegetation: "+res.getVegetation()+"\n"
                            +" Person: "+res.getPerson()+ "\n"
                            +" Snapshot: "+res.getSnpashot();
                    answerText.setText(ans_str);

                }catch (Exception e){
                    Toast.makeText(FrameTest.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        extractButton = findViewById(R.id.extract);
        extractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.extractAllFrames();
                extractButton.setEnabled(false);
            }
        });

        // init UI
        image = findViewById(R.id.image);
        // init helpers
        helper = new FramesHelper(this);
        // getting values from intent
        Intent i = getIntent();
        videoUri = i.getStringExtra("videoUri");
        Log.v("nuttygeek", videoUri);
        helper.setVideoPath(videoUri);
        // calling helper method
        //helper.getFrameFromVideo(videoUri, 10000, image);



        //Toast.makeText(this, "Length: "+helper.getLengthOfVideo(videoUri), Toast.LENGTH_SHORT).show();
    }

}
