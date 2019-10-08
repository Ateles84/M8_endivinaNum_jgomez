package com.example.m8_endevinanum;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class TestDialog extends AppCompatDialogFragment {

    private EditText et;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        et = new EditText(getContext());

        et.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(et);

        setCancelable(false);

        builder.setMessage("Vols registrar el resultat al HoF?");
        builder.setPositiveButton("Si!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new SQLiteManager(getContext(), SQLiteManager.DATABASE_NAME, null, SQLiteManager.DATABASE_VERSION).insertarDades(et.getText().toString(), MainActivity.numIntents);
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
