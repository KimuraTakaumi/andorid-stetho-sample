package com.hatenablog.techium.andorid_stetho_sample;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ClickManager {

    private static ClickManager sInstance = new ClickManager();

    private ArrayList<String> mHistory = new ArrayList<>();

    private ClickManager(){
    }

    public static ClickManager getInstance(){
        return sInstance;
    }

    public void click(){
        Date date = new Date();
        if(mHistory == null){
            mHistory = new ArrayList<>();
        }
        mHistory.add(date.toString());
    }

    public ArrayList<String> getHistory(){
        return mHistory;
    }

    public void clear(){
        mHistory.clear();
    }

}
