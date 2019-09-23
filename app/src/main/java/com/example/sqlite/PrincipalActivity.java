package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void perfil(View view) {
    }

    public void new_usuario(View view) {
        startActivity(new Intent(this, NewUsuarioActivity.class));
    }

    public void lista_usuario(View view) {
        startActivity(new Intent(this, ListaUsuarioActivity.class));
    }

    public void salir(View view) {
        Mensajes.MsgConfirm(this, "Salir", "Desea Salir?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
    }
}
