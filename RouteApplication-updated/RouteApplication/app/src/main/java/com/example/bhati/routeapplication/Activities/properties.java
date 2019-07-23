package com.example.bhati.routeapplication.Activities;

import android.graphics.Color;

import com.google.firebase.database.snapshot.Index;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class properties
{
    public static JSONArray jsonArrayLocs  = new JSONArray();
    public static HashMap<Integer,String> locdata =  new HashMap<Integer, String>();
    //public static HashMap<Integer,String> colors =  new HashMap<Integer, String>();
    public static HashMap<String,String> colorstr =  new HashMap<String, String>();
    public static List<String> colorsdata = new ArrayList<String>();
    public static Double loclat=0.0;
    public static Double loclog=0.0;
    public static HashMap<String,String> audiodata =  new HashMap<String, String>();
    public static String Server_IP="192.168.43.205";
}
