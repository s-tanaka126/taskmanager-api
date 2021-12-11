package com.task.backend.task.interfaces;


import com.task.backend.commom.entity.task.TaskEntity;
import com.task.backend.task.application.TaskService;
import com.task.backend.task.domain.request.TaskRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.sql.Date;
import java.sql.Time;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
	TaskService taskService;

	//全取得
	@GetMapping	("/list")
	public List<TaskEntity> getTask() {

	    List<TaskEntity> task = taskService.getAll();
	
		return task;

	}

 	//詳細情報取得
	@GetMapping("/{taskId}")
	public TaskEntity getTask(@PathVariable int taskId){

		return taskService.findByTaskId(taskId);

		}

	//登録
	@PostMapping("/new")
	public TaskEntity createNewTask(@RequestBody TaskRequest taskRequest){

		TaskEntity task = new TaskEntity();

		task.setTaskId(taskRequest.getId());
		task.setTaskName(taskRequest.getName());
		if(taskRequest.getDate() != null) {
			task.setTaskDate(Date.valueOf(taskRequest.getDate()));
		}
		if(taskRequest.getTime() != null) {
			task.setTaskTime(Time.valueOf(taskRequest.getTime()));
			}
		task.setTaskPlace(taskRequest.getPlace());

		return taskService.createNewTask(task);

	}	

	//更新
	@PostMapping("/update")
	public TaskEntity uadateTask(@RequestBody TaskRequest taskRequest){

		TaskEntity task = taskService.findByTaskId(taskRequest.getId());

		task.setTaskName(taskRequest.getName());
		task.setTaskPlace(taskRequest.getPlace());
		task.setCompleteFlag(taskRequest.isComplete());

		if(taskRequest.getDate() != null) {
			task.setTaskDate(Date.valueOf(taskRequest.getDate()));
		}
		if(taskRequest.getTime() != null) {
			task.setTaskTime(Time.valueOf(taskRequest.getTime()));
			}
		task.setTaskPlace(taskRequest.getPlace());

		return taskService.updateTask(task);

	}

	//削除(Entity)
	@DeleteMapping("/delete/{taskId}")
	public void deleteTask(@PathVariable int taskId) {
		TaskEntity deleteTask = taskService.findByTaskId(taskId);
		taskService.deleteTask(deleteTask);
		
	}

	//完了
	@PostMapping("/complete")
	public TaskEntity completeTask(@RequestBody TaskRequest taskRequest) {
		
		TaskEntity task = taskService.findByTaskId(taskRequest.getId());
		task.setCompleteFlag(!task.isCompleteFlag());
				
		return taskService.completeTask(task);
	} 
}
