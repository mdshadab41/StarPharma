package com.example.starpharma.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.starpharma.R;

public class SliderAdapter extends PagerAdapter {

    Context context;

    int images[] = {

            R.drawable.slide_image,
            R.drawable.slide_image_2,
            R.drawable.slide_image_3

    };

    int headings[] = {

            R.string.heading_one,
            R.string.heading_two,
            R.string.heading_three
    };

    public SliderAdapter(Context context) {
        this.context = context;
    }


    // Returns the number of pages to be displayed in the ViewPager.
    @Override
    public int getCount() {
        return headings.length;
    }

    // Returns true if a particular object (page) is from a particular page
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_item,container,false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        TextView slideHeading = (TextView) view.findViewById(R.id.texttitle);

        slidetitleimage.setImageResource(images[position]);
        slideHeading.setText(headings[position]);

        container.addView(view);

        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }
}
