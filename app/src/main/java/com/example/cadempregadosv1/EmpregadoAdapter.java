package com.example.cadempregadosv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmpregadoAdapter extends RecyclerView.Adapter<EmpregadoAdapter.ViewHolder>{

    List<EmpregadoModel> empregados;
    Context context;
    DataBaseHelper dataBaseHelper;

    public EmpregadoAdapter(List<EmpregadoModel> empregados, Context context) {
        this.empregados = empregados;
        this.context = context;
        this.dataBaseHelper = new DataBaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.empregado_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EmpregadoModel empregado = empregados.get(position);

        holder.idview.setText(Integer.toString(empregado.getId()));
        holder.nome_text.setText(empregado.getNome());
        holder.email_text.setText(empregado.getEmail());
    }

    @Override
    public int getItemCount() {
        return empregados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView idview;
        EditText nome_text, email_text;
        Button button_editar, button_remover;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idview = itemView.findViewById(R.id.id_text);
            nome_text = itemView.findViewById(R.id.edi_nome);
            email_text = itemView.findViewById(R.id.edi_email);
            button_editar = itemView.findViewById(R.id.button_editar);
            button_remover = itemView.findViewById(R.id.button_remover);


        }
    }
}
