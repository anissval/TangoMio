package com.valdiviezo.anahi.tangomio;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by avaldiviezo on 1/30/17.
 */
public class RecyclerAdapterTiendas extends RecyclerView.Adapter<RecyclerAdapterTiendas.TiendaHolder>{

    List<Tienda> listaTiendas;

    public RecyclerAdapterTiendas(List<Tienda> list) {
        listaTiendas = list;
    }

    @Override
    public TiendaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.template_tiendas, parent, false);
        return new TiendaHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(TiendaHolder holder, int position) {
        holder.tienda_nombre.setText(listaTiendas.get(position).getNombreTienda());
        holder.tienda_ubicacion.setText(listaTiendas.get(position).getUbicacionTienda());
        holder.tienda_telefono.setText(listaTiendas.get(position).getTelefonoTienda());
        Picasso.with(holder.imageTiendas.getContext()).load(listaTiendas.get(position).getImageUrl()).into(holder.imageTiendas);
    }

    //cantidad de items que va a mostrar en la lista, por default viene en cero y no mostraba nada.
    @Override
    public int getItemCount() {
        return listaTiendas.size();
    }


    public static class TiendaHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tienda_nombre;
        private TextView tienda_ubicacion;
        private TextView tienda_telefono;
        private ImageView imageTiendas;

        public TiendaHolder(View v) {
            super(v);
            tienda_nombre = (TextView) v.findViewById(R.id.tienda_nombre);
            tienda_ubicacion = (TextView) v.findViewById(R.id.tienda_ubicacion);
            tienda_telefono = (TextView) v.findViewById(R.id.tienda_telefono);
            imageTiendas = (ImageView) v.findViewById(R.id.imageTienda);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            ////no hace nada x ahora
            Log.d("RecyclerView", "CLICK!");
        }

    }

}
