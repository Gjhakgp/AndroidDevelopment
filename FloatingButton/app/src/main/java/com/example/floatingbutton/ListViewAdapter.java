package com.example.floatingbutton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ListViewAdapter extends ArrayAdapter <String> {
    Context context;
    String rTitle[];
    String rDescription[];

    public ListViewAdapter(Context c, String Title[],String Description[]){
        super(c,R.layout.row,R.id.textviewtitle,Title);
        this.context =c;
        this.rTitle =Title;
        this.rDescription=Description;
    }

    @Override
    public View getView(int position,@NonNull View convertview, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.row,parent,false);
        TextView myTitle=row.findViewById(R.id.textviewtitle);
        TextView myDescription=row.findViewById(R.id.textviewdescription);

        myTitle.setText(rTitle[position]);
        myDescription.setText(rDescription[position]);

        return row;
    }
}
