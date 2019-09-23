package com.example.sqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class UsuarioAdapter {
    private Context context;
    private List<Usuario> lista;
    public UsuarioAdapter(Context context, List<Usuario> model){
        this.context = context;
        this.lista = model;
    }

    public int getCount() {
        return lista.size();
    }


    public Object getItem(int i) {
        return lista.get(i);
    }


    public long getItemId(int i) {
        return i;
    }


    public View getView(int i, View view, ViewGroup viewGroup) {
        Usuario usuario = lista.get(i);
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_lista_usuario, null);
        }
        TextView txtNom = (TextView) view.findViewById(R.id.usuario_lista_nombre);
        txtNom.setText(usuario.getNombres());
        return view;
    }
}
