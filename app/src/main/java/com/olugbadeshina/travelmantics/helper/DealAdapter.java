package com.olugbadeshina.travelmantics.helper;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.olugbadeshina.travelmantics.R;

import java.util.ArrayList;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.DealViewHolder> {

    private FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;
    private FirebaseUtil firebaseUtil;
    public static ArrayList<TravelDeals> travelDeals;

    public DealAdapter() {
        FirebaseUtil.openReference("traveldeals");
        firebaseDatabase = FirebaseUtil.firebaseDatabase;
        databaseReference = FirebaseUtil.databaseReference;
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class DealViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        public DealViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.tvw_title);
        }

        public void bind(TravelDeals travelDeals) {
            txtTitle.setText(travelDeals.getTitle());
        }
    }
}
