package com.example.joseph.practiceapp;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

/**
 * Created by Joseph on 2015-09-27. shhhhh
 */
public class LoadingTask extends AsyncTask<Void, Void, String>{
    private WeakReference<LoadFinished> weak;
    public LoadingTask(LoadFinished loadFinished){
        weak = new WeakReference<>(loadFinished);
    }
    @Override
    protected String doInBackground(Void... params) {
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            return "Whoops!";
        }
        return "Done!";
    }

    @Override
    protected void onPostExecute(String str) {
        super.onPostExecute(str);
        LoadFinished uhh = weak.get();
        if(uhh != null)
            uhh.onLoadFinished(str);
    }
}
