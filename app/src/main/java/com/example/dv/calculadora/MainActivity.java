package com.example.dv.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nota1, nota2, nota3, nota4, numeroFaltas;
    private Button btnCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        numeroFaltas = findViewById(R.id.numeroFaltas);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int n1 = Integer.parseInt(nota1.getText().toString());
                int n2 = Integer.parseInt(nota2.getText().toString());
                int n3 = Integer.parseInt(nota3.getText().toString());
                int n4 = Integer.parseInt(nota4.getText().toString());
                int numero_faltas = Integer.parseInt(numeroFaltas.getText().toString());

                int media = (n1 + n2 + n3 + n4) / 4;

                if (media >= 5 && numero_faltas <= 20) {
                    txtResultado.setText("Aluno aprovado \n" + "Media Final: " + media);
                    txtResultado.setTextColor(getColor(R.color.green));
                } else if (numero_faltas > 20) {
                    txtResultado.setText("Aluno foi reprovado por falta \n" + "Media Final: " + media);
                    txtResultado.setTextColor(getColor(R.color.red));
                } else if (media < 5) {
                    txtResultado.setText("Aluno foi reprovado por nota \n" + "Media Final: " + media);
                    txtResultado.setTextColor(getColor(R.color.red));
                }

            }
        });
    }
}