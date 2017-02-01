package com.valdiviezo.anahi.tangomio;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by avaldiviezo on 1/30/17.
 */
public class RecyclerAdapterRanking extends RecyclerView.Adapter<RecyclerAdapterRanking.RankingHolder>{

    List<Cancion> listaRanking;

    public RecyclerAdapterRanking(List<Cancion> list) {
        listaRanking = list;
    }

    @Override
    public RankingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.template_ranking, parent, false);
        return new RankingHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RankingHolder holder, int position) {
        holder.checkBoxRanking.setText(listaRanking.get(position).getCancionAutor());
    }

    //cantidad de items que va a mostrar en la lista, por default viene en cero y no mostraba nada.
    @Override
    public int getItemCount() {
        return listaRanking.size();
    }


    public static class RankingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CheckBox checkBoxRanking;

        public RankingHolder(View v) {
            super(v);
            checkBoxRanking = (CheckBox) v.findViewById(R.id.checkBoxRanking);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            ////no hace nada x ahora
            Log.d("RecyclerView", "CLICK!");
        }

    }

}
