package com.example.chip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemSelectedListener, View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private List<Contacts> contacts=new ArrayList<>();
    private EditText UserInput;
    private ChipGroup mChipGroup;
    private Button mButton;
    private Button mButton2;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        UserInput=(EditText)findViewById(R.id.txtName);
        mChipGroup=(ChipGroup)findViewById(R.id.chipGroup);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        mButton=(Button)findViewById(R.id.button);
        mButton2=(Button)findViewById(R.id.removeButton);
        linearLayout=(LinearLayout)findViewById(R.id.contactList);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
            }
        });
        

        getContacts();
        recyclerAdapter=new RecyclerAdapter(this,contacts);
        recyclerView.setAdapter(recyclerAdapter);

        UserInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userInput=s.toString();
                List<Contacts> NewContacts=new ArrayList<>();
                for(Contacts contact: contacts){
                    if(contact.getProfileName().contains(userInput)){
                        NewContacts.add(contact);
                    }
                }

                recyclerAdapter=new RecyclerAdapter(MainActivity.this,NewContacts);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onItemSelected(Contacts contact) {
        Chip chip=new Chip(this);
        chip.setText(contact.getProfileName());
        chip.setChipIcon(ContextCompat.getDrawable(this,contact.getPicId()));
        chip.setCloseIconVisible(true);
        chip.setCheckable(false);
        chip.setClickable(false);
        chip.setOnCloseIconClickListener(this);
        mChipGroup.addView(chip);
        mChipGroup.setVisibility(View.VISIBLE);
    }

    private void getContacts(){
        List <String> Names= Arrays.asList(getResources().getStringArray(R.array.contact));
        int[] imageId={R.drawable.apoorva,R.drawable.gaurav,R.drawable.rahul,
                R.drawable.roshan,R.drawable.indra};
        int count=0;
        for(String name:Names){
            contacts.add(new Contacts(name,imageId[count]));
            count++;
        }
    }

    @Override
    public void onClick(View v) {
        Chip chip=(Chip)v;
        mChipGroup.removeView(chip);
    }
}
