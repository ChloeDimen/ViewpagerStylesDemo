package com.coolweather.android.viewpagerstylesdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  mPagerSlidingTabStrip = (PagerSlidingTabStrip) findViewById(R.id.lay_pst);
        mViewPager = (ViewPager) findViewById(R.id.lay_viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.lay_pst);
        mViewPager.setAdapter(new pagerAdapter(getSupportFragmentManager(), this));
        mViewPager.setCurrentItem(0);
        // mPagerSlidingTabStrip.setViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        for (int i = 0; i < mTabLayout .getTabCount(); i++) {
            TabLayout.Tab tab=mTabLayout.getTabAt(i);
            tab.setCustomView(new pagerAdapter(getSupportFragmentManager(), this).getTabView(i));
        }
    }

    class pagerAdapter extends FragmentPagerAdapter {
        private String Titles[] = {"豆瓣", "发现", "讨论", "我的"};
        private int[] imageResId = {R.drawable.star_big_off, R.drawable.star_big_on
                , R.drawable.star_off, R.drawable.star_on};
        private Context mContext;

        public pagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.mContext = context;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return Titles[postion]第一次代码
            //第二次代码
           /* Drawable image =mContext.getResources().getDrawable(imageResId[position]);
            image.setBounds(0,0,image .getIntrinsicWidth(),image.getIntrinsicHeight());
            ImageSpan imageSpan =new ImageSpan(image,ImageSpan.ALIGN_BOTTOM) ;
            SpannableString sb=new SpannableString("  "+Titles[position]) ;
            sb.setSpan(imageSpan ,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/
            return null;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment pagerFragment;
            if (position == 0) {
                pagerFragment = new ListFragment();
            } else {
                pagerFragment = new PagerFragment();
            }
            Bundle bundle = new Bundle();
            // bundle.putInt("args", position);
            bundle.putString("args", Titles[position]);
            pagerFragment.setArguments(bundle);
            return pagerFragment;
        }

        @Override
        public int getCount() {
            return Titles.length;
        }

        public View getTabView(int position) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.tab_item, null);
            TextView textView = (TextView) view.findViewById(R.id.tab_tv);
            textView.setText(Titles[position]);
            ImageView imageView = (ImageView) view.findViewById(R.id.tab_iv);
            imageView.setImageResource(imageResId[position]);
            return view;
        }

    }
}
