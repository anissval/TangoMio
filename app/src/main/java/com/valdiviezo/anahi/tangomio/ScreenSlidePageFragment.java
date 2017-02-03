package com.valdiviezo.anahi.tangomio;

/**
 * Created by lbresca on 1/31/17.
 */

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ScreenSlidePageFragment extends Fragment {

    private ImageView imageViewEventos;

    /**
     * Key to insert the background color into the mapping of a Bundle.
     */
    private static final String URL_IMAGE = "_imageURL";

    /**
     * Key to insert the index page into the mapping of a Bundle.
     */
    private static final String INDEX = "index";

    private int color;
    private int index;
    private String imageUrl;

    /**
     * Instances a new fragment with a background color and an index page.
     *
     * @param color
     *            background color
     * @param index
     *            index page
     * @return a new page
     */
    public static ScreenSlidePageFragment newInstance(String imageUrl, int index) {

        // Instantiate a new fragment
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();

        // Save the parameters
        Bundle bundle = new Bundle();
        bundle.putString(URL_IMAGE, imageUrl);
        bundle.putInt(INDEX, index);
        fragment.setArguments(bundle);
        fragment.setRetainInstance(true);

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

        // Show the current page index in the view
        TextView tvIndex = (TextView) rootView.findViewById(R.id.tvIndex);
        tvIndex.setText(String.valueOf(this.index));
        imageViewEventos = (ImageView) rootView.findViewById(R.id.imageViewEventos);
        Picasso.with(getActivity()).load(imageUrl).into(imageViewEventos);

        return rootView;

    }
}