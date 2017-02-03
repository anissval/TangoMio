package com.valdiviezo.anahi.tangomio;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link FragmentTalleres.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link FragmentTalleres#newInstance} factory method to
// * create an instance of this fragment.
// */
public class FragmentTalleres extends Fragment {

    /**
     * The pager widget, which handles animation and allows swiping horizontally
     * to access previous and next pages.
     */
    ViewPager pager = null;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    MyFragmentPagerAdapter pagerAdapter;
    private List<Taller> dataTalleres;


    public FragmentTalleres() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_fragment_talleres, container, false);
        retrieveData();
        // Instantiate a ViewPager
        this.pager = (ViewPager) root.findViewById(R.id.talleres_pager);
        // Create an adapter with the fragments we show on the ViewPager
        pagerAdapter = new MyFragmentPagerAdapter(
                getActivity().getSupportFragmentManager());

        for(int i= 0; i<dataTalleres.size();i++){
            pagerAdapter.addFragment(ScreenSlidePageFragment.newInstance(dataTalleres.get(i).getUrlImage(),Integer.parseInt(dataTalleres.get(i).getIndex())));
        }
        this.pager.setAdapter(pagerAdapter);

        // Inflate the layout for this fragment
        return root;
    }

//    @Override
//    public void ons

    //recuperamos datos de talleres
    private void parseJsonData() throws IOException {
        AssetManager assetManager = getActivity().getAssets();
        InputStream inputStream;
        inputStream = assetManager.open("talleres.json");
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        Type listType = new TypeToken<List<Taller>>(){ }.getType();

        Gson gson = new Gson();
        dataTalleres = gson.fromJson(reader, listType);
    }

    private void retrieveData(){
        try {
            parseJsonData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
