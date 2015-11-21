package com.sf.hash.test.service.demo;

import com.sf.framework.domain.Request;
import com.sf.framework.domain.Result;

/**
 * the demo interface of dubbo service 
 * 
 * @author 709166
 */
public interface DemoService {
	
	Result<String> sayHello(Request<String> request);
}
