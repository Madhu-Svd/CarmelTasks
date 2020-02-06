package com.carmel.guestjini;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.carmel.guestjini.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {
    CarouselView carouselView;
    ImageView rightArrowIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carouselView=findViewById(R.id.carouselView);
        final  int[] images=new int[]{
                R.drawable.landing_image,R.drawable.orange_plain_image,R.drawable.purple_plain_image,R.drawable.yellow_plain_image

        };
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(images[position]);
            }
        });
    }
}
