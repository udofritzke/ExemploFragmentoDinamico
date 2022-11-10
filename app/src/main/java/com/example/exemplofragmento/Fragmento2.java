package com.example.exemplofragmento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

public class Fragmento2 extends Fragment {
    static  View frgto2;
    ViewGroup c;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o layout para este fragmento
        frgto2 = inflater.inflate(R.layout.fragmento2, container, false);
        // Retorna uma "View frgto2" para acessar as propriedades e métodos do fragmento a partir da Activity pai
        return frgto2; //inflater.inflate(R.layout.fragmento2, container, false);
    }
    public static Fragmento2 newInstance() {
        return new Fragmento2();
    }
}