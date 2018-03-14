package edu.temple.lab6fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ColorInterface{

    ColorFragment colorFragment;
    String[] colors = {"White", "Maroon", "Red", "Yellow", "Green", "Teal", "Blue", "Purple", "Fuchsia", "Grey"};
    String colorSelected;
    boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        twoPanes = !(findViewById(R.id.container2) == null);
        //colorFragment = ColorFragment.newInstance("White");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container1, new PaletteFragment())
                .addToBackStack(null)
                .commit();

        if (twoPanes) {
            colorFragment = ColorFragment.newInstance("White");
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container2, colorFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void setColor(String color) {
        colorFragment = ColorFragment.newInstance(color);
        if (!twoPanes) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container1, colorFragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container2, colorFragment)
                    .addToBackStack(null)
                    .commit();
        }

    }
}
