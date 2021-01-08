package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;
import com.service.EmployeeService;

@Controller

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeDao employeeDao;

	@GetMapping("/login")
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

	@PostMapping("/authenticate")
	String authenticateEmployee(@RequestParam String emailId, @RequestParam String password, Model model) {
		EmployeeDTO employeeDTO = employeeService.authenticate(emailId, password);
		if (employeeDTO != null) {
			model.addAttribute("employee", employeeDTO);
			return "showEmployee";

		} else {
			model.addAttribute("msg", "Wrong credential..");
			return "login";
		}
	}

	@GetMapping("/showEmployees")
	String showAllEmployess(Model model) {
		List<EmployeeEntity> employeesList = employeeService.findAllEmployees();
		model.addAttribute("employeesList", employeesList);

		return "showAllEmployees";

	}

	@GetMapping("/register")
	String register() {
		return "register";

	}

	@PostMapping("/registerEmployee")
	String employeeRegistration(@RequestParam String empName, @RequestParam String emailId,
			@RequestParam String password, @RequestParam int salary, Model model) {
		System.out.println(salary);
		boolean success = employeeService.register(empName, emailId, password, salary);

		if (success) {
			return showAllEmployess(model);

		} else {
			model.addAttribute("msg", "Wrong credential..");
			return "register";
		}
	}

}
