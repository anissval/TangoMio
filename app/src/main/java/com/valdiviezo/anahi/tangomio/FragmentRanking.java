package com.valdiviezo.anahi.tangomio;

import android.content.Context;
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
import android.widget.ProgressBar;

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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRanking.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRanking#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRanking extends Fragment {

    private RecyclerView rankingRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapterRanking mAdapter;
    static private List<Cancion> dataCancion;
    private ProgressBar loadingIndicator;
    Integer selected_position = -1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentRanking() {
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
    public static FragmentRanking newInstance(String param1, String param2) {
        FragmentRanking fragment = new FragmentRanking();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        View rootRanking = inflater.inflate(R.layout.fragment_fragment_ranking, container, false);
        loadingIndicator = (ProgressBar) rootRanking.findViewById(R.id.loadingIndicator);

        rankingRecyclerView= (RecyclerView)rootRanking.findViewById(R.id.recyclerViewRanking);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        rankingRecyclerView.setLayoutManager(mLinearLayoutManager);

        // add the decoration to the recyclerView
        SeparatorDecoration decoration = new SeparatorDecoration(getActivity(), Color.GRAY, 1.5f);
        rankingRecyclerView.addItemDecoration(decoration);
        retrieveData();
        //los datos se setean en el constructor del adapter
        mAdapter = new RecyclerAdapterRanking(dataCancion);
        rankingRecyclerView.setAdapter(mAdapter);

        rankingRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                rankingRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                view.findViewById(R.id.checkBoxRanking).setSelected(position != selected_position);
                        if (position != selected_position ) {
                            selected_position = position;
                        } else {
                            selected_position = -1;
                        }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }
        ));

        return rootRanking;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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


    //recuperamos datos de las clases
    private void parseJsonData() throws IOException {
        AssetManager assetManager = getActivity().getAssets();
        InputStream inputStream;
        inputStream = assetManager.open("canciones.json");
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        Type listType = new TypeToken<List<Cancion>>(){ }.getType();

        Gson gson = new Gson();
        dataCancion = gson.fromJson(reader, listType);
    }

    private void retrieveData(){
        try {
            parseJsonData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

