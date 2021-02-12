package com.example.appwithbottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayDeque;
import java.util.Deque;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Deque<Integer> integerDeque = new ArrayDeque<>(3);
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        integerDeque.push(R.id.bn_home);
        loadFragment(new HomeFragment());
        bottomNavigationView.setSelectedItemId(R.id.bn_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        if (integerDeque.contains(id)) {
                            if (id == R.id.bn_home) {
                                if (integerDeque.size() != 1) {
                                    if (flag) {
                                        integerDeque.addFirst(R.id.bn_home);
                                        flag = false;
                                    }
                                }
                            }
                            integerDeque.remove(id);
                        }
                        integerDeque.push(id);
                        loadFragment(getFragment(item.getItemId()));
                        return true;
                    }
                }
        );
    }

    private Fragment getFragment(int itemId) {
        switch (itemId) {
            case R.id.bn_dashboard:
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                return new DashboardFragment();
            case R.id.bn_home:
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                return new HomeFragment();
            case R.id.bn_notification:
                bottomNavigationView.getMenu().getItem(2).setCheckable(true);
                return new NotificationFragment();
        }

        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        return new HomeFragment();
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, fragment, fragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        integerDeque.pop();
        if (!integerDeque.isEmpty()) {
            loadFragment(getFragment(integerDeque.peek()));
        } else {
            finish();
        }
    }
}