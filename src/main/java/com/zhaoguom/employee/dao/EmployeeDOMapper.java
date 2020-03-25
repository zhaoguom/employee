package com.zhaoguom.employee.dao;

import com.zhaoguom.employee.dataobject.EmployeeDO;

import java.util.List;

public interface EmployeeDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Wed Mar 25 14:29:41 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Wed Mar 25 14:29:41 CST 2020
     */
    int insert(EmployeeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Wed Mar 25 14:29:41 CST 2020
     */
    int insertSelective(EmployeeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Wed Mar 25 14:29:41 CST 2020
     */
    EmployeeDO selectByPrimaryKey(Integer id);
    List<EmployeeDO> selectAllEmployee();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Wed Mar 25 14:29:41 CST 2020
     */
    int updateByPrimaryKeySelective(EmployeeDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee
     *
     * @mbg.generated Wed Mar 25 14:29:41 CST 2020
     */
    int updateByPrimaryKey(EmployeeDO record);
}