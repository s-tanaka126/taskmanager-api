package com.task.backend.task.domain;

import com.task.backend.commom.entity.task.TaskEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    @Query(value = "select taskEntity from TaskEntity taskEntity where taskEntity.taskId = :taskId")
	public TaskEntity findByTaskId(@Param("taskId") int taskId);
    
}
