package com.valdiviezo.anahi.tangomio;

import android.content.res.AssetManager;
import android.graphics.Color;
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


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link FragmentTiendas.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link FragmentTiendas#newInstance} factory method to
// * create an instance of this fragment.
// */
public class FragmentTiendas extends Fragment {

    private RecyclerView tiendasRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapterTiendas mAdapter;
    static private List<Tienda> dataTiendas;

    public FragmentTiendas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootTiendas = inflater.inflate(R.layout.fragment_fragment_tiendas, container, false);

        tiendasRecyclerView= (RecyclerView)rootTiendas.findViewById(R.id.recyclerViewTiendas);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        tiendasRecyclerView.setLayoutManager(mLinearLayoutManager);

        // add the decoration to the recyclerView
        SeparatorDecoration decoration = new SeparatorDecoration(getActivity(), Color.GRAY, 1.5f);
        tiendasRecyclerView.addItemDecoration(decoration);
        retrieveData();
        //los datos se setean en el constructor del adapter
        mAdapter = new RecyclerAdapterTiendas(dataTiendas);
        tiendasRecyclerView.setAdapter(mAdapter);

        tiendasRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                tiendasRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                view.setSelected(true);
                String map = dataTiendas.get(position).getMapTienda();
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

        return rootTiendas;
    }

    //recuperamos datos de las tiendas
    private void parseJsonData() throws IOException {
        AssetManager assetManager = getActivity().getAssets();
        InputStream inputStream;
        inputStream = assetManager.open("Tiendas.json");
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
        Type listType = new TypeToken<List<Tienda>>(){ }.getType();

        Gson gson = new Gson();
        dataTiendas = gson.fromJson(reader, listType);
    }

    private void retrieveData(){
        try {
            parseJsonData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
