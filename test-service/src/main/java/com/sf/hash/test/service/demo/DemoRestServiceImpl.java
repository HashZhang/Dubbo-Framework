package com.sf.hash.test.service.demo;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.collections.CollectionUtils;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.remoting.http.servlet.ServletManager;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.sf.framework.domain.Request;
import com.sf.framework.domain.Result;
import com.sf.framework.utils.ConvertDomainUtils;
import com.sf.framework.utils.ErrorCodeUtils;
import com.sf.hash.test.dao.domain.demo.DemoTest;
import com.sf.hash.test.dao.domain.demo.extend.DemoTestExtend;
import com.sf.hash.test.domain.Demo;
import com.sf.hash.test.manager.demo.DemoManager;

@Service
public class DemoRestServiceImpl implements DemoRestService, ServiceErrorCode{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DemoManager demoManager;

	public Demo getDemo(final Integer id) {
		ServletContext servletContext = ServletManager.getInstance().getServletContext(8888);
		logger.info("=============>>>{}", servletContext==null?servletContext:servletContext.getServerInfo());
		
		List<DemoTestExtend> all = demoManager.selectAll();
		Collection<DemoTestExtend> filterColl = Collections2.filter(all, new Predicate<DemoTestExtend>(){

			@Override
			public boolean apply(DemoTestExtend input) {
				if (input != null && input.getId().toString().equals(id.toString())) {
					return true;
				}
				
				return false;
			}
			
		});
		
		if (CollectionUtils.isNotEmpty(filterColl)) {
			for (DemoTestExtend demoTestExtend : filterColl) {
				Demo demo = new Demo();
				demo.setId(id);
				demo.setName(demoTestExtend.getName());
				demo.setCode(demoTestExtend.getCode());
				demo.setComment(demoTestExtend.getComment());
				demo.setDescription(demoTestExtend.getDescription());
				
				return demo;
			}
		}
		
		return null;
	}

	public Integer registerDemo(Demo demo) {
		demoManager.insertDemo(demo);
		
		DemoTest result = demoManager.selectByCode(demo.getCode());
		return result==null?0:result.getId();
	}

	@Override
	public Result<List<Demo>> query(Request<String> request, Integer id) {
		Result<List<Demo>> result = new Result<List<Demo>>(true);
		
		List<DemoTestExtend> all = demoManager.selectAll();
		if (CollectionUtils.isNotEmpty(all)) {
			List<Demo> list = ConvertDomainUtils.convertList(all, Demo.class);
			result.setObj(list);
		} else {
			result.setSuccess(false);
			String hextoString = ErrorCodeUtils.genCode(SYSTEM_NO, SERVICE_DEMO, INTERFACE_DEMO, BIZ_EMPTY_RESULT);
			result.setErrorCode(hextoString);
		}
		
		return result;
	}

	@Override
	public Result<List<Demo>> queryList(Request<String> request) {
		HttpServletRequest httpRequest = ResteasyProviderFactory.getContextData(HttpServletRequest.class);
		UriInfo uriInfo = ResteasyProviderFactory.getContextData(UriInfo.class);
		HttpHeaders httpHeaders = ResteasyProviderFactory.getContextData(HttpHeaders.class);
		logger.info("httpRequest={}, uriInfo={}, httpHeaders={}", httpRequest, uriInfo, httpHeaders);
		
		Result<List<Demo>> result = new Result<List<Demo>>(true);
		
		List<DemoTestExtend> all = demoManager.selectAll();
		if (CollectionUtils.isNotEmpty(all)) {
			List<Demo> list = ConvertDomainUtils.convertList(all, Demo.class);
			result.setObj(list);
		} else {
			result.setSuccess(false);
			//result.setErrorCode(errorCode);
		}
		
		return result;
	}

}
