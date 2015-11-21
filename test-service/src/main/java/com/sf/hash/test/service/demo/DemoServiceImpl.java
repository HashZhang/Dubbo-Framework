package com.sf.hash.test.service.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.sf.framework.domain.Request;
import com.sf.framework.domain.Result;
import com.sf.hash.test.manager.demo.DemoManager;

@Service
public class DemoServiceImpl implements DemoService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DemoManager demoManager;

	@Override
	public Result<String> sayHello(Request<String> request) {
		String name = request.getObj();
		logger.info("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
		String response = "Hello " + name + ", response from service: " + RpcContext.getContext().getLocalAddress();
		
		Result<String> result = new Result<String>(true);
		result.setObj(response);
		return result;
	}

}
