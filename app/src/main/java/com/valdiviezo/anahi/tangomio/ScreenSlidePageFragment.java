package com.valdiviezo.anahi.tangomio;

/**
 * Created by lbresca on 1/31/17.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ScreenSlidePageFragment extends Fragment {

    private ImageView imageViewSlide;
    private ProgressBar loadingIndicatorSlide;

    private static final String URL_IMAGE = "_imageURL";
    private static final String INDEX = "index";
    private String imageUrl;


    public static ScreenSlidePageFragment newInstance(String imageUrl, int index) {
        // Instantiate a new fragment
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        // Save the parameters
        Bundle bundle = new Bundle();
        bundle.putString(URL_IMAGE, imageUrl);
        bundle.putInt(INDEX, index);
        fragment.setArguments(bundle);
        //fragment.setRetainInstance(true);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Load parameters when the initial creation of the fragment is done
        this.imageUrl = (getArguments() != null) ? getArguments().getString(
                URL_IMAGE) : null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        loadingIndicatorSlide = (ProgressBar) rootView.findViewById(R.id.loadingIndicatorSlide);
        loadingIndicatorSlide.setVisibility(View.VISIBLE);
        imageViewSlide = (ImageView) rootView.findViewById(R.id.imageViewSlide);
        Picasso.with(getActivity()).load(imageUrl).into(imageViewSlide, new Callback() {
            @Override
            public void onSuccess() {
                loadingIndicatorSlide.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });

        return rootView;

    }
}