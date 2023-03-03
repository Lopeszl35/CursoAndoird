package devandroid.rafael.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.rafael.applistacurso.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    //Metodo que a controladora usara para salvar os atributos dados pelo objeto pessoa
    public void salvar(Pessoa pessoa) {
        Log.i("MVC_Controller", "Salvo:" + pessoa.toString());

    }
}
