package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    int colorzzz;

    public WordAdapter(Context context, ArrayList<Word> words, int z) {

        super(context, 0, words);
        colorzzz=z;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word  wor = getItem(position);
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView miwok = (TextView) listView.findViewById(R.id.miwok);
        miwok.setText(wor.getmMiwokTranslation());
        TextView eng = (TextView) listView.findViewById(R.id.text);
        eng.setText(wor.getDefaultTranslation());
        ImageView img = (ImageView) listView.findViewById(R.id.img);
        if (wor.hasImage()) {
            img.setImageResource(wor.getImageResourceID());
            img.setVisibility(View.VISIBLE);
        } else
            img.setVisibility(View.GONE);
        View textContainer=listView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),colorzzz);
        textContainer.setBackgroundColor(color);

        return listView;
    }
}