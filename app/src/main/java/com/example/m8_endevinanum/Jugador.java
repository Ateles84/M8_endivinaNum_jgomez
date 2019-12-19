package com.example.m8_endevinanum;

import android.graphics.Bitmap;

public class Jugador {

    String nom;
    Bitmap foto;

    Jugador(String nom, Bitmap foto) {
        this.nom = nom;
        this.foto = foto;
    }

    Jugador(String nom) {
        this.nom = nom;
        this.foto = null;
    }

    public String getNom() {
        return nom;
    }

    public Bitmap getFoto() {
        return foto;
    }



}
