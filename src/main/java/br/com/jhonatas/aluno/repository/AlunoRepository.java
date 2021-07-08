package br.com.jhonatas.aluno.repository;

import br.com.jhonatas.aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
