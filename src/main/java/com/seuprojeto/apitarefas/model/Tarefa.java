package com.seuprojeto.apitarefas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tarefa") // novo nome para a coluna
    private String tarefa;

    @Column(name = "data_entrega") // define nome da coluna no banco
    private LocalDate dataEntrega;

    private String responsavel;

    // Construtores
    public Tarefa() {}

    public Tarefa(String tarefa, LocalDate dataEntrega, String responsavel) {
        this.tarefa = tarefa;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
    }

    // Getters e Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTarefa() { return tarefa; }

    public void setTarefa(String tarefa) { this.tarefa = tarefa; }

    public LocalDate getDataEntrega() { return dataEntrega; }

    public void setDataEntrega(LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }

    public String getResponsavel() { return responsavel; }

    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
}
