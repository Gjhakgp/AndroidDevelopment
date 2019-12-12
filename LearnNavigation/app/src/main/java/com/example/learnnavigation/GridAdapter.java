package com.example.learnnavigation;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] numbers;
    private  int[] numberImage;

    public GridAdapter(Context c,String[] numbers, int[] numberImage){
        context=c;
        this.numbers=numbers;
        this.numberImage=numberImage;
    }

    @Override
    public int getCount() {
        return numbers.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView==null){
            convertView=inflater.inflate(R.layout.row_item,null);
        }

        ImageView imageView=convertView.findViewById(R.id.image_view);
        TextView textView=convertView.findViewById(R.id.text_view);
        imageView.setImageResource(numberImage[position]);
        textView.setText(numbers[position]);
        return convertView;
    }
}
