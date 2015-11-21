package com.sf.hash.test.dubbo.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.json.JSON;
import com.sf.framework.domain.Request;
import com.sf.framework.domain.Result;
import com.sf.hash.test.domain.Demo;
import com.sf.hash.test.service.demo.DemoRestService;
import com.sf.hash.test.service.demo.DemoService;

public class DemoAction {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private DemoService demoService;
	
	private DemoRestService demoRestService;

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

	public void setDemoRestService(DemoRestService demoRestService) {
		this.demoRestService = demoRestService;
	}

	public void start() throws Exception {
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            try {
            	Request<String> request = new Request<String>();
            	request.setObj("world" + i);
            	
            	Result<String> hello = demoService.sayHello(request);
            	logger.info("[{}] {}", new SimpleDateFormat("HH:mm:ss").format(new Date()), hello.getObj());
                
                Demo demo = demoRestService.getDemo(1);
                logger.info(JSON.json(demo));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
        }
	}
	
}
