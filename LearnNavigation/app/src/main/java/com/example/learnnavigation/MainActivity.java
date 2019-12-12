package com.example.learnnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import com.example.learnnavigation.First;
import android.os.Bundle;

//import static com.example.learnnavigation.R.*;

public class MainActivity extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//
//    final NavController nav = Navigation.findNavController(this, R.id.nav_host_fragment);
//    nav.navigate(R.id.action_first_to_second);
//    Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.action_first_to_second);
}
