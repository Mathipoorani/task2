package net.javaguides.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.Exception.ResourceNotFound;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.EmployeeInfo;
import net.javaguides.springboot.repository.EmployeeInfoRepository;
import net.javaguides.springboot.repository.EmployeeRepository;

@Controller
public class EmployeeController {	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeInfoRepository employeeInfoRepository;
	
	@GetMapping("/employeeForm")
	public String showEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employeeform";
	}
	
	@PostMapping("/submitEmployee")
	public String submitEmployeeForm(@ModelAttribute("employee") Employee employee, Model model) {
		Employee savedEmployee = employeeRepository.save(employee);
		model.addAttribute("employeeInfo", new EmployeeInfo());
		model.addAttribute("id", savedEmployee.getEmployeeId());
		return "employeeInfo";
	}
	
	@PostMapping("/submitEmployeeInfo")
	public String submitEmployeeInfo(@ModelAttribute("employeeinfo") EmployeeInfo employeeInfo) {
		employeeInfoRepository.save(employeeInfo);
		return "redirect:/success";
	}
	
	@GetMapping("/success")
	public String showSuccessPage() {
		return "success";
	}
	
	@GetMapping("/employeeDetails")
	public String employeeDetails() {
		return "employeeDetails";
	}
	
	/*@GetMapping("/employeeDetails")
	public String employeeDetails(@RequestParam("name") String name, Model model) {
		//Optional<Employee> employee = employeeRepository.findByName(name);
		Employee employee = employeeRepository.findByName(name);
		if(employee != null) {
			EmployeeInfo employeeInfo = employeeInfoRepository.findById(employee.getEmployeeId());
			model.addAttribute("employee", employee);
			model.addAttribute("employeeInfo", employeeInfo);
		}
		/*else {
			throw new ResourceNotFound("Employee", "Id");
		}
		return "employeeDetails";
	}*/
}
