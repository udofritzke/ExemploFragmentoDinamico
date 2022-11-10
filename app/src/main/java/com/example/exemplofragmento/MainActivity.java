package com.example.exemplofragmento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// No GitHub:
// https://github.com/udofritzke/ExemploFragmentoDinamico

public class MainActivity extends AppCompatActivity {
    private Button mBotaoAbrir;
    private boolean fragmentoAberto = false;
    static final String ESTADO_DO_FRAGMENTO = "estado_do_fragmento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define call-back para a abertura do Fragmento2 de forma dinâmica
        mBotaoAbrir = findViewById(R.id.botao_abrir);
        mBotaoAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fragmentoAberto) {
                    abreFragmento();
                } else {
                    fechaFragmento();
                }
            }
        });
        if (savedInstanceState != null) {
            fragmentoAberto =
                    savedInstanceState.getBoolean(ESTADO_DO_FRAGMENTO);
            if (fragmentoAberto) {
                // If the fragment is displayed, change button to "close".
                mBotaoAbrir.setText(R.string.fechar);
            }
        }
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Salva o estado do fragmento (true=aberto, false=fechado).
        savedInstanceState.putBoolean(ESTADO_DO_FRAGMENTO, fragmentoAberto);
        super.onSaveInstanceState(savedInstanceState);
    }
    public void abreFragmento() {
        // obtem o gerenciador de transações de fragmento e
        // inicia uma transação
        Fragmento2 fragmento = Fragmento2.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // Adiciona o fragmento
        fragmentTransaction.add(R.id.fragment2_container,
               fragmento).addToBackStack(null).commit();
        // Atualiza o texto do botão
        mBotaoAbrir.setText(R.string.fechar);
        // Seta flag indicando que o fragmento foi aberto
        fragmentoAberto = true;
    }
    public void fechaFragmento() {
        // obtem o gerenciador de transações de fragmento
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Check to see if the fragment is already showing.
        Fragmento2 fragmento = (Fragmento2) fragmentManager
                .findFragmentById(R.id.fragment2_container);
        if (fragmento != null) {
            // Cria e efetiva a transação para remover o fragmento
            FragmentTransaction fragmentTransaction =
                    fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmento).commit();
        }
        // Update the Button text.
        mBotaoAbrir.setText(R.string.abrir);
        // Set boolean flag to indicate fragment is closed.
        fragmentoAberto = false;
    }
}