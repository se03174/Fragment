package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.fragment.FragmentPage1;
import com.example.fragment.FragmentPage2;
import com.example.fragment.FragmentPage3;
import com.example.fragment.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        bottomNavigationView = findViewById(R.id.nav_view); //처음화면

        getSupportFragmentManager().beginTransaction().add(R.id.content_layout, new Fragment()).commit(); //FrameLayout에 fragment.xml 띄우기
        // 바텀 네비게이션뷰 안의 아이템 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
                    case R.id.navigation_1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, new FragmentPage1()).commit();
                        break;
                    case R.id.navigation_2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, new FragmentPage2()).commit();
                        break;
                    case R.id.navigation_3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_layout, new FragmentPage3()).commit();

                        break;
                }
                return true;
            }
        });

    }
}





