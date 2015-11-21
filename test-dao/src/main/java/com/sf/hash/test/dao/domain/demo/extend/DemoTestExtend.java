package com.sf.hash.test.dao.domain.demo.extend;

import java.io.Serializable;

import com.sf.hash.test.dao.domain.demo.DemoTest;

/**
 * 
 * @author 709166
 *
 */
public class DemoTestExtend extends DemoTest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 层级
	 * 1 - 顶层
	 * 2 - 第二层
	 * 3 - 第三层
	 */
	private Integer demoLevel;
	
	/**
	 * 层级名称
	 */
	private String demoLevelName;

	public Integer getDemoLevel() {
		return demoLevel;
	}

	public void setDemoLevel(Integer demoLevel) {
		this.demoLevel = demoLevel;
	}

	public String getDemoLevelName() {
		return demoLevelName;
	}

	public void setDemoLevelName(String demoLevelName) {
		this.demoLevelName = demoLevelName;
	}
	
}
