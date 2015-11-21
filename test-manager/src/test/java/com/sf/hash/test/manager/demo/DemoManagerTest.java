package com.sf.hash.test.manager.demo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.sf.hash.test.dao.domain.demo.DemoTest;
import com.sf.hash.test.dao.domain.demo.extend.DemoTestExtend;
import com.sf.hash.test.dao.mapper.demo.DemoTestMapper;
import com.sf.hash.test.domain.Demo;

/**
 * Manager单元测试
 * 
 * 测试完成后自动回滚,可回归重复测试
 * 
 * @author 709166
 *
 */
@ContextConfiguration(locations = { "/test-manager.xml" })
public class DemoManagerTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private DemoManager demoManager;
	
	@Autowired
	private DemoTestMapper demoTestMapper;
	
	@Test
	public void selectAll(){
		List<DemoTestExtend> all = demoManager.selectAll();
		Assert.assertTrue(all.size()>0);
	}
	
	@Test
	public void  deleteDemoTest(){
		Integer id = 1;

		//数据库存在此记录
		DemoTest demoTest = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNotNull(demoTest);
		
		//删除
		String code = demoTest.getCode();
		Demo demo = new Demo();
		demo.setCode(code);
		
		int count = demoManager.deleteDemo(demo);
		Assert.assertEquals(1, count);
		
		//判断是否删除逻辑正确
		demoTest = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNull(demoTest);
		
	}
	
	@Test
	public void  insertDemoTest(){
		Integer id = 2;
		String code = "test2";
		String name = "test2";
		String description = "just for testing";
		
		//构造要插入的实体类
		Demo record = new Demo();
		record.setId(id);
		record.setCode(code);
		record.setName(code);
		record.setDescription(description);
		
		//插入
		int count = demoManager.insertDemo(record);
		Assert.assertEquals(1, count);
		
		//判断插入的记录的数据是否正确
		DemoTest demo = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNotNull(demo);
		Assert.assertEquals(code, demo.getCode());
		Assert.assertEquals(name, demo.getName());
		Assert.assertEquals(description, demo.getDescription());
	}
}
