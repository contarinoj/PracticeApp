package com.example.joseph.practiceapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PracticeFragment extends Fragment {

    //Wrong Idea
    private static int count = 0;
    private static final String BASE_ID = "practice_fragment_";
    public final String ID;

    public static PracticeFragment newInstance(int i, String str)
    {
        PracticeFragment output = new PracticeFragment();

        Bundle bundle = new Bundle();

        bundle.putInt("whatever_i_is_for", i);
        bundle.putString(output.ID, str);

        output.setArguments(bundle);

        return output;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null) {

        }
    }

    public PracticeFragment() {
        ID = BASE_ID + count++;

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practice, container, false);
    }


}
