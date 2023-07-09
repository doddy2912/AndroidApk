package com.example.doddy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;

    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private MapsFragment mapsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom);
        toolbar = findViewById(R.id.top_navigation);
        setSupportActionBar(toolbar);

        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        mapsFragment = new MapsFragment();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.action_home:
                        selectedFragment = homeFragment;
                        break;
                    case R.id.action_profile:
                        selectedFragment = profileFragment;
                        break;
                    case R.id.action_maps:
                        selectedFragment = mapsFragment;
                        break;
                }

                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return true;
                }

                return false;
            }
        });
    }}
