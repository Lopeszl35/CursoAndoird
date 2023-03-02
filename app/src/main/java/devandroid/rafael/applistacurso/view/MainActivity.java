package devandroid.rafael.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import devandroid.rafael.applistacurso.R;
import devandroid.rafael.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    //Declarando o objeto Pessoa
    Pessoa pessoa;
    //Declarando novamente o objeto pessoa
    Pessoa outraPessoa;

    String dadosPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

        //Atribuindo atributos ao objeto
        //Conforme o seu modelo, feito na classe Pessoa
        pessoa.setPrimeiroNome("Rafael");
        pessoa.setSobreNome("Amaro Lopes");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("18-991729160");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Lucimara");
        outraPessoa.setSobreNome("Andrade");
        outraPessoa.setCursoDesejado("ADS");
        outraPessoa.setTelefoneContato("18981218829");

        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();//o atributo 'get' pega o atributo relacionado ao dado
        dadosPessoa += " Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += " Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += " Telefone de Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        Log.i("POOAndroid", pessoa.toString());
        Log.i("POOAndroid", outraPessoa.toString());

    }
}