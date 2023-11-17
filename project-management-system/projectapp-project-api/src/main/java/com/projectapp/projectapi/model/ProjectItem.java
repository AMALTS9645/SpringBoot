package com.projectapp.projectapi.model;

import java.time.LocalDate;
import java.util.List;

import com.projectapp.projectapi.dto.TaskItem;

public class ProjectItem {

	private Long projectId;

	private String name;
	private String description;
	private LocalDate createdAt;
	private boolean status;

	private List<TaskItem> tasks;

}
