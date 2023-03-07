package devandroid.rafael.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.rafael.applistacurso.R;
import devandroid.rafael.applistacurso.controller.CursoController;
import devandroid.rafael.applistacurso.controller.PessoaController;
import devandroid.rafael.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    PessoaController controller;//Definindo o objeto da classe PessoaController
    CursoController cursoController;

    //Declarando a classe Pessoa, e o objeto pessoa
    Pessoa pessoa;
    List<String> nomesDosCursos;

    //Classe, Objeto
    EditText editPrimeiroNome;
    EditText editSobreNome;
    EditText editNomeCurso;
    EditText editTelefoneContato;

    Button btnlimpar;
    Button btnsalvar;
    Button btnfinalizar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Conectando a Classe MainActivity a PessoaController
        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();//Recebe a lista para mostrar ao usuário

        //Recebendo objeto pessoa com a classe Pessoa
        pessoa = new Pessoa();
        controller.buscar(pessoa);

        //Mostra ao programa onde estão os lugares onde insere textos
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobreNome = findViewById(R.id.editSobreNome);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        editNomeCurso = findViewById(R.id.editNomeCurso);
        spinner = findViewById(R.id.spinner);

        //Mostra ao programa oque fazer com cada lugar onde se põe os textos
        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobreNome.setText(pessoa.getSobreNome());
        editNomeCurso.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        //Mostra ao programa onde estão os botões
        btnlimpar = findViewById(R.id.btnlimpar);
        btnfinalizar = findViewById(R.id.btnfinalizar);
        btnsalvar = findViewById(R.id.btnsalvar);

        //Adapter
        //Layout
        //Injetar o adapter ao spinner - A lista sera gerada
        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosParaSpinner());

        //Ao clicar em "selecione o curso" um layout sera mostrado
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);


        //Criando ações para os botões
        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText("");
                editSobreNome.setText("");
                editTelefoneContato.setText("");
                editNomeCurso.setText("");

                controller.limpar();
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

                //Controladora recebe o metodo salvar, com os atributos da clase pessoa
                controller.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", pessoa.toString());

    }
}