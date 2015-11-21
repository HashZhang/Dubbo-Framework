package com.sf.hash.test.manager.demo;

import java.util.List;

import com.sf.hash.test.dao.domain.demo.DemoTest;
import com.sf.hash.test.dao.domain.demo.extend.DemoTestExtend;
import com.sf.hash.test.domain.Demo;

public interface DemoManager {
	
	List<DemoTestExtend> selectAll();
	
	int deleteDemo(Demo demo);
	
	int insertDemo(Demo demo);
	
	DemoTest selectByCode(String code);
}
