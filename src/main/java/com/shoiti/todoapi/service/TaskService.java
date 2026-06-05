package com.shoiti.todoapi.service;

import com.shoiti.todoapi.dto.TaskRequestDTO;
import com.shoiti.todoapi.dto.TaskResponseDTO;
import com.shoiti.todoapi.model.Task;
import com.shoiti.todoapi.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Converte Task (entidade do banco) para TaskResponseDTO (o que a API retorna)
    // O cliente nunca vê a entidade diretamente
    private TaskResponseDTO toDTO(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt()
        );
    }

    // Busca todas as tarefas e converte cada uma pra DTO
    public List<TaskResponseDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Busca por ID e converte pra DTO. Lança exceção se não encontrar
    public TaskResponseDTO findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        return toDTO(task);
    }

    // Recebe DTO, cria entidade Task, salva no banco e retorna DTO
    public TaskResponseDTO save(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        return toDTO(taskRepository.save(task));
    }

    // Busca a tarefa existente, atualiza os campos e salva
    public TaskResponseDTO update(Long id, TaskRequestDTO dto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCompleted(dto.isCompleted());
        return toDTO(taskRepository.save(task));
    }

    // Deleta a tarefa pelo ID
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}