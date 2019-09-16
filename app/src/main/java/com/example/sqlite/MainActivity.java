package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsuario, edtClave;
    private UsuarioDao usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario = (EditText) findViewById(R.id.editUusario);
        edtClave = (EditText) findViewById(R.id.editClave);
        usuarioDAO = new UsuarioDao(this);
    }

    public void logueo(View view) {
        String usuario = edtUsuario.getText().toString();
        String clave = edtClave.getText().toString();
        Toast.makeText(getApplicationContext(),usuario,Toast.LENGTH_LONG).show();
        boolean valida = true;
        if(usuario == null || usuario.equals("")){
            valida = false;
            edtUsuario.setError(getString(R.string.Login_validaUsuario));
        }
        if(clave == null || clave.equals("")){
            valida = false;
            edtClave.setError(getString(R.string.Login_validaClave));
        }
        if(valida){
            if(usuarioDAO.logueoUser(usuario, clave)){
                startActivity(new Intent(this, PrincipalActivity.class));
                finish();
            }else{
                Mensajes.Msg(this,getString(R.string.msg_login_incorrecto));
            }
        }
    }
}
