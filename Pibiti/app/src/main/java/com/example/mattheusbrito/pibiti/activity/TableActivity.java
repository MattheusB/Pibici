package com.example.mattheusbrito.pibiti.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.mattheusbrito.pibiti.R;
import com.example.mattheusbrito.pibiti.release.Release;
import com.example.mattheusbrito.pibiti.release.ReleaseAdapter;
import com.example.mattheusbrito.pibiti.release.ReleaseSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TableActivity extends Activity {



    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseRef = database.getReference();



    private ReleaseAdapter releaseAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        releaseAdapter = new ReleaseAdapter(this);
        final ListView releasesView = (ListView) findViewById(R.id.releaseListID);
        releasesView.setAdapter(releaseAdapter);



        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ReleaseSet value = dataSnapshot.getValue(ReleaseSet.class);
                if (value != null){
                for (Release release:value.getLancamentos()){
                    releaseAdapter.add(release);
                    }
                }

                Log.d("key", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("key", "Failed to read value.", error.toException());
            }
        });



    }
}
