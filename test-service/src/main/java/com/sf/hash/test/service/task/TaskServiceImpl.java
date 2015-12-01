package com.sf.hash.test.service.task;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;
import com.sf.hash.test.manager.hotdb.service.TaskManager;
@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskManager taskManager;
	
	private int count=1;
	
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

	@Override
	public String addTask() {
		TaskDemo task =new TaskDemo();
		task.setBizCatgId(count);
		task.setBizEntity("Entity"+count);
		task.setEndNode("endNode"+count);
		task.setEndTm(new Date(System.currentTimeMillis()));
		task.setLimitTm(new Date(System.currentTimeMillis()));
		task.setStartNode("startNode"+count);
		task.setStatus(""+(count)%3);
		task.setStartTm(new Date(System.currentTimeMillis()));
		task.setTaskType("type"+(count)%5);
		count++;
		return addTask(task);
	}

	@Override
	public int getCount() {
		return count;
	}

}
