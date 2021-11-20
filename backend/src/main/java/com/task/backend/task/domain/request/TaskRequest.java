package com.task.backend.task.domain.request;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class TaskRequest {
	
	private int id;
	private String name;
	private String date;
	private String time;
	private String place;
	private boolean complete;

}