package com.iridium.recyclerscroll;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageNames;
    private ArrayList<String> mImages;
    private Context mContext;
    private BitmapLoader myLoader;
    private Bitmap bitmap;
    private ImageView image;
    private int imgPos;

    public MyAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images ) {
        mImageNames = imageNames;
        mImages = images;
        mContext = context;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_element, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        Log.d(TAG, "onBindViewHolder: called.");
        imgPos = position;

        /*
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(mImages.get(position))
                .error(mImages.get(position));
*/
/*
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);
*/

       new GetImageURL(image).execute(mImages.get(position));
        holder.imageName.setText(mImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));
                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();

          //      toNextActivity(MyGallery.class);
/*
                Intent intent = new Intent(mContext, MyGallery.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mImageNames.get(position));
                mContext.startActivity(intent);
*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView)
        {
            super(itemView);
            image = itemView.findViewById(R.id.mainDisplay);
            imageName = itemView.findViewById(R.id.houseName);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    /*





     */
    public class GetImageURL extends AsyncTask<String,Void, Bitmap>
    {
        ImageView myView;

        public GetImageURL(ImageView viewImage)
        {
            this.myView = viewImage;

        }

        @Override
        protected Bitmap doInBackground(String... url)
        {
            String imageURL = mImages.get(imgPos);
            bitmap = null;

            try
            {
                InputStream myStream = new java.net.URL(imageURL).openStream();

                if(myStream != null)
                {
                    bitmap = BitmapFactory.decodeStream(myStream);
                    if(bitmap == null)
                    {
                        Log.d(TAG,"BITMAP IS EMPTY");
                    }
                }

            }
            catch(IOException e)
            {
                e.printStackTrace();
                System.out.println("THIS FILE IS NOT AVAILABLE");
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap)
        {
            super.onPostExecute(bitmap);
            myView.setImageBitmap(bitmap);
        }
    }

}




