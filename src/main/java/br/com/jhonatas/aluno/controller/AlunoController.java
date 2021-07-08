package br.com.jhonatas.aluno.controller;

import br.com.jhonatas.aluno.handler.request.AlunoNotFoundException;
import br.com.jhonatas.aluno.model.Aluno;
import br.com.jhonatas.aluno.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController {

    private AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoService.create(aluno);
    }

    @GetMapping
    public List<Aluno> listAll() {return alunoService.findAll();}

    @GetMapping("/{id}")
    public Aluno findById(@PathVariable Integer id) throws AlunoNotFoundException {
        return alunoService.findById(id);
    }

    @PutMapping("/{id}")
    public Aluno updateById(@PathVariable Integer id, @RequestBody Aluno aluno) throws AlunoNotFoundException {
        return alunoService.updateById(id, aluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteById(@PathVariable Integer id) throws AlunoNotFoundException {
        alunoService.delete(id);

    }


}
