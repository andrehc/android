package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtAltura = (EditText) findViewById(R.id.edtAltura);
        EditText edtPeso = (EditText) findViewById(R.id.edtPeso);
        ImageButton btnImgCalcular = (ImageButton) findViewById(R.id.btnImgCalcular);
        ImageView img = (ImageView) findViewById(R.id.imgResultado);
        TextView resultado = (TextView) findViewById(R.id.resultado);

//        EditText edtAltura = (EditText) findViewById(R.id.edtAltura);
//        EditText edtPeso = (EditText) findViewById(R.id.edtPeso);
//        ImageButton btnImageCalcular = (ImageButton) findViewById(R.id.btnImageCalcular);
//        TextView resultado = (TextView) findViewById(R.id.resultado);

        btnImgCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double altura = Double.parseDouble(edtAltura.getText().toString());
                double peso = Double.parseDouble(edtPeso.getText().toString());
                double imc = peso / (altura * altura);
                Uri imgUriMagro = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + "magreza");
                Uri imgUriNormal = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + "normal");
                Uri imgUriObeso = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + "obeso");
                Uri imgUriGrau2 = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + "grau2");
                if (imc < 18.5) {
                    img.setImageURI(imgUriMagro);
                    img.setVisibility(View.VISIBLE);
                    resultado.setText("Seu imc ??: " + imc);
                } else if (imc >= 18.5 && imc <= 24.9) {
                    img.setImageURI(imgUriNormal);
                    img.setVisibility(View.VISIBLE);
                    resultado.setText("Seu imc ??: " + imc);
                } else if (imc >= 25.0 && imc <= 29.9) {
                    img.setImageURI(imgUriObeso);
                    img.setVisibility(View.VISIBLE);
                    resultado.setText("Seu imc ??: " + imc);
                } else if (imc >= 30.0 && imc <= 39.9) {
                    img.setImageURI(imgUriObeso);
                    resultado.setText("Seu imc ??: " + imc);
                    img.setVisibility(View.VISIBLE);
                } else {
                    img.setImageURI(imgUriGrau2);
                    img.setVisibility(View.VISIBLE);
                    resultado.setText("Seu imc ??: " + imc);
                }
            }
        });
//        btnImageCalcular.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                double altura = Double.parseDouble(edtAltura.getText().toString());
//                double peso = Double.parseDouble(edtPeso.getText().toString());
//                double imc = peso / (altura * altura);
//                Uri imgUri = Uri.parse("android.resource://" + getPackageName() + "/drawable/" + "mulher");
//                if (imc <= 18.9) {
//                    resultado.setText("MAGREZA");
//                } else if (imc > 18.9 && imc <= 24.9) {
//                    resultado.setText("NORMAL");
//                } else if (imc > 24.9 && imc <= 29.9) {
//                    resultado.setText("SOBREPESO");
//                } else if (imc > 29.9 && imc <= 34.9) {
//                    resultado.setText("OBESIDADE GRAU 1");
//                } else if (imc > 34.9 && imc <= 39.9) {
//                    resultado.setText("OBESIDADE GRAU 2");
//                } else {
//                    resultado.setText("OBESIDADE GRAU 3");
//                }
//            }
//        });
    }
}