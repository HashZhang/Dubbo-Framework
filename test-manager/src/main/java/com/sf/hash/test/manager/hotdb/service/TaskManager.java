package com.sf.hash.test.manager.hotdb.service;

import java.util.List;

import com.sf.hash.test.dao.domain.task.Task;
import com.sf.hash.test.dao.domain.user.User;
import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;

public interface TaskManager {
	public int addTask(TaskDemo taskDemo);
	public int deleteTaskByPrimaryKey(long taskID);
	public int updateTaskByPrimaryKey(TaskDemo taskDemo);
	public TaskDemo selectTaskByPrimaryKey(long taskID);
	public List<UserDemo> getUsersByTaskID(long taskID);
}
