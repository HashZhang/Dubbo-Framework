package com.sf.hash.test.service.user;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;
import com.sf.hash.test.manager.hotdb.service.UserManager;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserManager userManager;
	private int count=1;
	
	@Override
	public UserDemo getUser(Integer id) {
		return userManager.selectUserByPrimaryKey(id);
	}

	@Override
	public String addUser(UserDemo userDemo) {
		if(userManager.addUser(userDemo)!=0){
			return "Insert Successfully! New User:"+userDemo.getUsername();
		}else{
			return "Insert Failed!";
		}
	}

	@Override
	public String addUser() {
		UserDemo user=new UserDemo();
		user.setAuthType("Authtype"+count);
		user.setCreateTime(new Date(System.currentTimeMillis()));
		user.setPassword("password"+count);
		user.setStatus(""+(count%3));
		user.setUpdateTime(new Date(System.currentTimeMillis()));
		user.setUsername("user"+count);
		count++;
		return addUser(user);
	}

	@Override
	public String deleteUser(Integer id) {
		if(userManager.selectUserByPrimaryKey(id)==null)
			return "User does not exists!";
		if(userManager.deleteUserByPrimaryKey(id)!=0){
			return "Delete Successfully!";
		}else{
			return "Delete Failed!";
		}
	}

	@Override
	public String updateUser(UserDemo userDemo) {
		userManager.updateUserByPrimaryKey(userDemo);
		return "Update complete!";
	}

	@Override
	public List<TaskDemo> userTasks(Integer id) {
		return userManager.getTasksByUserID(id);
	}

	@Override
	public int getCount() {
		return count;
	}

}
