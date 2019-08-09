package com.example.bhati.routeapplication.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bhati.routeapplication.Activities.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * this class is a helper for extracting frames from video
 */
public class FramesHelper {

    private Context context;
    private MediaMetadataRetriever metadataRetriever;
    // frame interval
    private int REGULAR_FRAME_INTERVAL;

    public FramesHelper(Context context){
        this.context = context;
        metadataRetriever = new MediaMetadataRetriever();
        REGULAR_FRAME_INTERVAL = properties.REGULAR_FRAME_INTERVAL_MILLIS;
    }

    public void getFrameFromVideo(String path, long time, ImageView imageView){
        // removing file:// from the path
        String[] paths =  path.split("file://");
        Log.v("nuttygeek", "[Splited String]: "+paths[1]);
        // setting path of video file
        metadataRetriever.setDataSource(paths[1]);
        String lengthOfVideo = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        // getting image from video at particular image
        Bitmap image = metadataRetriever.getFrameAtTime(2000, MediaMetadataRetriever.OPTION_CLOSEST);
        String dirPath = "/RouteApp/frames/"+getFileNameFromUri(path).replace(".mp4", "");
        String fileName = "1.jpg";
        saveBitmapToStorage(image, dirPath, fileName);
    }



    /**
     * this fxn converts the bitmap into JPEg and save it to the given path
     * @param image  bitmap image
     * @param dirPath absolute path to save it on
     * @param fileName name of the file to create
     */
    public void saveBitmapToStorage(Bitmap image,String dirPath, String fileName){
        // root path of external storage
        String root = Environment.getExternalStorageDirectory().toString();
        // creating file
        File dirFile = new File(root+dirPath);
        // create the directory
        dirFile.mkdirs();
        // creating file
        File file = new File(dirFile,fileName);
        // converting bitmap to jpeg
        try {
            if(file.exists()){
                Log.v("nuttygeek", "File already present ! Deleting File");
                file.delete();
            }
            FileOutputStream out = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
            Toast.makeText(context, "File Created !", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("nuttygeek", e.toString());
            Toast.makeText(context, "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * this function returns the file name from the video Uri
     * @param fileUri file URI
     * @return filename
     */
    public String getFileNameFromUri(String fileUri){
        return fileUri.split("/RouteApp/")[1];
    }

    public void getLengthOfVideo(String videoUri){
        String[] paths =  videoUri.split("file://");
        String path = paths[1];
        metadataRetriever.setDataSource(path);
        String length = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        Log.v("nuttygeek", "Length of Video: "+length);
    }

//    public int[] getListOfIntervalTime(long ){
//
//    }


}
