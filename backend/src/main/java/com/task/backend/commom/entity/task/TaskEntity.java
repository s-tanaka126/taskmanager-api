package com.task.backend.commom.entity.task;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @Column(name = "task_id")
    private int taskId;
	
	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "task_date")
	private Date taskDate;
	
	@Column(name = "task_time")
	private Time taskTime;
	
	@Column(name = "task_place")
	private String taskPlace;
	
	@Column(name = "complete_flag")
	private boolean completeFlag;
}
