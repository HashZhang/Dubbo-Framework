package com.sf.hash.test.manager.hotdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.hash.test.dao.domain.task.TaskUser;
import com.sf.hash.test.dao.mapper.task.TaskUserMapper;
import com.sf.hash.test.domain.TaskUserDemo;
import com.sf.hash.test.manager.hotdb.service.TaskUserManager;
@Component
public class TaskUserManagerImpl implements TaskUserManager {
	@Autowired
	private TaskUserMapper taskUserMapper;
	@Override
	public int addTaskUser(TaskUserDemo taskUserDemo) {
		TaskUser taskUser=new TaskUser();
		taskUser.setId(taskUserDemo.getId());
		taskUser.setTaskid(taskUserDemo.getTaskid());
		taskUser.setTaskLinitTm(taskUserDemo.getTaskLinitTm());
		taskUser.setTaskStatus(taskUserDemo.getTaskStatus());
		taskUser.setUserid(taskUserDemo.getUserid());
		taskUser.setUserStatus(taskUserDemo.getUserStatus());
		taskUser.setUserUsername(taskUserDemo.getUserUsername());
		return taskUserMapper.insert(taskUser);
	}

}
