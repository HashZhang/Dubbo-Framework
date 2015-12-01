package com.sf.hash.test.service.demoperformance;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.spring.SpringContainer;

public class Performance extends AbstractJavaSamplerClient {
	private static long start = 0;
	private static long end = 0;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	SpringContainer springContainer = new SpringContainer();
	TestDemo bean;
	public void setupTest(JavaSamplerContext arg0) {

		// 开始时间
		start = System.currentTimeMillis();
		
		springContainer.start();
		ClassPathXmlApplicationContext context = springContainer.getContext();
		bean = context.getBean(TestDemo.class);
	}

	public void teardownTest(JavaSamplerContext arg0) {

		springContainer.stop();
//		// 结束时间
//		end = System.currentTimeMillis();
//		// 总体耗时
//		System.err.println("cost time:" + (end - start) / 1000);
	}

	/**
	 * JMeter界面中可手工输入参数,代码里面通过此方法获取
	 */
	public Arguments getDefaultParameters() {
		Arguments args = new Arguments();
//		args.addArgument("test", symbol);
		return args;
	}

	@Override
	public SampleResult runTest(JavaSamplerContext arg0) {
		SampleResult sr = new SampleResult();

		try {
			sr.sampleStart();
			
			sr.setSuccessful(bean.start());
			sr.sampleEnd();
		} catch (Exception e) {
			logger.error("", e);
			sr.setSuccessful(false);
		}
		return sr;
	}
	
}
