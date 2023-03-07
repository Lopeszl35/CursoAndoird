package devandroid.rafael.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.rafael.applistacurso.model.Curso;

public class CursoController {//Cria classe

    private List listCursos;//Cria a lista

    public List getListaDeCursos(){//Função que devolve a lista dos cursos

        listCursos = new ArrayList<Curso>();//Cria listCursos como um array

        listCursos.add(new Curso("JAVA"));//Metódo add inclui itens na lista
        listCursos.add(new Curso("C"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("C++"));
        listCursos.add(new Curso("PYTHON"));
        listCursos.add(new Curso("HTML"));
        listCursos.add(new Curso("JAVASCRIPT"));
        listCursos.add(new Curso("PHP"));

        return listCursos;

    }
    //Criando lista onde o usuário ira selecionar o curso desejado
    public ArrayList<String> dadosParaSpinner() {
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaDeCursos().size(); i++) {
            Curso objeto = (Curso) getListaDeCursos().get(i);
            dados.add(objeto.getNomeDcursoDesejado());
        }

        return dados;
    }


}
