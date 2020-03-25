package com.zhaoguom.employee.controller;

import com.zhaoguom.employee.dao.EmployeeDOMapper;
import com.zhaoguom.employee.dataobject.EmployeeDO;
import com.zhaoguom.employee.error.BusinessErrorEnum;
import com.zhaoguom.employee.error.BusinessException;
import com.zhaoguom.employee.response.CommonReturnType;
import com.zhaoguom.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class EmployeeAPIController extends  BaseController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getEmployee(@PathVariable(value = "id") Integer id) throws BusinessException {
        EmployeeDO employeeDO = employeeService.getEmployeeById(id);
        if(employeeDO==null){
            throw new BusinessException(BusinessErrorEnum.USER_NOT_EXIST);
        } else{
            return CommonReturnType.create(employeeDO);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getAllEmployees() throws BusinessException {
        List<EmployeeDO> employees = employeeService.getAllEmployees();
        if(employees.size()==0){
            throw new BusinessException(BusinessErrorEnum.USER_NOT_EXIST);
        } else{
            return CommonReturnType.create(employees);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType createEmployee(@RequestBody EmployeeDO employeeDO){
        EmployeeDO newEmployee = employeeService.createOrUpdateEmployee(employeeDO);
        return CommonReturnType.create(newEmployee);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CommonReturnType updateEmployee(@PathVariable(value = "id") Integer id,
                                           @RequestBody EmployeeDO employee) throws BusinessException {

        EmployeeDO employeeDO = employeeService.getEmployeeById(id);
        if(employeeDO==null){
            throw new BusinessException(BusinessErrorEnum.USER_NOT_EXIST);
        } else{
            employee.setId(id);
            employeeService.createOrUpdateEmployee(employee);
            return CommonReturnType.create(employee);
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonReturnType deleteEmployee(@PathVariable(value = "id") Integer id) throws BusinessException {

        EmployeeDO employeeDO = employeeService.getEmployeeById(id);
        if(employeeDO==null){
            throw new BusinessException(BusinessErrorEnum.USER_NOT_EXIST);
        } else{
            employeeService.deleteEmployeeById(id);
            return CommonReturnType.create(null);
        }
    }
}
