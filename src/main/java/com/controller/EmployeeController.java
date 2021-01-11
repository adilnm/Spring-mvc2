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
		List<EmployeeDTO> employeesList = employeeService.findAllEmployees();
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

	@GetMapping("/edit")
	String edit(@RequestParam int employee_id, Model model) {
		EmployeeDTO employeeDTO = employeeService.show(employee_id);
		model.addAttribute("employee", employeeDTO);
		return "edit";
	}

	@PostMapping("/update")
	String employeeUpdate(@RequestParam int employeeId, @RequestParam String empName, @RequestParam String emailId,
			@RequestParam String password, @RequestParam int salary, Model model) {

		boolean success = employeeService.update(employeeId, empName, emailId, password, salary);

		if (success) {
			return showAllEmployess(model);
		}
		model.addAttribute("msg", "Wrong credential..");
		return "edit";

	}

	@GetMapping("/delete")
	String employeeDelete(@RequestParam int employee_id, Model model) {
		System.out.println(employee_id);
		boolean success = employeeService.delete(employee_id);
		return showAllEmployess(model);

	}

	@PostMapping("/search")
	String searchEmployee(@RequestParam String employeeName, Model model) {
		EmployeeDTO employeeDTO = employeeService.search(employeeName);
		if (employeeDTO != null) {
			model.addAttribute("employee", employeeDTO);
		} else {
			model.addAttribute("msg", "Employee not found");
		}

		return "search";
	}

}
