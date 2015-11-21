package com.sf.hash.test.dao.user;

import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.sf.hash.test.dao.domain.demo.DemoTest;
import com.sf.hash.test.dao.domain.demo.extend.DemoTestExtend;
import com.sf.hash.test.dao.domain.user.Customer;
import com.sf.hash.test.dao.mapper.demo.DemoTestMapper;
import com.sf.hash.test.dao.mapper.user.CustomerMapper;

/**
 * DAO单元测试
 * 
 * 测试完成后自动回滚,可回归重复测试
 * 
 * @author 862911
 */
@ContextConfiguration(locations = { "/test-dao.xml" })
public class CustomerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Test
	public void generateCustomer() throws InterruptedException {
		CustomerThread ct=new CustomerThread(customerMapper);
		Thread thread=new Thread(ct);
		thread.start();
		thread.join();
	}
}
