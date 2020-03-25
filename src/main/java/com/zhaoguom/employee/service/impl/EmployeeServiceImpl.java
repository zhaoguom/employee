package com.zhaoguom.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhaoguom.employee.dao.EmployeeDOMapper;
import com.zhaoguom.employee.dataobject.EmployeeDO;
import com.zhaoguom.employee.error.BusinessErrorEnum;
import com.zhaoguom.employee.error.BusinessException;
import com.zhaoguom.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDOMapper employeeDoMapper;

    @Override
    public List<EmployeeDO> getAllEmployees() {
        List<EmployeeDO> result = employeeDoMapper.selectAllEmployee();
        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<EmployeeDO>();
        }
    }

    @Override
    public EmployeeDO getEmployeeById(Integer id) throws BusinessException {
        EmployeeDO employee = employeeDoMapper.selectByPrimaryKey(id);
        if(employee==null) {
            throw new BusinessException(BusinessErrorEnum.USER_NOT_EXIST);
        }
        return employee;
    }

    @Override
    public EmployeeDO createOrUpdateEmployee(EmployeeDO employeeDO) {
        if(employeeDO.getId() == null) {
            int id = employeeDoMapper.insert(employeeDO);
            return employeeDoMapper.selectByPrimaryKey(id);
        } else {
            EmployeeDO employee = employeeDoMapper.selectByPrimaryKey(employeeDO.getId());
            if(employee!=null) {
                EmployeeDO newEmployee = employee;
                newEmployee.setEmail(employeeDO.getEmail());
                newEmployee.setFirstName(employeeDO.getFirstName());
                newEmployee.setLastName(employeeDO.getLastName());

                int newEmployeeId = employeeDoMapper.updateByPrimaryKey(newEmployee);
                return employeeDoMapper.selectByPrimaryKey(newEmployeeId);
            } else {
                return employeeDoMapper.selectByPrimaryKey(employeeDoMapper.insert(employeeDO));
            }
        }
    }

    @Override
    public void deleteEmployeeById(Integer id) throws BusinessException {
        EmployeeDO employee = employeeDoMapper.selectByPrimaryKey(id);
        if(employee !=null) {
            employeeDoMapper.deleteByPrimaryKey(id);
        } else {
            throw new BusinessException(BusinessErrorEnum.USER_NOT_EXIST);
        }

    }

}
