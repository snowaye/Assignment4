package padc.batch9.assignment4.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import padc.batch9.assignment4.R;
import padc.batch9.assignment4.view.holder.HotelViewHolder;

public class HotelAdapter extends RecyclerView.Adapter<HotelViewHolder> {
    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.listitem_hotel, null, false);
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
