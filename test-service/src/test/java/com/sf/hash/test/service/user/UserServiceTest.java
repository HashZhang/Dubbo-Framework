package com.sf.hash.test.service.user;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.sf.hash.test.domain.UserDemo;


@ContextConfiguration(locations = { "/test-service.xml" })
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	UserDemo userDemo=new UserDemo();
	//得到某一用戶的信息
	@Test
	public void testGetUser() {
		String url = "http://localhost:8888/services/user/1";
		
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().get();
        try {
            Assert.assertEquals(200, response.getStatus());
            System.out.println("Successfully got user 1's imfromation: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
	}
	//得到某一用戶的所有tasks
	@Test
	public void testGetUserTasks() {
		String url = "http://localhost:8888/services/user/1/tasks";
		
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().get();
        try {
            Assert.assertEquals(200, response.getStatus());
            System.out.println("Successfully got user 1's tasks: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
	}
	@Test
	public void testAddUser() {
		String url = "http://localhost:8888/services/user/add";
		
		userDemo.setUsername("restNewUser");
		userDemo.setPassword("test");
		userDemo.setAuthType("rest create auth");
		userDemo.setStatus("1");
		userDemo.setCreateTime(new Date());//可以不填
		userDemo.setUpdateTime(new Date());//可以不填
		userDemo.setId(2l);//可以不填，這裡為了測試
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().post(Entity.entity(userDemo, MediaType.APPLICATION_JSON_TYPE));
        try {
            Assert.assertEquals(200, response.getStatus());
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
	}
	@Test
	public void testUpdateUser() {
		String url = "http://localhost:8888/services/user/update";
		
		userDemo.setUsername("NewName");
		userDemo.setPassword("NewPassword");
		userDemo.setAuthType("rest create auth");
		userDemo.setStatus("1");
		userDemo.setCreateTime(new Date());//可以不填
		userDemo.setUpdateTime(new Date());//可以不填
		userDemo.setId(2l);//可以不填，這裡為了測試
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().post(Entity.entity(userDemo, MediaType.APPLICATION_JSON_TYPE));
        try {
        	Assert.assertEquals(200, response.getStatus());
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
	}
	@Test
	public void testDeleteUser() {
		String url = "http://localhost:8888/services/user/delete/2";
		
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().delete();
        try {
            Assert.assertEquals(200, response.getStatus());
            System.out.println("Successfully got result: " + response.readEntity(String.class));
        } finally {
            response.close();
            client.close();
        }
	}
}
