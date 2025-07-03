package com.seuprojeto.apitarefas.repository;

import com.seuprojeto.apitarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface que permite fazer operações CRUD no banco de dados
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
