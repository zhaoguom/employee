package com.zhaoguom.employee.service;

import com.zhaoguom.employee.dataobject.EmployeeDO;
import com.zhaoguom.employee.error.BusinessException;

import java.util.List;

public interface EmployeeService {
        List<EmployeeDO> getAllEmployees();

        EmployeeDO getEmployeeById(Integer id) throws BusinessException;

        EmployeeDO createOrUpdateEmployee(EmployeeDO employeeDO);

        void deleteEmployeeById(Integer id) throws BusinessException;

}
