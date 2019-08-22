package padc.batch9.assignment4.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import padc.batch9.assignment4.R;
import padc.batch9.assignment4.activity.MainActivity;
import padc.batch9.assignment4.adapter.HomeFragmentPagerAdapter;

public class HomeFragment extends Fragment implements TabLayout.BaseOnTabSelectedListener {
    private String tag = getClass().getSimpleName();
    TabLayout tabLayout;
    ViewPager viewPager;
    HomeFragmentPagerAdapter adapter;
    AppCompatImageView imgvProfile;
    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initializeUiComponent(view);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        selectFirstTab();
        tabLayout.addOnTabSelectedListener(this);
        return view;
    }

    private void initializeUiComponent(View view) {
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewpager);
        viewPager.setSaveFromParentEnabled(false);
        imgvProfile = view.findViewById(R.id.imgv_profile);
        Glide.with(getContext())
                .load(R.drawable.img_profile)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_default_user)
                .error(R.drawable.ic_default_user)
                .into(imgvProfile);
    }

    private void initializeData() {

    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new HomeFragmentPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new NearByFragment(), "Nearby");
        adapter.addFragment(new PopularFragment(), "Popular");
        adapter.addFragment(new AllFragment(), "All");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
    }

    private void setupTabIcons() {
        View viewNearby = LayoutInflater.from(getContext()).inflate(R.layout.tab_home, null);
        AppCompatImageView imgvNearby =  viewNearby.findViewById(R.id.imgv_tab);
        AppCompatTextView tvNearby =  viewNearby.findViewById(R.id.tv_tab);
        tvNearby.setText("Nearby");
        tvNearby.setTextColor(ContextCompat.getColor(getContext(), R.color.tabTextColor));
        imgvNearby.setImageResource(R.drawable.ic_tab);
        imgvNearby.setVisibility(View.VISIBLE);

        View viewPopular = LayoutInflater.from(getContext()).inflate(R.layout.tab_home, null);
        AppCompatImageView imgvPopular =  viewPopular.findViewById(R.id.imgv_tab);
        AppCompatTextView tvPopular =  viewPopular.findViewById(R.id.tv_tab);
        tvPopular.setTextColor(ContextCompat.getColor(getContext(), R.color.tabTextColorLight));
        tvPopular.setText("Popular");
        imgvPopular.setVisibility(View.INVISIBLE);

        View viewAll = LayoutInflater.from(getContext()).inflate(R.layout.tab_home, null);
        AppCompatImageView imgvAll = viewAll.findViewById(R.id.imgv_tab);
        AppCompatTextView tvAll =  viewAll.findViewById(R.id.tv_tab);
        tvAll.setText("All");
        tvAll.setTextColor(ContextCompat.getColor(getContext(), R.color.tabTextColorLight));
        imgvAll.setVisibility(View.INVISIBLE);

        tabLayout.getTabAt(0).setCustomView(viewNearby);
        tabLayout.getTabAt(1).setCustomView(viewPopular);
        tabLayout.getTabAt(2).setCustomView(viewAll);
    }

    private void selectTab(TabLayout.Tab tab) {
        Log.i(tag, "selectTab="+tab.getPosition());
        View view = tab.getCustomView();
        AppCompatTextView tv  = view.findViewById(R.id.tv_tab);
        AppCompatImageView imgeView = view.findViewById(R.id.imgv_tab);
        String text = null;
        switch (tab.getPosition()) {
            case 0:
                text = "Nearby";
                break;
            case 1:
                text = "Popular";
                break;
            case 2:
                text = "All";
                break;
        }
        tv.setText(text);
        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.tabTextColor));
        imgeView.setVisibility(View.VISIBLE);
    }

    private void unselectTab(TabLayout.Tab tab) {
        Log.i(tag, "selectTab="+tab.getPosition());
        View view = tab.getCustomView();
        AppCompatTextView tv  = view.findViewById(R.id.tv_tab);
        AppCompatImageView imgeView = view.findViewById(R.id.imgv_tab);
        String text = null;
        switch (tab.getPosition()) {
            case 0:
                text = "Nearby";
                break;
            case 1:
                text = "Popular";
                break;
            case 2:
                text = "All";
                break;
        }
        tv.setText(text);
        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.tabTextColorLight));
        imgeView.setVisibility(View.INVISIBLE);
    }

    /**
     * This method is for selecting the first tab/page in case sometimes viewpager is not selecting the first page.
     */
    private void selectFirstTab() {
        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).select();
        View view = tabLayout.getTabAt(0).getCustomView();
        AppCompatImageView imgvTab = view.findViewById(R.id.imgv_tab);
        AppCompatTextView tvTab =  view.findViewById(R.id.tv_tab);
        tvTab.setText("Nearby");
        imgvTab.setImageResource(R.drawable.ic_tab);
        imgvTab.setVisibility(View.VISIBLE);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        selectTab(tab);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        unselectTab(tab);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
