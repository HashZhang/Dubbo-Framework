package com.sf.hash.test.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.hash.test.domain.TaskUserDemo;
import com.sf.hash.test.manager.hotdb.service.TaskUserManager;
@Service
public class TaskUserRestServiceImpl implements TaskUserRestService {
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

}
