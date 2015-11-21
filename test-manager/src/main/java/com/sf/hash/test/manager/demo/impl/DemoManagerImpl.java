package com.sf.hash.test.manager.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sf.hash.test.dao.domain.demo.DemoTest;
import com.sf.hash.test.dao.domain.demo.extend.DemoTestExtend;
import com.sf.hash.test.dao.mapper.demo.DemoTestMapper;
import com.sf.hash.test.domain.Demo;
import com.sf.hash.test.manager.demo.DemoManager;

@Component
public class DemoManagerImpl implements DemoManager {

	@Autowired
	private DemoTestMapper demoTestMapper;

	public List<DemoTestExtend> selectAll() {
		return demoTestMapper.selectAll();
	}

	public int deleteDemo(Demo demo) {
		return demoTestMapper.deleteByCode(demo.getCode());
	}

	@Override
	public int insertDemo(Demo demo) {
		
		DemoTest demoTest = new DemoTest();
		demoTest.setId(demo.getId());
		demoTest.setName(demo.getName());
		demoTest.setCode(demo.getCode());
		demoTest.setComment(demo.getComment());
		demoTest.setDescription(demo.getDescription());
		
		return demoTestMapper.insert(demoTest);
	}

	@Override
	public DemoTest selectByCode(String code) {
		List<DemoTest> all = demoTestMapper.selectByCode(code);
		return all != null ? all.get(0) : null;
	}

}
