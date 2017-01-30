package com.valdiviezo.anahi.tangomio;

import android.content.Context;
import android.content.res.AssetManager;
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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;


public class FragmentClases extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mAdapter;


    public FragmentClases() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment_clases, container, false);
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerViewClases);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mAdapter = new RecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);

        try {
            parseJsonData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Inflate the layout for this fragment
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
        List<Clase> dataClases = gson.fromJson(reader, Clase.class);
    }


}
