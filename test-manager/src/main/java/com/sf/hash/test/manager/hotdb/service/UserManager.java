package com.sf.hash.test.manager.hotdb.service;

import java.util.List;

import com.sf.hash.test.dao.domain.task.Task;
import com.sf.hash.test.dao.domain.user.User;
import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;

public interface UserManager {
	public int addUser(UserDemo userDemo);
	public int deleteUserByPrimaryKey(long userID);
	public int updateUserByPrimaryKey(UserDemo userDemo);
	public UserDemo selectUserByPrimaryKey(long userID);
	public List<TaskDemo> getTasksByUserID(long userID);
}
