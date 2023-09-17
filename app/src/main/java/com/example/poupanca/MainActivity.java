package com.example.poupanca;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ValorInicial, Aplicacaomensal,Taxa;
    private Button calcularButton;
    private TextView Resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        ValorInicial = findViewById(R.id.ValorInicial);
        Aplicacaomensal = findViewById(R.id.Aplicacaomensal);
        Taxa = findViewById(R.id.Taxa);
        Resultado = findViewById(R.id.Resultado);

    }


    public void CalcularMontante(View v) {
        String valorInicialStr = ValorInicial.getText().toString();
        String aplicacaoMensalStr = Aplicacaomensal.getText().toString();
        String taxaStr = Taxa.getText().toString();

        if (valorInicialStr.isEmpty() || aplicacaoMensalStr.isEmpty() || taxaStr.isEmpty()) {
            Resultado.setTextColor(getResources().getColor(R.color.red));
            Resultado.setText("Erro! \nPreencha todo os campos!");
        } else {


            double valorInicial = Double.parseDouble(ValorInicial.getText().toString());
            double aplicacaoMensal = Double.parseDouble(Aplicacaomensal.getText().toString());
            double taxa = Double.parseDouble(Taxa.getText().toString());

            double montante = valorInicial;
            for (int i = 1; i <= 12; i++) {
                montante += aplicacaoMensal;
                montante += montante * (taxa / 100);
            }

            // Formate o resultado para exibir apenas duas casas decimais
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String montanteFormatado = decimalFormat.format(montante);

            Resultado.setTextColor(getResources().getColor(R.color.dark_blue)); //cor dark_blue (mesma cor do app)
            Resultado.setText("O montante Final é: \nR$" + montanteFormatado);
            Resultado.setVisibility(View.VISIBLE);

        }
    }
    }