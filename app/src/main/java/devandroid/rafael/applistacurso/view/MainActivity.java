package devandroid.rafael.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.rafael.applistacurso.R;
import devandroid.rafael.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    //Declarando a classe Pessoa, e o objeto pessoa
    Pessoa pessoa;
    //Declarando novamente a classe Pessoa, e o objeto pessoa
    Pessoa outraPessoa;

    String dadosPessoa;

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

        pessoa = new Pessoa();

        //Atribuindo atributos ao objeto
        //Conforme o seu modelo, feito na classe Pessoa
        //pessoa.setPrimeiroNome("Rafael");
        //pessoa.setSobreNome("Amaro Lopes");
        //pessoa.setCursoDesejado("Android");
        //pessoa.setTelefoneContato("18-991729160");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Lucimara");
        outraPessoa.setSobreNome("Andrade");
        outraPessoa.setCursoDesejado("ADS");
        outraPessoa.setTelefoneContato("18981218829");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        editNomeCurso = findViewById(R.id.editNomeCurso);

        btnlimpar = findViewById(R.id.btnlimpar);
        btnfinalizar = findViewById(R.id.btnfinalizar);
        btnsalvar = findViewById(R.id.btnsalvar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editTelefoneContato.setText(pessoa.getTelefoneContato());
        editNomeCurso.setText(pessoa.getCursoDesejado());

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
            }
        });

        /*
        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();//o atributo 'get' pega o atributo relacionado ao dado
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();
         */

        Log.i("POOAndroid", pessoa.toString());
        Log.i("POOAndroid", outraPessoa.toString());

    }
}