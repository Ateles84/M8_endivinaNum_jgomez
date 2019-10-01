package com.example.m8_endevinanum;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class testDialog extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Registre al HoF");
        builder.setMessage("Vols registrar el resultat al HoF?");
        builder.setPositiveButton("Si!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                new MainActivity().canviarAHOF();
            }
        });

        return builder.create();
    }
}
