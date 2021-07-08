package br.com.jhonatas.aluno.handler.request;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNotFoundException extends Exception{
    public AlunoNotFoundException(Integer id){
        super("Nenhum aluno encontrado com o Id: " + id);}
}
