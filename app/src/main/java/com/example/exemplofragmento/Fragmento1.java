package com.example.exemplofragmento;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class Fragmento1 extends Fragment {
    private Button Botao1;
    private Button Botao2;
    private TextView texto1;
    private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragmento1, container, false);

        Botao1 = (Button) v.findViewById(R.id.button1);
        Botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "botao 1");
                View outro_fragmento = inflater.inflate(R.layout.fragmento2, container, false);
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg2);
                if (txt != null) txt.setText("Apertou botão 1");
            }
        });
        Botao2 = (Button) v.findViewById(R.id.button2);
        Botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "botao 2");
                View outro_fragmento = inflater.inflate(R.layout.fragmento2, container, false);
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg2);
                if (txt != null) txt.setText("Apertou botão 2");
            }
        });

        texto1 = (TextView) v.findViewById(R.id.texto1);
        texto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "texto 1");
                View outro_fragmento = inflater.inflate(R.layout.fragmento2, container, false);
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg2);
                if (txt != null) txt.setText("Apertou texto 1");
            }
        });


        return v;
    }
}