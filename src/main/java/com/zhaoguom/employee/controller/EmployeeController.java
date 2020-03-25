package com.zhaoguom.employee.controller;

import java.util.List;
import java.util.Optional;

import com.zhaoguom.employee.dataobject.EmployeeDO;
import com.zhaoguom.employee.error.BusinessException;
import com.zhaoguom.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping
    public String getAllEmployees(Model model) {
        List<EmployeeDO> list = employeeService.getAllEmployees();
        model.addAttribute("employees", list);
        return "list-employees";
     }

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Integer> id) throws BusinessException {
		if(id.isPresent()) {
			EmployeeDO employeeDO = employeeService.getEmployeeById(id.get());
			model.addAttribute("employee", employeeDO);
		} else {
			model.addAttribute("employee", new EmployeeDO());
		}
		return "add-edit-employee";
	}
	
	@RequestMapping(path="/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Integer id) throws BusinessException {
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	@RequestMapping(path = "/createEmployee", method=RequestMethod.POST)
	public String createOrUpdateEmployee(EmployeeDO employeeDO) {
		employeeService.createOrUpdateEmployee(employeeDO);
		return "redirect:/";
	}
}