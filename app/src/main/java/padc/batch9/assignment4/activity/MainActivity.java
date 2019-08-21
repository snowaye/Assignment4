package padc.batch9.assignment4.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import padc.batch9.assignment4.R;
import padc.batch9.assignment4.fragment.NearByFragment;
import padc.batch9.assignment4.fragment.AllFragment;
import padc.batch9.assignment4.fragment.PopularFragment;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    public static FragmentManager fragmentManager;

    BottomNavigationView bNavView;
    public static AppCompatTextView tvTitle;
    Toolbar toolbar;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new NearByFragment();
                    setTitle("Home");
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new PopularFragment();
                    setTitle("Search");
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    fragment = new AllFragment();
                    setTitle("Time");
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

        bNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initializeData() {
        fragmentManager = getSupportFragmentManager();
    }

    private void initializeUiComponent() {
        bNavView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        tvTitle = toolbar.findViewById(R.id.tv_title);
    }

    public static void loadFragment(Fragment fragment) {
        // load com.mytel.msg.fragment
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
