package com.example.m8_endevinanum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;

public class HoFActivity extends AppCompatActivity {

    EditText txtNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_f);

        txtNom = findViewById(R.id.inputNom);

        txtNom.setVisibility(View.INVISIBLE);
        txtNom.setFocusable(false);

    }


}
