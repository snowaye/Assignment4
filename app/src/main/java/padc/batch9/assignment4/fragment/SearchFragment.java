package padc.batch9.assignment4.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.chip.Chip;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import padc.batch9.assignment4.R;
import padc.batch9.assignment4.adapter.TopSearchHotelAdapter;

public class SearchFragment extends Fragment {

    private String tag = getClass().getSimpleName();

    RecyclerView recvTopSearch, recvRecentSearch;
    LinearLayoutManager managerTopSearch, managerRecentSearch;
    private BottomSheetBehavior sheetBehavior;
    private CardView bottom_sheet;
    Chip chipFilter;


    public SearchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        initializeUiComponents(view);
        chipFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
        return view;
    }

    private void initializeUiComponents(View view) {
        recvTopSearch = view.findViewById(R.id.recv_top_search);
        recvRecentSearch = view.findViewById(R.id.recv_recent_search);
        managerTopSearch = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        managerRecentSearch = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recvTopSearch.setLayoutManager(managerTopSearch);
        recvRecentSearch.setLayoutManager(managerRecentSearch);
        recvTopSearch.setAdapter(new TopSearchHotelAdapter());
        recvRecentSearch.setAdapter(new TopSearchHotelAdapter());
        bottom_sheet = view.findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        chipFilter = view.findViewById(R.id.chip_Filter);
    }
}
