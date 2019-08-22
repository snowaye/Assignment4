package padc.batch9.assignment4.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import padc.batch9.assignment4.R;
import padc.batch9.assignment4.adapter.HotelAdapter;

public class AllFragment extends Fragment {

    private String tag = getClass().getSimpleName();

    RecyclerView recvHotel;
    LinearLayoutManager manager;


    public AllFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby, null, false);
        initializeUiComponents(view);
        return view;
    }

    private void initializeUiComponents(View view) {
        recvHotel = view.findViewById(R.id.recv_hotel);
        manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recvHotel.setLayoutManager(manager);
        recvHotel.setAdapter(new HotelAdapter());
    }
}
