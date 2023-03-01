package devandroid.rafael.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.rafael.applistacurso.R;
import devandroid.rafael.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

        //Atribuindo atributos ao objeto
        //Conforme o seu modelo, feito na classe Pessoa
        pessoa.setPrimeiroNome("Rafel");
        pessoa.setSobreNome("Amaro Lopes");
        pessoa.setCursoDesejado("Android");
        pessoa.setTelefoneContato("18-991729160");

    }
}