package com.example.farheen.galleryview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;


@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {


    //this image to be disaply
    Integer[] imageIDs = {
      R.drawable.ramadan1,R.drawable.ramadan2,R.drawable.ramadan3,R.drawable.ramadan4,R.drawable.ramadan5,R.drawable.ramadan6,R.drawable.ramadan7,R.drawable.ramadan8,R.drawable.ramadan9,R.drawable.ramadan10
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //the Gallery view is deprecated in android
        Gallery gallery = (Gallery) findViewById(R.id.gallery1);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent , View v, int position, long id) {
                Toast.makeText(getBaseContext(),"Ramadan" + (position + 1) + "selected",Toast.LENGTH_SHORT).show();
                //display image selected
                ImageView imageview = (ImageView) findViewById(R.id.image1);
                imageview.setImageResource(imageIDs[position]);


            }
        });

    }
    public class ImageAdapter extends BaseAdapter{
        private Context context;
        private  int iteamBackground;
        public ImageAdapter(Context c) {

            context =  c;
            //set a greay background;wrap around the images
            TypedArray a=obtainStyledAttributes(R.styleable.MyGallery);
            iteamBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground,0);
            a.recycle();

        }
        //return number of  image
        @Override
        public int getCount() {
            return imageIDs.length;
        }
        //return the Id of an item
        @Override
        public Object getItem(int position) {
            return position;
        }
       //return the id of an item
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View contentView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setImageResource(imageIDs[position]);
            imageview.setLayoutParams(new Gallery.LayoutParams(100, 100));
            imageview.setBackgroundResource(iteamBackground);
            return imageview;
        }
    }




}
