package com.sf.hash.test.dao.user;

import java.sql.Date;
import java.util.Random;

import com.sf.hash.test.dao.domain.user.Customer;
import com.sf.hash.test.dao.mapper.user.CustomerMapper;

public class CustomerThread implements Runnable {
	private CustomerMapper customerMapper;
	public CustomerThread(CustomerMapper customerMapper) {
		super();
		this.customerMapper = customerMapper;
	}
	@Override
	public void run() {
		Customer customer=new Customer();
		for(int i=0;i<300;i++)
		{
			customer.setCreateTime(new Date(System.currentTimeMillis()));
			customer.setMobile(Thread.currentThread().getName()+" Mobile: "+i);
			customer.setName(Thread.currentThread().getName()+" Name: "+i);
			customer.setOrgCode(Thread.currentThread().getName()+" OrgCode: "+i);
			customer.setPinCode(Thread.currentThread().getName()+" PinCode: "+i);
			if(i%2==0)
				customer.setSex("M");
			else
				customer.setSex("F");
			customer.setUpdateTime(new Date(System.currentTimeMillis()));
			customerMapper.insertSelective(customer);
		}
	}

}
