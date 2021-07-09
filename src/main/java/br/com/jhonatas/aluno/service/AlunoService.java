package br.com.jhonatas.aluno.service;


import br.com.jhonatas.aluno.handler.request.AlunoNotFoundException;
import br.com.jhonatas.aluno.model.Aluno;
import br.com.jhonatas.aluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    private List<Aluno> alunos = new ArrayList<>();

    public Aluno findById(Integer id) throws AlunoNotFoundException {
        Aluno aluno = verifyIfExists(id);
        return aluno;
    }

    public Aluno create (Aluno aluno){
        aluno.setId(null);
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }


    public void delete (Integer id) throws AlunoNotFoundException {
        verifyIfExists(id);
        alunoRepository.deleteById(id);
    }

    public Aluno updateById(Integer id, Aluno aluno) throws AlunoNotFoundException {
        verifyIfExists(id);
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    private Aluno verifyIfExists(Integer id) throws AlunoNotFoundException {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException(id));
    }


}
