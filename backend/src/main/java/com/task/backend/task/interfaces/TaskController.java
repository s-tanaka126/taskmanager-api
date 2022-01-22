package com.task.backend.task.interfaces;


import com.task.backend.commom.entity.task.TaskEntity;
import com.task.backend.task.application.TaskService;
import com.task.backend.task.domain.TaskFactory;
import com.task.backend.task.domain.request.TaskRequest;
import com.task.backend.task.domain.responese.TaskResponse;

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

	@Autowired
	TaskFactory taskFactory;


	//全取得
	@GetMapping	("/list")
	public List<TaskResponse> getTask(){
		return taskFactory.createTasksResponse(taskService.getAll());
	}

	//詳細情報取得
	@GetMapping("/{taskId}")
	public TaskResponse getTask(@PathVariable int taskId){
		return taskFactory.createTaskResponse(taskService.findByTaskId(taskId));
	}

	//登録
	@PostMapping("/new")
	public TaskResponse createsNewTask(@RequestBody TaskRequest taskRequest){

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

		return taskFactory.createTaskResponse(task);

	}

	//更新
	@PostMapping("/update")
	public TaskResponse uadateTask(@RequestBody TaskRequest taskRequest){
	
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
	
		return taskFactory.createTaskResponse(task);
	
	}

	//削除(Entity)
	@DeleteMapping("/delete/{taskId}")
	public void deleteTask(@PathVariable int taskId) {
		TaskEntity deleteTask = taskService.findByTaskId(taskId);
		taskFactory.createTaskResponse(deleteTask);
		
	}

	//完了
	@PostMapping("/complete")
	public TaskResponse completeTask(@RequestBody TaskRequest taskRequest) {
		
		TaskEntity task = taskService.findByTaskId(taskRequest.getId());
		task.setCompleteFlag(!task.isCompleteFlag());
				
		return taskFactory.createTaskResponse(task);
	} 
}
