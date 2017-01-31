package com.valdiviezo.anahi.tangomio;

import android.content.res.AssetManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by avaldiviezo on 1/30/17.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ClaseHolder>{

    List<Clase> listaClases;

    public RecyclerAdapter(List<Clase> list) {
        listaClases = list;
    }

    @Override
    public ClaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.template_clases, parent, false);
        return new ClaseHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ClaseHolder holder, int position) {
        holder.profesor.setText(listaClases.get(position).getProfesor());
        holder.horario.setText(listaClases.get(position).getHorario());
        holder.ubicacion.setText(listaClases.get(position).getUbicacion());
        holder.duracion.setText(listaClases.get(position).getDuracion());
    }

    //cantidad de items que va a mostrar en la lista, por default viene en cero y no mostraba nada.
    @Override
    public int getItemCount() {
        return listaClases.size();
    }

    public static class ClaseHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView profesor;
        private TextView ubicacion;
        private TextView horario;
        private TextView duracion;

        public ClaseHolder(View v) {
            super(v);
            profesor = (TextView) v.findViewById(R.id.clase_profesor);
            horario = (TextView) v.findViewById(R.id.clase_horario);
            ubicacion = (TextView) v.findViewById(R.id.clase_ubicacion);
            duracion = (TextView) v.findViewById(R.id.clase_duracion);
            ubicacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //abrir el mapa con la ubicacion
                }
            });
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ////no hace nada x ahora
            Log.d("RecyclerView", "CLICK!");
        }

    }

}
