package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtAltura = (EditText) findViewById(R.id.edtAltura);
        EditText edtPeso = (EditText) findViewById(R.id.edtPeso);
        ImageButton btnImageCalcular = (ImageButton) findViewById(R.id.btnImageCalcular);

        btnImageCalcular.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                double altura = Double.parseDouble(edtAltura.getText().toString());
                double peso = Double.parseDouble(edtPeso.getText().toString());
                double imc = peso / (altura * altura);

                if (imc <= 18.9) {
                    Toast.makeText(getApplicationContext(), "Seu IMC atual é \n " + imc
                                    + "\nMAGREZA. ",
                            Toast.LENGTH_LONG).show();
                } else if (imc > 18.9 && imc <= 24.9) {
                    Toast.makeText(getApplicationContext(), "Seu IMC atual é \n " + imc
                                    + "\nNORMAL. ",
                            Toast.LENGTH_LONG).show();
                } else if (imc > 24.9 && imc <= 29.9) {
                    Toast.makeText(getApplicationContext(), "Seu IMC atual é \n " + imc
                                    + "\nSOBREPESO. ",
                            Toast.LENGTH_LONG).show();
                } else if (imc > 29.9 && imc <= 34.9) {
                    Toast.makeText(getApplicationContext(), "Seu IMC atual é \n " + imc
                                    + "\nOBESIDADE GRAU 1. ",
                            Toast.LENGTH_LONG).show();
                } else if (imc > 34.9 && imc <= 39.9) {
                    Toast.makeText(getApplicationContext(), "Seu IMC atual é \n " + imc
                                    + "\nOBESIDADE GRAU 2. ",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Seu IMC atual é \n " + imc
                                    + "\nOBESIDADE MORBIDA. ",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}