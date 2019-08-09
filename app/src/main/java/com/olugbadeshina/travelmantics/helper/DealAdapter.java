package com.olugbadeshina.travelmantics.helper;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.olugbadeshina.travelmantics.R;

import java.util.ArrayList;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.DealViewHolder> {

    private FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseReference;
    private FirebaseUtil firebaseUtil;
    public static ArrayList<TravelDeals> travelDeals;
    private ChildEventListener childListener;

    public DealAdapter() {
        FirebaseUtil.openReference("traveldeals");
        firebaseDatabase = FirebaseUtil.firebaseDatabase;
        databaseReference = FirebaseUtil.databaseReference;
        travelDeals = FirebaseUtil.travelDeals;   //To recreate the deals
        childListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                TravelDeals td = dataSnapshot.getValue(TravelDeals.class);
                Log.d("Deal: ", td.getTitle());
                td.setId(dataSnapshot.getKey());
                travelDeals.add(td);
                notifyItemInserted(travelDeals.size()-1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        databaseReference.addChildEventListener(childListener);
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler, parent, false);
        return new DealViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder holder, int position) {
        TravelDeals deals = travelDeals.get(position);
        holder.bind(deals);
    }

    @Override
    public int getItemCount() {
        return travelDeals.size();
    }

    class DealViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle;
        TextView txtDescription;
        TextView txtPrice;

        public DealViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.tvw_title);
            txtDescription = (TextView) itemView.findViewById(R.id.tvw_description);
            txtPrice = (TextView) itemView.findViewById(R.id.tvw_price);


        }

        public void bind(TravelDeals travelDeals) {
            txtTitle.setText(travelDeals.getTitle());
            txtDescription.setText(travelDeals.getDescription());
            txtPrice.setText(travelDeals.getPrice());
        }
    }
}
