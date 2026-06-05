package com.shoiti.todoapi.controller;

import com.shoiti.todoapi.dto.TaskRequestDTO;
import com.shoiti.todoapi.dto.TaskResponseDTO;
import com.shoiti.todoapi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
// Diz pro Spring: "essa classe recebe requisições HTTP e retorna JSON"
@RequestMapping("/tasks")
// Define a URL base. Todos os endpoints dessa classe começam com /tasks
public class TaskController {

    private final TaskService taskService;

    // Injeção de dependência — o Spring cria o TaskService automaticamente
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    // Responde GET em /tasks — busca todas as tarefas
    public List<TaskResponseDTO> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    // Responde GET em /tasks/1 — busca uma tarefa pelo ID
    public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.findById(id));
    }

    @PostMapping
    // Responde POST em /tasks — cria uma tarefa nova
    public ResponseEntity<TaskResponseDTO> save(@RequestBody TaskRequestDTO dto){
        return ResponseEntity.ok(taskService.save(dto));
    }

    @PutMapping("/{id}")
    // Responde PUT em /tasks/1 — atualiza a tarefa
    public ResponseEntity<TaskResponseDTO> update(@PathVariable Long id, @RequestBody TaskRequestDTO dto){
        return ResponseEntity.ok(taskService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    // Responde DELETE em /tasks/1 — deleta a tarefa
    public ResponseEntity<Void> delete(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}