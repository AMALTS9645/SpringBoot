package com.projectapp.projectapi.dto;

import java.time.LocalDate;
import java.util.List;

public class TaskItem {

	private Long taskId;
	
	private Long projectId;

	private String name;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	private boolean status;

	private boolean isCompleted;

//	private String expiredTime;
	private String description;
	private List<User> assignees;
	private List<CommentItem> commentList;

}
