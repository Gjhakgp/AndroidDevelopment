package com.example.learnnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GridViewContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_content);
        Intent intent=getIntent();
        int position=intent.getIntExtra("gridValue",0);
        String data=Integer.toString(position);
        final NavController navController = Navigation.findNavController(this, R.id.gridviewfragment);
        if (position==0){
            navController.navigate(R.id.gridViewFirst);
        }
        else if (position ==1){
            NavOptions navOptions = new NavOptions.Builder()
                    .setPopUpTo(R.id.gridViewSecond, true)
                    .build();
            Toast.makeText(this, (String)data,
                    Toast.LENGTH_LONG).show();
            navController.navigate(R.id.action_first_to_second);
//            navController.navigate(R.id.gridViewSecond);
        }
        else if (position ==2){
            NavOptions navOptions = new NavOptions.Builder()
                    .setPopUpTo(R.id.gridViewThird, true)
                    .build();
            navController.navigate(R.id.action_first_to_third);
//            navController.navigate(R.id.gridViewThird);
        }
        else {
            NavOptions navOptions = new NavOptions.Builder()
                    .setPopUpTo(R.id.gridViewThird, true)
                    .build();
            navController.navigate(R.id.action_first_to_fourth);
//            navController.navigate(R.id.gridViewFourth);
        }
    }
}
