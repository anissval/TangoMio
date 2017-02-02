
package com.valdiviezo.anahi.tangomio;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by avaldiviezo on 1/30/17.
 */
public class RecyclerAdapterRanking extends RecyclerView.Adapter<RecyclerAdapterRanking.RankingHolder>{

    List<Ranking> listaRanking;

    public RecyclerAdapterRanking(List<Ranking> list) {
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
        holder.ranking_nombre.setText(listaRanking.get(position).getNombre());
        holder.ranking_autor.setText(listaRanking.get(position).getAutor());
        holder.ranking_posicion.setText(listaRanking.get(position).getPosicion());

    }

    //cantidad de items que va a mostrar en la lista, por default viene en cero y no mostraba nada.
    @Override
    public int getItemCount() {
        return listaRanking.size();
    }


    public static class RankingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView ranking_nombre;
        private TextView ranking_autor;
        private TextView ranking_posicion;


        public RankingHolder(View v) {
            super(v);
            ranking_nombre = (TextView) v.findViewById(R.id.ranking_nombre);
            ranking_autor = (TextView) v.findViewById(R.id.ranking_autor);
            ranking_posicion = (TextView) v.findViewById(R.id.ranking_posicion);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            ////no hace nada x ahora
            Log.d("RecyclerView", "CLICK!");
        }

    }

}
