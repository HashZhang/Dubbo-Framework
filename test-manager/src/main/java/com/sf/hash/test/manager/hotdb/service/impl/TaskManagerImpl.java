package com.sf.hash.test.manager.hotdb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.hash.test.dao.domain.task.Task;
import com.sf.hash.test.dao.domain.user.User;
import com.sf.hash.test.dao.mapper.task.TaskMapper;
import com.sf.hash.test.dao.mapper.task.TaskUserMapper;
import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;
import com.sf.hash.test.manager.domain.util.domainTransfer;
import com.sf.hash.test.manager.hotdb.service.TaskManager;

@Component
public class TaskManagerImpl implements TaskManager {
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private TaskUserMapper taskUserMapper;

	@Override
	public int addTask(TaskDemo taskDemo) {
		Task task = domainTransfer.taskDemoToTask(taskDemo);
		return taskMapper.insert(task);
	}

	@Override
	public int deleteTaskByPrimaryKey(long taskID) {
		return taskMapper.deleteByPrimaryKey(taskID);
	}

	@Override
	public int updateTaskByPrimaryKey(TaskDemo taskDemo) {
		Task task = domainTransfer.taskDemoToTask(taskDemo);
		return taskMapper.updateByPrimaryKey(task);
	}

	@Override
	public TaskDemo selectTaskByPrimaryKey(long taskID) {
		Task task = taskMapper.selectByPrimaryKey(taskID);
		return task == null ? null : domainTransfer.taskToTaskDemo(task);
	}

	@Override
	public List<UserDemo> getUsersByTaskID(long taskID) {
		List<User> users =taskUserMapper.selectUserByTaskID(taskID);
		List<UserDemo> userDemos=new ArrayList<UserDemo>();
		for(int i=0;i<users.size();i++){
			userDemos.add(domainTransfer.userToUserDemo(users.get(i)));
		}
		return userDemos;
	}

}
