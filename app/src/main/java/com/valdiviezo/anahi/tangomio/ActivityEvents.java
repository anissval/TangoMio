package com.valdiviezo.anahi.tangomio;

/**
 * Created by lbresca on 1/31/17.
 */

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class ActivityEvents extends FragmentActivity {

    /**
     * The pager widget, which handles animation and allows swiping horizontally
     * to access previous and next pages.
     */
    ViewPager pager = null;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    MyFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        this.setContentView(R.layout.content_view_pager);

        // Instantiate a ViewPager
        this.pager = (ViewPager) this.findViewById(R.id.pager);

        // Create an adapter with the fragments we show on the ViewPager
        pagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager());
        pagerAdapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.colorPrimary), 0));
        pagerAdapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.colorAccent), 1));
        pagerAdapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.colorPrimaryDark), 2));
        pagerAdapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.colorPrimary), 3));
        pagerAdapter.addFragment(ScreenSlidePageFragment.newInstance(getResources()
                .getColor(R.color.colorAccent), 4));
        this.pager.setAdapter(pagerAdapter);

    }

    @Override
    public void onBackPressed() {

        // Return to previous page when we press back button
        if (this.pager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            this.pager.setCurrentItem(this.pager.getCurrentItem() - 1);

    }

}