package com.valdiviezo.anahi.tangomio;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentVotacion.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentVotacion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentVotacion extends Fragment {

    private RadioGroup radiogroupCanciones;
    static private List<Cancion> dataCancion;
    private ProgressBar loadingIndicator;
    private Button buttonEnviarVoto;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentVotacion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentVotacion.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentVotacion newInstance(String param1, String param2) {
        FragmentVotacion fragment = new FragmentVotacion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootVotacion = inflater.inflate(R.layout.fragment_fragment_votacion, container, false);
        radiogroupCanciones = (RadioGroup) rootVotacion.findViewById(R.id.radiogroupCanciones);
        buttonEnviarVoto = (Button) rootVotacion.findViewById(R.id.buttonEnviarVoto);
        buttonEnviarVoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentRanking fragment = new FragmentRanking();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main, fragment)
                        .commit();
            }
        });
        retrieveData();
        for (int row = 0; row < 1; row++) {
            for (int i = 1; i < dataCancion.size(); i++) {
                RadioButton rdbtn = new RadioButton(getActivity());
                rdbtn.setId((row * 2) + i);
                rdbtn.setText(dataCancion.get(i).getCancionAutor());
                radiogroupCanciones.addView(rdbtn);
            }
        }
        return rootVotacion;

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

    //recuperamos datos de las canciones
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
