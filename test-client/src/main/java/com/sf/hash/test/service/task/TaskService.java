package com.sf.hash.test.service.task;

import java.util.List;

import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;

public interface TaskService {
	TaskDemo getTask(Integer id);
	String addTask();
	String addTask(TaskDemo taskDemo);
	String deleteTask(Integer id);
	String updateTask(TaskDemo taskDemo);
	List<UserDemo> taskUsers(Integer id);
	int getCount();
}
