package com.valdiviezo.anahi.tangomio;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//
///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link FragmentEventos.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link FragmentEventos#newInstance} factory method to
// * create an instance of this fragment.
// */
public class FragmentEventos extends Fragment {


    /**
     * The pager widget, which handles animation and allows swiping horizontally
     * to access previous and next pages.
     */
    ViewPager pager = null;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    MyFragmentPagerAdapter pagerAdapter;


    public FragmentEventos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_fragment_eventos, container, false);
        // Instantiate a ViewPager
        this.pager = (ViewPager) root.findViewById(R.id.eventos_pager);

        // Create an adapter with the fragments we show on the ViewPager
        pagerAdapter = new MyFragmentPagerAdapter(
                getActivity().getSupportFragmentManager());
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

        // Inflate the layout for this fragment
        return root;
    }

//    @Override
//    public void ons



}
