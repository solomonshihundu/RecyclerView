package com.iridium.recyclerscroll;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class BitmapLoader
{
    private static final String TAG = "GalleryActivity";
    private Bitmap bitmap;
    ImageView imageView;
    String imageURL = "https://images.pexels.com/photos/2410203/pexels-photo-2410203.jpeg?auto=format%2Ccompress&cs=tinysrgb&dpr=2&h=650&w=940";

    public BitmapLoader(ImageView view)
    {
        Log.d(TAG, "onCreate: onCreate: Galley Activity Started.");
        imageView = view;
        new GetImageURL(imageView).execute(imageURL);

    }

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
            String imageURL = url[0];
            bitmap = null;

            try
            {
                InputStream myStream = new java.net.URL(imageURL).openStream();
                bitmap = BitmapFactory.decodeStream(myStream);
            }
            catch(IOException e)
            {
                e.printStackTrace();
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
