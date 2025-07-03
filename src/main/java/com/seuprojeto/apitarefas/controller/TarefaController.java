package com.seuprojeto.apitarefas.controller;

import com.seuprojeto.apitarefas.model.Tarefa;
import com.seuprojeto.apitarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST responsável pelos endpoints da entidade Tarefa.
 */
@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    // Injeção do repositório que manipula o banco de dados
    @Autowired
    private TarefaRepository tarefaRepository;

    /**
     * Cria uma nova tarefa.
     * Método POST: /api/tarefas
     */
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    /**
     * Retorna todas as tarefas cadastradas.
     * Método GET: /api/tarefas
     */
    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    /**
     * Busca uma tarefa específica por ID.
     * Método GET: /api/tarefas/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Atualiza uma tarefa existente.
     * Método PUT: /api/tarefas/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefa.setTarefa(tarefaAtualizada.getTarefa()); // <<== ATUALIZADO
                    tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
                    tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
                    Tarefa tarefaSalva = tarefaRepository.save(tarefa);
                    return ResponseEntity.ok(tarefaSalva);
                }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deleta uma tarefa existente.
     * Método DELETE: /api/tarefas/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (!tarefaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tarefaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
