package padc.batch9.assignment4.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import padc.batch9.assignment4.R;
import padc.batch9.assignment4.fragment.FilteredFragment;
import padc.batch9.assignment4.fragment.HomeFragment;
import padc.batch9.assignment4.fragment.SavedFragment;
import padc.batch9.assignment4.fragment.SearchFragment;
import padc.batch9.assignment4.util.Utils;

public class MainActivity extends AppCompatActivity {

    private String[] navTitles;
    public static FragmentManager fragmentManager;
    BottomNavigationView bNavView;
    public static AppCompatTextView tvTitle;
    Toolbar toolbar;
    AppCompatImageView imgvProfile;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_search:
                    fragment = new SearchFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_filter:
                    fragment = new FilteredFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.nav_saved_hotel:
                    fragment = new SavedFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeData();
        initializeUiComponent();
        loadFragment(new HomeFragment());
        bNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initializeData() {
        fragmentManager = getSupportFragmentManager();
         navTitles = new String[] {
                getString(R.string.nav_title_home),
                getString(R.string.nav_title_search),
                getString(R.string.nav_title_filtered),
                getString(R.string.nav_title_saved)};
    }

    private void initializeUiComponent() {
        bNavView = findViewById(R.id.nav_view);
        Utils.setStatusBarColor(this, R.color.statusBarColor);
    }

    public static void loadFragment(Fragment fragment) {
        FragmentTransaction transaction;
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static void setTitle(String title) {
        tvTitle.setText(title);
    }

}
