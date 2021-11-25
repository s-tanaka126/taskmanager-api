package com.task.backend.task.application;

import javax.transaction.Transactional;

import com.task.backend.commom.entity.task.TaskEntity;
import com.task.backend.task.domain.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {

    
	@Autowired
	TaskRepository taskRepository;

    public List<TaskEntity> getAll() {

        return taskRepository.findAll();
    }

    public TaskEntity findByTaskId(int taskId) {
		return taskRepository.findByTaskId(taskId);
	
	}

    public TaskEntity createNewTask(TaskEntity task) {
		return taskRepository.save(task);
	
	}

    public TaskEntity updateTask(TaskEntity task) {
		return taskRepository.save(task);
	
	}
	public void deleteTask(TaskEntity task) {
		taskRepository.delete(task);
		
	}

	// public TaskEntity completeTask(int taskId) {
	// 	return taskRepository.findByTaskId(taskId);
	// }
    
}
