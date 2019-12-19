package com.example.m8_endevinanum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    static int numIntents;
    static boolean volFoto;
    static Bitmap bmap;

    int numEndivina;
    EditText et;
    TextView tv;
    TextView tvx;
    Button btnProva;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numIntents = 0;
        numEndivina = (int) (Math.random() * 100 + 1);

        et = (EditText) findViewById(R.id.inputNum);
        tv = (TextView) findViewById(R.id.intentsNum);
        tvx = (TextView) findViewById(R.id.xuleta);
        btnProva = (Button) findViewById(R.id.btnProva);

        tv.setText("intents:" + numIntents);
        tvx.setText("xuleta: " + numEndivina);
        volFoto = false;

        //sql.onUpgrade(sql.getWritableDatabase(), 1, 2);

    }

    public void clickBoto(View v) {
        if (et.getText().toString().isEmpty()) {
            Toast.makeText(this, "Introdueix un nombre!", Toast.LENGTH_SHORT).show();
            et.setText("");
        } else if (Integer.parseInt(et.getText().toString()) == numEndivina) {
            numEndivina = (int) (Math.random() * 100 + 1);

            numIntents++;

            tv.setText("Cgtz! It took you " + numIntents + (numIntents == 1 ? " attemp :)" : " attemps :)"));
            btnProva.setText("Reinicia");

            btnProva.setText(R.string.btnText);
            tv.setText("intents:" + numIntents);
            tvx.setText("xuleta: " + numEndivina);
            et.setText("");

            Bitmap temp = bmap;

            Toast.makeText(this, "Si no vols fer la foto sortira una per defecte", Toast.LENGTH_LONG).show();

            dispatchTakePictureIntent();

            if (bmap == temp) bmap = BitmapFactory.decodeResource(getResources(), R.drawable.xdefecte);

            DialogHOF test01 = new DialogHOF();

            test01.show(getSupportFragmentManager(), "prova");

        } else if (Integer.parseInt(et.getText().toString()) > numEndivina) {
            Toast.makeText(this, "El numero ha de ser més petit!", Toast.LENGTH_SHORT).show();
            tv.setText("intents:" + ++numIntents);
            et.setText("");

        } else if (Integer.parseInt(et.getText().toString()) < numEndivina) {
            Toast.makeText(this, "El numero ha de ser més gran!", Toast.LENGTH_SHORT).show();
            tv.setText("intents: " + ++numIntents);
            et.setText("");
        }


    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bmap = (Bitmap) extras.get("data");
        }
    }


}
