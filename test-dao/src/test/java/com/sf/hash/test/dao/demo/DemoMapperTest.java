package com.sf.hash.test.dao.demo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.sf.hash.test.dao.domain.demo.DemoTest;
import com.sf.hash.test.dao.domain.demo.extend.DemoTestExtend;
import com.sf.hash.test.dao.mapper.demo.DemoTestMapper;

/**
 * DAO单元测试
 * 
 * 测试完成后自动回滚,可回归重复测试
 * 
 * @author 709166
 */
@ContextConfiguration(locations = { "/test-dao.xml" })
public class DemoMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private DemoTestMapper demoTestMapper;
	
	@Test
	public void testSelectByPrimaryKey() {
		Integer id = 1;

		//数据库存在此记录
		DemoTest demo = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNotNull(demo);
		Assert.assertEquals("test", demo.getCode());
	}
	
	@Test
	public void testInsert() {
		Integer id = 2;
		String code = "test2";
		String name = "test2";
		String description = "just for testing";
		
		//构造要插入的实体类
		DemoTest record = new DemoTest();
		record.setId(id);
		record.setCode(code);
		record.setName(code);
		record.setDescription(description);
		
		//插入
		int count = demoTestMapper.insert(record);
		Assert.assertEquals(1, count);
		
		//判断插入的记录的数据是否正确
		DemoTest demo = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNotNull(demo);
		Assert.assertEquals(code, demo.getCode());
		Assert.assertEquals(name, demo.getName());
		Assert.assertEquals(description, demo.getDescription());

	}

	@Test
	public void testDeleteByPrimaryKey() {
		Integer id = 1;

		//数据库存在此记录
		DemoTest demo = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNotNull(demo);
		
		//删除
		int count = demoTestMapper.deleteByPrimaryKey(id);
		Assert.assertEquals(1, count);
		
		//判断是否删除逻辑正确
		demo = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNull(demo);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		Integer id = 1;
		String name = "testName";

		//数据库存在此记录并且设置需要更改的字段
		DemoTest demo = demoTestMapper.selectByPrimaryKey(id);
		demo.setName(name);
		
		//更新
		int count = demoTestMapper.updateByPrimaryKey(demo);
		Assert.assertEquals(1, count);
		
		//判断是否更新逻辑正确
		DemoTest demoAgain = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNotNull(demoAgain);
		Assert.assertEquals(name, demoAgain.getName());
	}

	@Test
	public void testSelectAll() {
		List<DemoTestExtend> all = demoTestMapper.selectAll();
		Assert.assertTrue(all.size()>0);
		
	}

	@Test
	public void testDeleteByCode() {
		Integer id = 1;

		//数据库存在此记录
		DemoTest demo = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNotNull(demo);
		
		//删除
		String code = demo.getCode();
		int count = demoTestMapper.deleteByCode(code);
		Assert.assertEquals(1, count);
		
		//判断是否删除逻辑正确
		demo = demoTestMapper.selectByPrimaryKey(id);
		Assert.assertNull(demo);
	}
}
