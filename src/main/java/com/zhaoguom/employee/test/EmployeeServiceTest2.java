package com.zhaoguom.employee.test;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Utf8;
import com.zhaoguom.employee.dataobject.EmployeeDO;

import io.restassured.response.Response;
import springfox.documentation.spring.web.json.Json;

public class EmployeeServiceTest2 {

	@Test
	public void TestGet() throws ParseException, IOException {
		
		HttpGet get = new HttpGet("http://localhost:8089/api/users");
		HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        System.out.println(response.getEntity().toString());
        
	}
	
	@DataProvider(name = "createEmployeeData")
    public final Object[][] getMspOrDirectOrganizationInfo() {
        return new Object[][] {
                {"Ma", "Zhaoguo", "zhaoguo.ma@gmail.com"},
        };
    }
	
    @Test(dataProvider = "createEmployeeData")
    public void testCreateEmployee(String firstName, String lastName, String email) throws ClientProtocolException, IOException{
        EmployeeDO employeeDO= new EmployeeDO();
        String prefix = RandomStringUtils.randomAlphabetic(8);
        email = prefix + email;
        firstName = prefix + firstName;
        lastName = prefix + lastName;
        employeeDO.setFirstName(firstName);
        employeeDO.setLastName(lastName);
        employeeDO.setEmail(email);
        
        HttpPost httpPost = new HttpPost("http://localhost:8089/api/users");
        HttpClient client = new DefaultHttpClient();
        httpPost.setEntity(new StringEntity(JSON.toJSONString(employeeDO)));
        HttpResponse response = client.execute(httpPost);
        System.out.println(response.getEntity().toString());
    }
}
