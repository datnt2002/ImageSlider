package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bdtopcoder.smart_slider.SliderAdapter;
import com.bdtopcoder.smart_slider.SliderItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.smartSlider);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.img1,"image 1"));
        sliderItems.add(new SliderItem(R.drawable.img2,"Image 2"));
        sliderItems.add(new SliderItem(R.drawable.img3,"Image 3"));

       viewPager2.setAdapter(new SliderAdapter(sliderItems,viewPager2,5000));

        new SliderAdapter((position, title, view) -> {
            Toast.makeText(this, "Position: "+position+" Title: "+title, Toast.LENGTH_SHORT).show();
        });
    }

    public void onPreviousButtonClick(View view) {
        int currentPos = viewPager2.getCurrentItem();
        if (currentPos > 0) {
            viewPager2.setCurrentItem(currentPos - 1);
        } else {
            viewPager2.setCurrentItem(viewPager2.getAdapter().getItemCount() - 1);
        }
    }

    public void onNextButtonClick(View view) {
        int currentPos = viewPager2.getCurrentItem();
        if (currentPos < viewPager2.getAdapter().getItemCount() - 1) {
            viewPager2.setCurrentItem(currentPos + 1);
        } else {
            viewPager2.setCurrentItem(0);
        }
    }
}