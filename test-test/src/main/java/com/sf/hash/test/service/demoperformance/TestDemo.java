package com.sf.hash.test.service.demoperformance;

import com.sf.hash.test.service.task.TaskService;
import com.sf.hash.test.service.task.TaskUserService;
import com.sf.hash.test.service.user.UserService;

public class TestDemo {
	private TaskService taskService;
	private TaskUserService taskUserService;
	private UserService userService;

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public void setTaskUserService(TaskUserService taskUserService) {
		this.taskUserService = taskUserService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public boolean start() throws Exception {
			String i=taskService.addTask();

			return "Insert Successfully!".equals(i);
	}

}
