package devandroid.rafael.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.rafael.applistacurso.R;
import devandroid.rafael.applistacurso.controller.PessoaController;
import devandroid.rafael.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    //Criando arquivo SharedPreferences
    //Classe SharedPreferences objeto preferences
    SharedPreferences preferences;
    //psfs             =criando atributo para salvar o nome da lista
    public static final String NOME_PREFERENCES = "pref_listavip";

    PessoaController controller;

    //Declarando a classe Pessoa, e o objeto pessoa
    Pessoa pessoa;

    //Classe, Objeto
    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefoneContato;
    Button btnlimpar;
    Button btnsalvar;
    Button btnfinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciando SharedPreferences, passando o nome, passando o '0' para leitura e escrita
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        //Criando lista para receber os dados
        SharedPreferences.Editor listaVip = preferences.edit();

        //Conectando a Classe MainActivity a PessoaController
        controller = new PessoaController();
        controller.toString();

        //Recebendo objeto pessoa com a classe Pessoa
        pessoa = new Pessoa();
        //Mostrando dados na tela
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("nomeCurso", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        editNomeCurso = findViewById(R.id.editNomeCurso);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnlimpar = findViewById(R.id.btnlimpar);
        btnfinalizar = findViewById(R.id.btnfinalizar);
        btnsalvar = findViewById(R.id.btnsalvar);

        //Criando ações para os botões
        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editTelefoneContato.setText("");
                editNomeCurso.setText("");
            }
        });

        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Fecha o aplicativo e Informa uma mensagem na tela
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobreNome(editSobreNome.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());
                pessoa.setCursoDesejado(editNomeCurso.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo" + pessoa.toString(), Toast.LENGTH_LONG).show();

                //Pegando os dados e adicionando a lista
                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome", pessoa.getSobreNome());
                listaVip.putString("nomeCurso", pessoa.getCursoDesejado());
                listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
                listaVip.apply();//Salvando a lista

                //Controladora recebe o metodo salvar, com os atributos da clase pessoa
                controller.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", pessoa.toString());

    }
}