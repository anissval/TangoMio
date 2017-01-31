package com.valdiviezo.anahi.tangomio;

import android.app.ListActivity;
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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class FragmentClases extends Fragment {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerAdapter mAdapter;
    private List<Clase> dataClases;

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
        retrieveData();
        //los datos se setean en el constructor del adapter
        mAdapter = new RecyclerAdapter(dataClases);

        mRecyclerView.setAdapter(mAdapter);

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
        dataClases = gson.fromJson(reader, listType);
    }

    private void retrieveData(){
        try {
            parseJsonData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
