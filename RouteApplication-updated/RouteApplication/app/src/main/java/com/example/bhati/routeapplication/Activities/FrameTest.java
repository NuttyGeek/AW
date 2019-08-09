package com.example.bhati.routeapplication.Activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bhati.routeapplication.R;
import com.example.bhati.routeapplication.helpers.FramesHelper;

public class FrameTest extends AppCompatActivity {

    String videoUri;
    FramesHelper helper;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_test);

        // init UI
        image = findViewById(R.id.image);
        // init helpers
        helper = new FramesHelper(this);
        // getting values from intent
        Intent i = getIntent();
        videoUri = i.getStringExtra("videoUri");
        Log.v("nuttygeek", videoUri);
        // calling helper method
        helper.getFrameFromVideo(videoUri, 10000, image);


        //Toast.makeText(this, "Length: "+helper.getLengthOfVideo(videoUri), Toast.LENGTH_SHORT).show();
    }

}
