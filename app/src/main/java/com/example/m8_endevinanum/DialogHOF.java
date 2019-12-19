package com.example.m8_endevinanum;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogHOF extends AppCompatDialogFragment {

    private EditText et;
    Bitmap bmap;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        et = new EditText(getContext());

        et.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(et);

        setCancelable(false);

        builder.setTitle("Registre al HoF!");

        builder.setMessage("Vols registrar el resultat al HoF? Si es aixi, posa el teu nom al camp de text");
        builder.setPositiveButton("Si!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new SQLiteManager(getContext(), SQLiteManager.DATABASE_NAME, null, SQLiteManager.DATABASE_VERSION).insertarDades(et.getText().toString(), MainActivity.numIntents, MainActivity.bmap);
                MainActivity.numIntents = 0;



                Intent intent = new Intent(getContext(), HoFActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }

}
