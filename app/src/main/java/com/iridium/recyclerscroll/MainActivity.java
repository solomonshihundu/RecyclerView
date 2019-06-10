package com.iridium.recyclerscroll;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends Activity {

    RecyclerView recyclerView;
    private ArrayList<String> imageNames;
    private ArrayList<String> imageURLs;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");


        // Initializing list view with the custom adapter
        imageNames = new ArrayList<String>();
        imageURLs = new ArrayList<String>();

        initImageBitmaps();

    }

    private void initImageBitmaps()
    {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        imageURLs.add( Integer.toString(R.drawable.lemon));
        imageNames.add("lemon");

        imageURLs.add(Integer.toString(R.drawable.beauty));
        imageNames.add("beauty");

        imageURLs.add(Integer.toString(R.drawable.breakfirst));
        imageNames.add("breakfirst");

        imageURLs.add(Integer.toString(R.drawable.broken));
        imageNames.add("broken");


        imageURLs.add(Integer.toString(R.drawable.camp));
        imageNames.add("camp");

        imageURLs.add(Integer.toString(R.drawable.city));
        imageNames.add("city");


        imageURLs.add(Integer.toString(R.drawable.dodge));
        imageNames.add("dodge");

        imageURLs.add(Integer.toString(R.drawable.mountain));
        imageNames.add("mountain");

        imageURLs.add(Integer.toString(R.drawable.train));
        imageNames.add("train");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MyAdapter adapter = new MyAdapter(this, imageNames, imageURLs);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
