package com.sf.hash.test.manager.user;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.manager.hotdb.service.TaskManager;

@ContextConfiguration(locations = { "/test-manager.xml" })
public class HotdbManagerTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private TaskManager taskManager;
	
	@Test
	public void test()
	{
		TaskDemo taskDemo=new TaskDemo();
		taskDemo.setTaskType("type-test");
		taskDemo.setBizCatgId(11);
		taskDemo.setBizEntity("BizEntity-test");
		taskDemo.setEndNode("endNode-test");
		taskDemo.setStartNode("startNode-test");
		taskDemo.setStatus("1");
		taskManager.addTask(taskDemo);
	}
}
