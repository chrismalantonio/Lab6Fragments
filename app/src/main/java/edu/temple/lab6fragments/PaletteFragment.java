package edu.temple.lab6fragments;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    ColorInterface parentActivity;
    View v;
    String[] colors = {"White", "Maroon", "Red", "Yellow", "Green", "Teal", "Blue", "Purple", "Fuchsia", "Grey"};
    private boolean isSpinnerInitial = false;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        parentActivity = (ColorInterface) context;
    }

    public PaletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_palette, container, false);

        Spinner spinner = v.findViewById(R.id.spinner);

        Resources res = getResources();
        ColorAdapter adapter = new ColorAdapter(getActivity(), colors, res);
        spinner.setAdapter(adapter);
        Log.d("Spinner initiated", "This is my spinner");
        spinner.setOnItemSelectedListener(this);


        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (isSpinnerInitial) {
            Log.d("Color", colors[i]);
            parentActivity.setColor(colors[i]);
        } else {
            isSpinnerInitial = true;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    interface ColorInterface {
        public void setColor(String color);
    }


}
