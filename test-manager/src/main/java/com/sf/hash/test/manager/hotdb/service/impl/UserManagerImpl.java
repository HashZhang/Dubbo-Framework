package com.sf.hash.test.manager.hotdb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.hash.test.dao.domain.task.Task;
import com.sf.hash.test.dao.domain.user.User;
import com.sf.hash.test.dao.mapper.task.TaskUserMapper;
import com.sf.hash.test.dao.mapper.user.UserMapper;
import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;
import com.sf.hash.test.manager.domain.util.domainTransfer;
import com.sf.hash.test.manager.hotdb.service.UserManager;
@Component
public class UserManagerImpl implements UserManager {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TaskUserMapper taskUserMapper;
	@Override
	public int addUser(UserDemo userDemo) {
		return userMapper.insert(domainTransfer.userDemoToUser(userDemo));
	}

	@Override
	public int deleteUserByPrimaryKey(long userID) {
		return userMapper.deleteByPrimaryKey(userID);
	}

	@Override
	public int updateUserByPrimaryKey(UserDemo userDemo) {
		User user=domainTransfer.userDemoToUser(userDemo);
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public UserDemo selectUserByPrimaryKey(long userID) {
		User user=userMapper.selectByPrimaryKey(userID);
		return user==null?null:domainTransfer.userToUserDemo(user);
	}

	@Override
	public List<TaskDemo> getTasksByUserID(long userID) {
		List<Task> tasks=taskUserMapper.selectTaskByUserID(userID);
		List<TaskDemo> taskDemos=new ArrayList<TaskDemo>();
		for(int i=0;i<tasks.size();i++){
			taskDemos.add(domainTransfer.taskToTaskDemo(tasks.get(i)));
		}
		return taskDemos;
	}
	
}
