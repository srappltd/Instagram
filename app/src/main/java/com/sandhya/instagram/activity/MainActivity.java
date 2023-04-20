package com.sandhya.instagram.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sandhya.instagram.R;
import com.sandhya.instagram.databinding.ActivityMainBinding;
import com.sandhya.instagram.fragment.AccountFragment;
import com.sandhya.instagram.fragment.HomeFragment;
import com.sandhya.instagram.fragment.SearchFragment;
import com.sandhya.instagram.fragment.UploadFragment;
import com.sandhya.instagram.fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.btHome:
                        HomeFragment homeFragment = new HomeFragment();
                        selectedFragment(homeFragment);
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btSearch:
                        SearchFragment searchFragment = new SearchFragment();
                        selectedFragment(searchFragment);
                        Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btUpload:
                        UploadFragment uploadFragment = new UploadFragment();
                        selectedFragment(uploadFragment);
                        Toast.makeText(MainActivity.this, "Upload", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btVideo:
                        VideoFragment videoFragment = new VideoFragment();
                        selectedFragment(videoFragment);
                        Toast.makeText(MainActivity.this, "Video", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.btAccount:
                        AccountFragment accountFragment = new AccountFragment();
                        selectedFragment(accountFragment);
                        Toast.makeText(MainActivity.this, "Account", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }

        });
        binding.btNavigation.setSelectedItemId(R.id.btHome);
    }

    private void selectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

}