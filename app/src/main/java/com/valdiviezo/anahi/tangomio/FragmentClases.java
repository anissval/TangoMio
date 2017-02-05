package com.valdiviezo.anahi.tangomio;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.valdiviezo.anahi.tangomio.Helper.RecyclerTouchListener;
import com.valdiviezo.anahi.tangomio.Helper.SeparatorDecoration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;


public class FragmentClases extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapterClases mAdapter;
    static private List<Clase> dataClases;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentClases() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRanking.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentClases newInstance(String param1, String param2) {
        FragmentClases fragment = new FragmentClases();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment_clases, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerViewClases);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        // add the decoration to the recyclerView
        SeparatorDecoration decoration = new SeparatorDecoration(getActivity(), Color.GRAY, 1.5f);
        mRecyclerView.addItemDecoration(decoration);
        retrieveData();
        //los datos se setean en el constructor del adapter
        mAdapter = new RecyclerAdapterClases(dataClases);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                view.setSelected(true);
                String map = dataClases.get(position).getMapa();
                UbicacionFragment mapFragment = new UbicacionFragment();
                Bundle bundle = new Bundle();
                bundle.putString("_mapUrl",map);
                mapFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main, mapFragment)
                        .commit();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }
        ));

        return rootView;
    }

    //recuperamos datos de las clases
    private void parseJsonData() throws IOException {
        AssetManager assetManager = getActivity().getAssets();
        InputStream inputStream;
        inputStream = assetManager.open("clases.json");
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        Type listType = new TypeToken<List<Clase>>(){ }.getType();

        Gson gson = new Gson();
        dataClases = gson.fromJson(reader, listType);
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
