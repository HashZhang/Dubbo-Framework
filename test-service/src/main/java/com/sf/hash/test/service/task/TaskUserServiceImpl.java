package com.sf.hash.test.service.task;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.hash.test.domain.TaskUserDemo;
import com.sf.hash.test.manager.hotdb.service.TaskUserManager;
import com.sf.hash.test.service.user.UserService;
@Service
public class TaskUserServiceImpl implements TaskUserService {
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userSerivce;
	@Autowired
	private TaskUserManager taskUserManager;
	@Override
	public String addTask(TaskUserDemo taskUserDemo) {
		if(taskUserManager.addTaskUser(taskUserDemo)!=0){
			return "Insert Successfully!";
		}else{
			return "Insert Failed!";
		}
	}
	
	@Override
	public String addTask() {
		TaskUserDemo taskUserDemo = new TaskUserDemo();
		taskUserDemo.setTaskid(Math.abs(ThreadLocalRandom.current().nextLong())%taskService.getCount());
		taskUserDemo.setUserid(Math.abs(ThreadLocalRandom.current().nextLong())%userSerivce.getCount());
		return addTask(taskUserDemo);
	}

}
