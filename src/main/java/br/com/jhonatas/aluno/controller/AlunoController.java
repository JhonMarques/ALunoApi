package br.com.jhonatas.aluno.controller;

import br.com.jhonatas.aluno.handler.request.AlunoNotFoundException;
import br.com.jhonatas.aluno.model.Aluno;
import br.com.jhonatas.aluno.service.AlunoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/aluno")
@Api(value="API REST Alunos")
@CrossOrigin(origins ="*")
public class AlunoController {

    private AlunoService alunoService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/novo")
    @ApiOperation(value="Cadastra um novo aluno")
    public Aluno create(@RequestBody Aluno aluno) {
        return alunoService.create(aluno);
    }

    @GetMapping(value = "/listarTodos")
    @ApiOperation(value="Retorna uma lista de alunos")
    public List<Aluno> listAll() {
        return alunoService.findAll();
    }

    @GetMapping(value = "/procurarPorId/{id}")
    @ApiOperation(value="Retorna um aluno pelo ID")
    public Aluno findById(@PathVariable Integer id) throws AlunoNotFoundException {
        return alunoService.findById(id);
    }

    @PutMapping(value = "/atualizarAluno/{id}")
    @ApiOperation(value="Atualiza um aluno cadastrado")
    public Aluno updateById(@PathVariable Integer id, @RequestBody Aluno aluno) throws AlunoNotFoundException {
        return alunoService.updateById(id, aluno);
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value="Exclui um aluno")
    public void DeleteById(@PathVariable Integer id) throws AlunoNotFoundException {
        alunoService.delete(id);

    }


}
