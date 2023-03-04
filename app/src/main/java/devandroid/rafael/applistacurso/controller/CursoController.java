package devandroid.rafael.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.rafael.applistacurso.model.Curso;

public class CursoController {//Cria classe

    public List listCursos;//Cria a lista

    public List getListaDeCursos(){//Função que devolve a lista dos cursos

        listCursos = new ArrayList<Curso>();//Cria listCursos como um array

        listCursos.add(new Curso);//Metódo add inclui itens na lista
        listCursos.add(new Curso);
        listCursos.add(new Curso);
        listCursos.add(new Curso);
        listCursos.add(new Curso);
        listCursos.add(new Curso);
        listCursos.add(new Curso);
        listCursos.add(new Curso);

        return listCursos;

    }


}
