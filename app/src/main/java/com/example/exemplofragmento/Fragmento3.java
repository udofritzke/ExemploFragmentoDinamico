package com.example.exemplofragmento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragmento3 extends Fragment {
    static  View frgto3;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o layout para este fragmento
        frgto3 = inflater.inflate(R.layout.fragmento3, container, false);
        // Retorna uma "View frgto2" para acessar as propriedades e métodos do fragmento a partir da Activity pai
        return frgto3; //inflater.inflate(R.layout.fragmento2, container, false);
    }
    public static Fragmento3 newInstance() {
        return new Fragmento3();
    }

}
