package com.example.bhati.routeapplication.helpers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bhati.routeapplication.R;

public class AudioChunkDialog {

    Context context;

    /**
     * constructor fo the class
     * @param context context of the activity from where it is being called
     */
    public AudioChunkDialog(Context context){
        this.context = context;
    }

    public void showDialog(String msg){
//      creating dialog
        Dialog dialog = new Dialog(this.context);
        dialog.setContentView(R.layout.audio_chunk_dialog);
        dialog.setTitle("Audio Chunk ");
//      setting message in dialog
        TextView message = dialog.findViewById(R.id.message);
        message.setText(msg);
//      setting click listeners on buttons
        Button dismissButton  = dialog.findViewById(R.id.cancel);
        Button keywordButton = dialog.findViewById(R.id.keyword);
//      adding keyword button functionality
        keywordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Functionality not yet added !", Toast.LENGTH_SHORT).show();
            }
        });
//        adding dismiss button functionality
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
//      showing the dialog
        dialog.show();
    }

    public void dissmis(){

    }



}
