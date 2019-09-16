package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME  = "DBprueba";
    private static final int DB_VERSION = 1;
    public DBHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos la tabla de Usuario
        db.execSQL("create table rol(_id integer primary key autoincrement, "
                +"des_rol text not null)");
        db.execSQL("insert into rol(des_rol) values('administrador')");
        db.execSQL("insert into rol(des_rol) values('director')");
        db.execSQL("insert into rol(des_rol) values('alumno')");

        db.execSQL("create table usuarios(_id integer primary key autoincrement, "
                +"nombre text not null, login not null, clave text not null, _id_rol integer not null, FOREIGN KEY(_id_rol) references rol(_id)  )");
        db.execSQL("insert into usuarios(nombre, login, clave, _id_rol) values('Jorge Missael Paz Marcos', 'jpaz', '123', 1)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public static class Usuarios{
        public static final String TABLE = "usuarios";
        public static final String _ID = "_id";
        public static final String NOMBRE = "nombre";
        public static final String LOGIN = "login";
        public static final String CLAVE = "clave";
        public static final String _ID_ROL = "_id_rol";
        public static final String[] COLUMNAS = new String[]{_ID, NOMBRE, LOGIN, CLAVE, _ID_ROL};
    }
}
