package com.sf.hash.test.manager.domain.util;

import com.sf.hash.test.dao.domain.task.Task;
import com.sf.hash.test.dao.domain.user.User;
import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;

public class domainTransfer {
	public static User userDemoToUser(UserDemo userDemo)
	{
		User user=new User();
		user.setAuthType(userDemo.getAuthType());
		user.setCreateTime(userDemo.getCreateTime());
		user.setId(userDemo.getId());
		user.setPassword(userDemo.getPassword());
		user.setStatus(userDemo.getStatus());
		user.setUpdateTime(userDemo.getUpdateTime());
		user.setUsername(userDemo.getUsername());
		return user;
	}
	public static UserDemo userToUserDemo(User userDemo)
	{
		UserDemo user=new UserDemo();
		user.setAuthType(userDemo.getAuthType());
		user.setCreateTime(userDemo.getCreateTime());
		user.setId(userDemo.getId());
		user.setPassword(userDemo.getPassword());
		user.setStatus(userDemo.getStatus());
		user.setUpdateTime(userDemo.getUpdateTime());
		user.setUsername(userDemo.getUsername());
		return user;
	}
	public static Task taskDemoToTask(TaskDemo taskDemo)
	{
		Task task =new Task();
		task.setBizCatgId(taskDemo.getBizCatgId());
		task.setBizEntity(taskDemo.getBizEntity());
		task.setEndNode(taskDemo.getEndNode());
		task.setEndTm(taskDemo.getEndTm());
		task.setId(taskDemo.getId());
		task.setLimitTm(taskDemo.getLimitTm());
		task.setStartNode(taskDemo.getStartNode());
		task.setStatus(taskDemo.getStatus());
		task.setStartTm(taskDemo.getStartTm());
		task.setTaskType(taskDemo.getTaskType());
		return task;
	}
	public static TaskDemo taskToTaskDemo(Task taskDemo)
	{
		TaskDemo task =new TaskDemo();
		task.setBizCatgId(taskDemo.getBizCatgId());
		task.setBizEntity(taskDemo.getBizEntity());
		task.setEndNode(taskDemo.getEndNode());
		task.setEndTm(taskDemo.getEndTm());
		task.setId(taskDemo.getId());
		task.setLimitTm(taskDemo.getLimitTm());
		task.setStartNode(taskDemo.getStartNode());
		task.setStatus(taskDemo.getStatus());
		task.setStartTm(taskDemo.getStartTm());
		task.setTaskType(taskDemo.getTaskType());
		return task;
	}
}
