package com.software.mlc.tablayoutviewpager51;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //private android.support.design.widget.TabLayout mTabs;
    private TabLayout   mTabs;
    private ViewPager   mViewPager;
    private final int   viewItems = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTabs = (TabLayout) findViewById(R.id.tabs);
        mTabs.addTab(mTabs.newTab().setText("Tab 1"));
        mTabs.addTab(mTabs.newTab().setText("Tab 2"));
        mTabs.addTab(mTabs.newTab().setText("Tab 3"));

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));
    }

    class SamplePagerAdapter extends PagerAdapter
    {
        @Override
        public int getCount()
        {
            return viewItems;
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return (object == view);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return "Item " + (position+1);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            View    view = getLayoutInflater().inflate(R.layout.viewpager, container, false);
            container.addView(view);
            TextView title = (TextView)view.findViewById(R.id.item_title);
            title.setText(String.valueOf(position+1));
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            container.removeView((View) object);
        }
    }
}
