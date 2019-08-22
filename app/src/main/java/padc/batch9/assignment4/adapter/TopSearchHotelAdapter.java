package padc.batch9.assignment4.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import padc.batch9.assignment4.R;
import padc.batch9.assignment4.view.holder.TopSearchHolder;

public class TopSearchHotelAdapter extends RecyclerView.Adapter<TopSearchHolder> {
    @NonNull
    @Override
    public TopSearchHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.listitem_top_searches, viewGroup, false);
        return new TopSearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopSearchHolder topSearchHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
