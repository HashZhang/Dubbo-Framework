package com.sf.hash.test.service.user;

import java.util.List;

import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;

public interface UserService {
	UserDemo getUser(Integer id);
	String addUser(UserDemo userDemo);
	String addUser();
	String deleteUser(Integer id);
	String updateUser(UserDemo userDemo);
	List<TaskDemo> userTasks(Integer id);
	int getCount();
}
