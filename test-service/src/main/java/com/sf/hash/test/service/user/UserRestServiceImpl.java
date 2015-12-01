package com.sf.hash.test.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.hash.test.dao.domain.user.User;
import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;
import com.sf.hash.test.manager.domain.util.domainTransfer;
import com.sf.hash.test.manager.hotdb.service.TaskUserManager;
import com.sf.hash.test.manager.hotdb.service.UserManager;
@Service
public class UserRestServiceImpl implements UserRestService {
	@Autowired
	private UserManager userManager;

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
}
