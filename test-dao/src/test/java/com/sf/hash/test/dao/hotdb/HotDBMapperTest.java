package com.sf.hash.test.dao.hotdb;

import java.util.Date;

import com.sf.hash.test.dao.domain.task.Task;
import com.sf.hash.test.dao.domain.user.User;
import com.sf.hash.test.dao.mapper.task.TaskMapper;
import com.sf.hash.test.dao.mapper.task.TaskUserMapper;
import com.sf.hash.test.dao.mapper.user.UserMapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration(locations = { "/test-dao.xml" })
@TestExecutionListeners(value={TransactionalTestExecutionListener.class})
public class HotDBMapperTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private TaskUserMapper taskUserMapper;
	@Test
	@Transactional
	public void test(){
		System.out.println("\nTest starts!****************************\n");
//		System.out.println(userMapper.selectByPrimaryKey(1l).toString());
//		System.out.println(taskMapper.selectByPrimaryKey(1l).toString());
//		List<Task> tasks=taskUserMapper.selectTaskByUserID(1l);
//		for(Task task:tasks)
//			System.out.println(task.toString());
//		List<User> users=taskUserMapper.selectUserByTaskID(2l);
//		for(User user:users)
//			System.out.println(user.toString());
		Task task=new Task();
		task.setBizCatgId(2);
		task.setBizEntity("Entity");
		task.setEndNode("ed");
		task.setStartNode("st");
		task.setStatus("1");
		task.setTaskType("O2O");
		taskMapper.insert(task);
		User userDemo=new User();
		userDemo.setUsername("restNewUser");
		userDemo.setPassword("test");
		userDemo.setAuthType("rest create auth");
		userDemo.setStatus("1");
		userDemo.setCreateTime(new Date());//可以不填
		userDemo.setUpdateTime(new Date());//可以不填
		userMapper.insert(userDemo);
		System.out.println("\nTest ends!****************************\n");
	}
}
