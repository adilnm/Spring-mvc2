package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.EmployeeDao;
import com.service.EmployeeService;

@Controller

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping("/loginn") // in url u need to write it to call login.jsp
	String showLoginPage() {
		return "login";

	}

	// without using service layer
//	@PostMapping("/authenticate")
//	String authenticateEmployee(@RequestParam String emailId, @RequestParam String password, Model model) {
//		System.out.println(emailId + " " + password);
//		EmployeeEntity employeeEntity = employeeDao.authenticate(emailId, password);
//		if (employeeEntity != null) {
//			model.addAttribute("employee", employeeEntity);
//			return "showEmployee";
//
//		} else {
//			model.addAttribute("msg", "Wrong credential..");
//			return "login";
//		}
//
//	}
//
//	@GetMapping("/showEmployees") // in url u need to write it to call login.jsp
//	String showAllEmployess(Model model) {
//		List<EmployeeEntity> employeesList = employeeDao.findAllEmployees();
//		model.addAttribute("employeesList", employeesList);
//
//		return "showAllEmployees";
//
//	}

	String authenticateEmployee(@RequestParam String emailId, @RequestParam String password, Model model) {
		employeeService.authenticate(emailId, password);
		return "showEmployee";
	}

}
