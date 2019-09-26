package com.example.m8_endevinanum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int numEndivina;
    int numIntents;
    EditText et;
    TextView tv;
    TextView tvx;
    Button btnProva;
    boolean fet;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numIntents = 0;
        numEndivina = (int) (Math.random() * 10);

        et = (EditText) findViewById(R.id.inputNum);
        tv = (TextView) findViewById(R.id.intentsNum);
        tvx = (TextView) findViewById(R.id.xuleta);
        btnProva = (Button) findViewById(R.id.btnProva);

        fet = false;

        tv.setText("intents:"+numIntents);
        tvx.setText("xuleta: "+numEndivina);


    }


    public void clickBoto(View v) {
        if (fet) {
            btnProva.setText(R.string.btnText);
            tv.setText("intents:"+numIntents);
            tvx.setText("xuleta: "+numEndivina);
            et.setText("");
            fet = false;
        }

        else if (et.getText().toString().isEmpty()) {
            Toast.makeText(this, "Introdueix un nombre!", Toast.LENGTH_SHORT).show();
            et.setText("");
        }

        else if (Integer.parseInt(et.getText().toString()) == numEndivina) {
            numEndivina = (int) (Math.random() * 10);

            tv.setText("Cgtz! It took you "+ ++numIntents+ (numIntents == 1 ? " attemp :)":" attemps :)"));
            btnProva.setText("Reinicia");
            fet = true;

            numIntents = 0;

        } else if (Integer.parseInt(et.getText().toString()) > numEndivina) {
            Toast.makeText(this, "El numero ha de ser més petit!", Toast.LENGTH_SHORT).show();
            tv.setText("intents:"+ ++numIntents);
            et.setText("");

        } else if (Integer.parseInt(et.getText().toString()) < numEndivina) {
            Toast.makeText(this, "El numero ha de ser més gran!", Toast.LENGTH_SHORT).show();
            tv.setText("intents: "+ ++numIntents);
            et.setText("");
        }

    }

}
