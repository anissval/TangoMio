package com.valdiviezo.anahi.tangomio;

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


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentTalleres() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTalleres.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTalleres newInstance(String param1, String param2) {
        FragmentTalleres fragment = new FragmentTalleres();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
