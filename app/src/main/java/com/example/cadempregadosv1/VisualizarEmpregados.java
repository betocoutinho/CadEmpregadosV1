package com.example.cadempregadosv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class VisualizarEmpregados extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_empregados);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        List<EmpregadoModel> lista = new DataBaseHelper(this).obterEmpregados();

        if (lista.size() > 0){
            EmpregadoAdapter empregadoAdapter = new EmpregadoAdapter(lista, VisualizarEmpregados.this);
            recyclerView.setAdapter(empregadoAdapter);
        }else {
            Toast.makeText(this, "Não Existe Empregados Cadastrados", Toast.LENGTH_SHORT).show();
        }
    }
}