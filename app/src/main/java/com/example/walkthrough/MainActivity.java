package com.example.walkthrough;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout navLayout;

    private TextView[] dots;

    private TextView tv;

    private Button prevbut, nextbut;

    int curpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slideViewPager = (ViewPager)findViewById(R.id.slideViewPager);
        navLayout = (LinearLayout)findViewById(R.id.navLayout);
        tv = findViewById(R.id.slidenum);
        prevbut = findViewById(R.id.prevBut);
        nextbut = findViewById(R.id.nextBut);

        SliderAdapter sliderAdapter = new SliderAdapter(this);
        slideViewPager.setAdapter(sliderAdapter);
        tv.setText("1/3");

//        addDotsIndicator(0);
        slideViewPager.addOnPageChangeListener(viewlis);


        nextbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nextbut.getText().equals("Next")) {
                    slideViewPager.setCurrentItem(curpage + 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Finished", Toast.LENGTH_LONG).show();
                }
            }
        });


        prevbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideViewPager.setCurrentItem(curpage-1);
            }
        });

    }

//    @SuppressLint("ResourceAsColor")
    public void addDotsIndicator(int position){

        System.out.println("Dot added");
        dots = new TextView[3];

        for (int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorPrimary, getTheme().getResources().newTheme()));

            navLayout.addView(dots[i]);
            System.out.println("real dot");
        }

        if(dots.length>0){
                dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark, getTheme().getResources().newTheme()));
        }

    }


    ViewPager.OnPageChangeListener viewlis = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
//                addDotsIndicator(position);
            tv.setText((position+1)+"/3");
            curpage=position;

            if(position==0){
                prevbut.setEnabled(false);
                nextbut.setEnabled(true);
                prevbut.setVisibility(View.INVISIBLE);

                prevbut.setText("");
                nextbut.setText("Next");
            }
            else if(position==2){
                prevbut.setEnabled(true);
                nextbut.setEnabled(true);
                prevbut.setVisibility(View.VISIBLE);

                prevbut.setText("Back");
                nextbut.setText("Finish");
            }

            else{
                prevbut.setEnabled(true);
                nextbut.setEnabled(true);
                prevbut.setVisibility(View.VISIBLE);

                prevbut.setText("Back");
                nextbut.setText("Next");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}