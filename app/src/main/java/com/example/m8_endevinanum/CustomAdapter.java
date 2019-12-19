package com.example.m8_endevinanum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Jugador> {

    private ArrayList<Jugador> llista;
    Context mContext;

    CustomAdapter(ArrayList<Jugador> llista, Context context) {
        super(context, R.layout.objecte_llista, llista);
        this.llista = llista;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Jugador jugador = getItem(position);

        View resultat = convertView;

        if (convertView == null) {

            resultat = LayoutInflater.from(mContext).inflate(R.layout.objecte_llista, parent, false);

        }

        Jugador j = llista.get(position);

        TextView tv = (TextView) resultat.findViewById(R.id.infoJugador);
        tv.setText(j.getNom());

        ImageView ig = (ImageView) resultat.findViewById(R.id.fotoJugador);
        ig.setImageBitmap(j.getFoto());

        return resultat;
    }
}
