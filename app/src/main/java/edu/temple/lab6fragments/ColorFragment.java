package edu.temple.lab6fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    View colorView;
    public static final String COLOR_KEY = "color chosen";

    public static ColorFragment newInstance(String color){
        ColorFragment cFragment = new ColorFragment();

        Bundle bundle = new Bundle();
        bundle.putString(COLOR_KEY, color);

        cFragment.setArguments(bundle);

        return cFragment;
    }

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_color, container, false);
        colorView = v.findViewById(R.id.fragment2);

        Bundle bundle = getArguments();
        String color = bundle.getString(COLOR_KEY);
        setColorFrag(color);

        return v;
    }

    public void setColorFrag(String color){
       colorView.setBackgroundColor(Color.parseColor(color));

    }

}
