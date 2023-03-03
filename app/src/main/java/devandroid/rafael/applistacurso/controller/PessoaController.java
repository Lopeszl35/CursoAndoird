package devandroid.rafael.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.rafael.applistacurso.model.Pessoa;
import devandroid.rafael.applistacurso.view.MainActivity;

public class PessoaController {

    //Criando SharedPreferences no Controller
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";//Dando nome a lista

    public PessoaController(MainActivity mainActivity) {//PessoaController recebe MainActivity para criar SharedPreferences
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);//Criando a lista passando o nome e o mode de leitura e escrita
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    //Metodo que a controladora usara para salvar os atributos dados pelo objeto pessoa
    public void salvar(Pessoa pessoa) {
        Log.i("MVC_Controller", "Salvo:" + pessoa.toString());


        //Pegando os dados e adicionando a lista
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobreNome", pessoa.getSobreNome());
        listaVip.putString("nomeCurso", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();//Salvando a lista
    }

    public Pessoa buscar(Pessoa pessoa) {//Passando o objeto 'pessoa' para a função 'buscar', essa função ira devolver uma 'Pessoa'

        //Mostrando dados na tela
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        return pessoa;
    }

    public void limpar() {
        //Limpando a listaVip
        listaVip.clear();
        listaVip.apply();
    }
}
