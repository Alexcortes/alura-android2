package com.example.alex.agenda;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alex.agenda.modelo.Prova;


public class DetalhesProvaFragment extends Fragment {
    private TextView materia;
    private TextView data;
    private ListView listaTopicos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalhes_prova, container, false);

        materia = view.findViewById(R.id.detalhes_prova_materia);
        data = view.findViewById(R.id.detalhes_prova_data);
        listaTopicos = view.findViewById(R.id.detalhes_prova_topicos);

        Bundle parametros = getArguments();
        if(parametros != null){
            Prova prova = (Prova) parametros.getSerializable("prova");
            populaCamposCom(prova);
        }

        return view;
    }

    public void populaCamposCom(Prova prova){
        materia.setText(prova.getMateria());

        data.setText(prova.getData());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, prova.getTopicos());
        listaTopicos.setAdapter(adapter);
    }

}
