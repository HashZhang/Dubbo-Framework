package com.sf.hash.test.service.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;
import com.sf.hash.test.manager.hotdb.service.TaskManager;
@Service
public class TaskRestServiceImpl implements TaskRestService {
	@Autowired
	private TaskManager taskManager;

	@Override
	public TaskDemo getTask(Integer id) {
		return taskManager.selectTaskByPrimaryKey(id);
	}

	@Override
	public String addTask(TaskDemo taskDemo) {
		if(taskManager.addTask(taskDemo)!=0){
			return "Insert Successfully!";
		}else{
			return "Insert Failed!";
		}
	}

	@Override
	public String deleteTask(Integer id) {
		if(taskManager.selectTaskByPrimaryKey(id)==null)
			return "task does not exists!";
		if(taskManager.deleteTaskByPrimaryKey(id)!=0){
			return "Delete Successfully!";
		}else{
			return "Delete Failed!";
		}
	}

	@Override
	public String updateTask(TaskDemo taskDemo) {
		taskManager.updateTaskByPrimaryKey(taskDemo);
		return "Update complete!";
	}

	@Override
	public List<UserDemo> taskUsers(Integer id) {
		return taskManager.getUsersByTaskID(id);
	}

}
