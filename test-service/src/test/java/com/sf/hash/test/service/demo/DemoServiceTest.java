package com.sf.hash.test.service.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.sf.framework.domain.Request;
import com.sf.framework.domain.Result;
import com.sf.hash.test.domain.Demo;

/**
 * 在spring容器中做单元测试，不通过dubbo客户端调用
 * 
 * @author 709166
 *
 */
@ContextConfiguration(locations = { "/test-service.xml" })
public class DemoServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DemoService demoService;

	@Autowired
	private DemoRestService demoRestService;

	@Test
	public void test() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			try {
				Request<String> request = new Request<String>();
				request.setObj("world" + i);

				Result<String> hello = demoService.sayHello(request);
				logger.info("[{}] {}", new SimpleDateFormat("HH:mm:ss").format(new Date()), hello.getObj());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(2000);
		}
	}
	
	@Test
	public void testGetDemo() {
		String url = "http://localhost:8888/services/demo/1";
		
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().get();
        try {
            Assert.assertEquals(200, response.getStatus());
            logger.info("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
	}
	
	@Test
	public void testRegisterDemo() {
		String url = "http://localhost:8888/services/demo/register";
		
		logger.info("Registering user via " + url);
		Demo record = new Demo();
		//record.setId(33);
		record.setCode("test1");
		record.setName("test111111");
		record.setDescription("just for testing");
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().post(Entity.entity(record, MediaType.APPLICATION_JSON_TYPE));

        try {
            Assert.assertEquals(200, response.getStatus());
            logger.info("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
	}
}
