package com.olugbadeshina.travelmantics.helper;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirebaseUtil {

    public static FirebaseDatabase firebaseDatabase;
    public static DatabaseReference databaseReference;
    public static FirebaseUtil firebaseUtil;
    public static ArrayList<TravelDeals> travelDeals;

    public FirebaseUtil() {

    }

    public static void openReference(String ref) {
        if (firebaseUtil == null) {
            firebaseUtil = new FirebaseUtil();
            firebaseDatabase = FirebaseDatabase.getInstance();
            travelDeals = new ArrayList<>();
        }

        //Gets the FireBaseDatabase path
        databaseReference = firebaseDatabase.getReference().child(ref);
    }
}
