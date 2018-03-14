package edu.temple.lab6fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {

    private String[] colors;
    private Context context;
    private Resources res;
    private String[] colorLabels;

    public ColorAdapter(Context context, String[] colors, Resources resources) {
        this.colors = colors;
        this.context = context;
        this.res = resources;
        colorLabels = res.getStringArray(R.array.color_array);
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position){
        return colors[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setText(colors[i]);
        textView.setBackgroundColor(Color.parseColor(colors[i]));
        return textView;
    }
}