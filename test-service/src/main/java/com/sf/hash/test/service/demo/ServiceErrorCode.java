package com.sf.hash.test.service.demo;

import com.sf.framework.base.ErrorCode;
import com.sf.framework.utils.SystemUtils;


public interface ServiceErrorCode extends ErrorCode {
	//系统名称
	String SYSTEM_NAME = SystemUtils.getSystemName();
	String SYSTEM_VERSION = SystemUtils.getSystemVersion(ServiceErrorCode.class);
	//系统编号,16进制
	String SYSTEM_NO = SystemUtils.getSystemNo();
	
	String SERVICE_DEMO = "01";  //demo服务
	String INTERFACE_DEMO = "01"; //demo接口
	
}
