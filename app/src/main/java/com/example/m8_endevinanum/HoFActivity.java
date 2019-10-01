package com.example.m8_endevinanum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;

public class HoFActivity extends AppCompatActivity {

    TextView txtNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_f);

        Intent prova = getIntent();



        txtNom = findViewById(R.id.Podio);

//        txtNom.setVisibility(View.INVISIBLE);
        txtNom.setFocusable(false);


    }


}
