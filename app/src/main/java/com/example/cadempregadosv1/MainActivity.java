package com.example.cadempregadosv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nome_input, email_input;
    Button button_add_emp, button_ver_emp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome_input = findViewById(R.id.nome_input);
        email_input = findViewById(R.id.email_input);
        button_add_emp = findViewById(R.id.button_add_emp);
        button_ver_emp = findViewById(R.id.button_ver_emp);

        button_add_emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nome_input.getText().toString();
                String email = email_input.getText().toString();

                if (nome.length() <= 0 || nome.length() <= 0){
                    Toast.makeText(MainActivity.this, "Insira todos os dados", Toast.LENGTH_SHORT).show();
                }else {

                }
            }
        });
    }
}