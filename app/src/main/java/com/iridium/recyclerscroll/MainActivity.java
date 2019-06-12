package com.iridium.recyclerscroll;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

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
        imageURLs.add("https://www.pexels.com/photo/photo-of-vehicle-on-dirt-road-2291071/");
        imageNames.add("Savannah");

        imageURLs.add("https://www.pexels.com/photo/food-on-round-black-and-white-table-2381345/");
        imageNames.add("Health");

        imageURLs.add("https://www.pexels.com/photo/woman-leaning-beside-glass-fence-2380133/");
        imageNames.add("beauty");

        imageURLs.add("https://www.pexels.com/photo/man-standing-on-mountain-2406659/");
        imageNames.add("Mountain");

        imageURLs.add("https://www.pexels.com/photo/woman-behind-gold-paper-2388647/");
        imageNames.add("Flawless");

        imageURLs.add("https://www.pexels.com/photo/time-lapse-photography-of-river-2365455/");
        imageNames.add("Nature");


        imageURLs.add("https://www.pexels.com/photo/bride-and-groom-standing-next-to-a-tree-2364439/");
        imageNames.add("Marry me");

        imageURLs.add("https://www.pexels.com/photo/grayscale-photo-of-man-2427506/");
        imageNames.add("Strength");

        imageURLs.add("https://www.pexels.com/photo/photo-of-fox-sitting-on-ground-2295744/");
        imageNames.add("Fox");

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
