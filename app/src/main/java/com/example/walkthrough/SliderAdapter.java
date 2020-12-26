package com.example.walkthrough;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[]  slide_image={
      R.drawable.img1,R.drawable.img2,R.drawable.img3
    };

    public String[] slide_heading={"Accelerometer","Battery","GPU"};

    public String[] slide_body={"An accelerometer is an electromechanical device used to measure acceleration forces. Such forces may be static, like the continuous force of gravity or, as is the case with many mobile devices, dynamic to sense movement or vibrations. Acceleration is the measurement of the change in velocity, or speed divided by time."
            ,"Batteries are a collection of one or more cells whose chemical reactions create a flow of electrons in a circuit. All batteries are made up of three basic components: an anode (the '-' side), a cathode (the '+' side), and some kind of electrolyte (a substance that chemically reacts with the anode and cathode)."
            ,"A graphics processing unit (GPU) is a specialized, electronic circuit designed to rapidly manipulate and alter memory to accelerate the creation of images in a frame buffer intended for output to a display device."};

    @Override
    public int getCount() {
        return slide_image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);


        ImageView slideimage = (ImageView)view.findViewById(R.id.imageView);
        TextView text_head = (TextView)view.findViewById(R.id.text_head);
        TextView text_body = (TextView)view.findViewById(R.id.text_body);

        slideimage.setImageResource(slide_image[position]);

        text_head.setText(slide_heading[position]);
        text_body.setText(slide_body[position]);


    container.addView(view);
return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
