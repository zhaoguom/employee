package com.zhaoguom.employee.test;
import com.zhaoguom.employee.dataobject.EmployeeDO;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import io.restassured.response.Response;
import static org.hamcrest.Matcher.*;
import org.testng.annotations.Test;
import com.alibaba.fastjson.JSON;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class EmployeeServiceTest {

    @Test
    public void testCreateEmployee(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8089;
        RestAssured.basePath = "api";
        EmployeeDO employeeDO= new EmployeeDO();
        employeeDO.setFirstName("zhaoguo");
        employeeDO.setLastName("ma");
        employeeDO.setEmail("zhaoguo.ma@gmail.com");
        Response response = given().header("Content-Type", "application/json")
                .body(JSON.toJSONString(employeeDO)).when()
                .post("users");

        assertEquals(employeeDO.getEmail(),response.then().extract().path("data.email"));
        assertEquals(employeeDO.getFirstName(),response.then().extract().path("data.firstName"));
        assertEquals(employeeDO.getLastName(),response.then().extract().path("data.lastName"));
        Integer employeeID = (Integer)response.then().extract().path("data.id");

        response = given().header("Content-Type", "application/json")
                .body(JSON.toJSONString(employeeDO)).when()
                .get("users/" + employeeID.toString());
        assertEquals(employeeDO.getEmail(),response.then().extract().path("data.email"));
        assertEquals(employeeDO.getFirstName(),response.then().extract().path("data.firstName"));
        assertEquals(employeeDO.getLastName(),response.then().extract().path("data.lastName"));
    }
}
