package padc.batch9.assignment4.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import padc.batch9.assignment4.R;

public class FilteredFragment extends Fragment {

    private String tag = getClass().getSimpleName();

    public FilteredFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filtered, container, false);
        initializeUiComponent(view);
        return view;
    }

    private void initializeUiComponent(View view) {

    }
}
