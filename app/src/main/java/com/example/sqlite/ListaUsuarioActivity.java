package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class ListaUsuarioActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener {
    private ListView lista1;
    private List<Usuario> listaList;
    private UsuarioAdapter adapter;
    private UsuarioDao usuarioDAO;
    private int idposi;
    private AlertDialog alertDialog, alertconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);
        alertDialog = Mensajes.crearAlertaDialog(this);
        alertDialog = Mensajes.crearAlertaDialog(this);
        alertconfirm = Mensajes.crearDialogConfirmacion(this);

        usuarioDAO = new UsuarioDao(this);
        listaList = usuarioDAO.listarUsuarios();
        adapter = new UsuarioAdapter(this,listaList);

        lista1 = (ListView) findViewById(R.id.lvUsuarios);
        lista1.setAdapter((ListAdapter) adapter);

        lista1.setOnItemClickListener(this);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        int id = listaList.get(idposi).get_id();
        switch (which){
            case 0:
                Intent intent = new Intent(this, UsuarioActivity.class);
                intent.putExtra("USUARIO_ID",id);
                startActivity(intent);
                break;
            case 1:alertconfirm.show();
                break;
            case DialogInterface.BUTTON_POSITIVE:
                listaList.remove(idposi);
                usuarioDAO.eliminarUsuario(id);
                lista1.invalidateViews();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                alertconfirm.dismiss();break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        idposi = position;
        alertDialog.show();
    }
}
