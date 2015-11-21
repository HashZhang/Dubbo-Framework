package com.sf.hash.test.dubbo.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.dubbo.common.json.JSON;
import com.sf.framework.domain.Request;
import com.sf.framework.domain.Result;
import com.sf.hash.test.domain.Demo;
import com.sf.hash.test.service.demo.DemoRestService;
import com.sf.hash.test.service.demo.DemoService;

@ContextConfiguration(locations = { "/test-service.xml" })
public class DemoActionTest extends AbstractJUnit4SpringContextTests {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	private DemoRestService demoRestService;

	@Test
	public void start() throws Exception {
		for (int i = 0; i < 10; i++) {
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
