package com.task.backend.task.domain;

import java.util.List;
import java.util.stream.Collectors;

import com.task.backend.commom.entity.task.TaskEntity;
import com.task.backend.task.domain.responese.TaskResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory {

    @Autowired
    private ModelMapper mapper;

    public TaskResponse createTaskResponse(TaskEntity taskEntity){
        return mapper.map(taskEntity, TaskResponse.class);
    }

    public List<TaskResponse> createTasksResponse(List<TaskEntity> taskList){
        return taskList.stream().map(taskEntity
                    -> mapper.map(taskEntity, TaskResponse.class)).collect(Collectors.toList());
    }
    
}
