package com.example.m8_endevinanum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int numEndivina;
    static int numIntents;
    EditText et;
    TextView tv;
    TextView tvx;
    Button btnProva;
    SQLiteManager sql;
    String nom;

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

        SQLiteManager sql = new SQLiteManager(this, SQLiteManager.DATABASE_NAME, null, SQLiteManager.DATABASE_VERSION);

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

            numIntents = 0;

            btnProva.setText(R.string.btnText);
            tv.setText("intents:" + numIntents);
            tvx.setText("xuleta: " + numEndivina);
            et.setText("");

            TestDialog test01 = new TestDialog();

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


}
