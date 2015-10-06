package com.example.joseph.practiceapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;



/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlessFragment extends Fragment implements LoadFinished{

    private boolean working = false;
    private boolean queuedWork = false;
    private String str = "";

    public static HeadlessFragment newInstance()
    {
        HeadlessFragment output = new HeadlessFragment();
        Bundle bundle = new Bundle();
        output.setArguments(bundle);

        return output;
    }

    @Override
    public void onLoadFinished(String str){
        working = false;
        this.str = str;
        if(isAdded())
        {
            returnWork();
        }
        else queuedWork = true;

    }

    public void returnWork()
    {
        ((MainActivity) getActivity()).onLoadFinished(str);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(queuedWork) returnWork();
    }

    public boolean work(String str)
    {
        if(!working){
            working = true;
            new LoadingTask(this).execute();
            return true;
        }
        return false;
    }

    public HeadlessFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
}
