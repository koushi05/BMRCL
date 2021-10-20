package com.example.metrodemo.EmpControler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.metrodemo.Emp_Entity.EmployeData;
import com.example.metrodemo.Emp_Entity.TicketCounterData;
import com.example.metrodemo.Emp_Repo.EmployeRepo;
import com.example.metrodemo.Emp_Repo.TicketCounterRepo;

@Controller
@RequestMapping("/employe/")
public class EmployeControler {

	@Autowired
	private EmployeRepo empRepo;

	@GetMapping("home")
	public String homePage(EmployeData employedata) {
		return "home";
	}

	@GetMapping("list")
	public String Employee(Model model) {
		model.addAttribute("employedata", this.empRepo.findAll());
		return "empview";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("employedata", new EmployeData());
		return "employereg";
	}

	@PostMapping("add")
	public String employeRegi(EmployeData employedata, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "employereg";
		}
		this.empRepo.save(employedata);
		String message = "Employe	Data Added Sucessfully";
		model.addAttribute("message", message);
		return "home";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		EmployeData employedata = this.empRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Employee id : " + id));

		model.addAttribute("employedata", employedata);
		return "updateemploye";
	}

	@PostMapping("update/{id}")
	public String updateEmpProcess(@PathVariable("id") long id, @Validated EmployeData employedata,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			employedata.setEid(id);
			return "updateemploye";
		}

		// update employee
		empRepo.save(employedata);
		// get all employees ( with update)
		model.addAttribute("employedata", this.empRepo.findAll());
		String message = "Employe Data Updated Sucessfully";
		model.addAttribute("message", message);
		return "home";
	}


	@GetMapping("delete/{id}")
	public String deleteEmploye(@PathVariable("id") long id, Model model) {

		EmployeData employedata = this.empRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Employee id : " + id));

		this.empRepo.delete(employedata);
		model.addAttribute("employedata", this.empRepo.findAll());
		String delete = "Ticket Details Updated Sucessfully";
		model.addAttribute("delete", delete);
		return "home";

	}

	/* Ticket Counter controller starts from here */

	@Autowired
	private TicketCounterRepo ticketcounterrepo;

	@GetMapping("view")
	public String Ticket(Model model) {
		model.addAttribute("ticketcounterdata", this.ticketcounterrepo.findAll());
		return "ticketview";
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("ticketcounterdata", new TicketCounterData());
		return "ticketentry";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String ticketRegister(TicketCounterData ticketcounterdata, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "ticketentry";
		}
		this.ticketcounterrepo.save(ticketcounterdata);
		String message = "Ticket Details Added Sucessfully";
		model.addAttribute("message", message);
		return "home";
	}

	@GetMapping("tedit/{id}")
	public String showUpdatedTicket(@PathVariable("id") long id, Model model) {
		TicketCounterData ticketCounterData = this.ticketcounterrepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Ticket id : " + id));

		model.addAttribute("ticketCounterData", ticketCounterData);
		return "updateticket";
	}

	
	  
	/*
	 * @RequestMapping(value = "tupdate/{id}", method = RequestMethod.GET) public
	 * String tupdate(Model model) { model.addAttribute("ticketCounterData", new
	 * TicketCounterData()); return "home"; }
	 */
	 

	@PostMapping("tupdate/{id}")
	public String updateTicketProcess(@PathVariable("id") long id,@Validated TicketCounterData ticketCounterData,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			ticketCounterData.setTid(id);
			return "updateticket";
		}

		// update employee
		ticketcounterrepo.save(ticketCounterData);

		// get all employees ( with update)
		model.addAttribute("ticketCounterData", this.ticketcounterrepo.findAll());
		String message = "Ticket Details Updated Sucessfully";
		model.addAttribute("message", message);
		return "home";
	}

	@GetMapping("tdelete/{id}")
	public String deleteTicket(@PathVariable("id") long id, Model model) {

		TicketCounterData ticketCounterData = this.ticketcounterrepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Ticket id : " + id));

		this.ticketcounterrepo.delete(ticketCounterData);
		model.addAttribute("ticketCounterData", this.ticketcounterrepo.findAll());
		String delete = "Ticket Details Updated Sucessfully";
		model.addAttribute("delete", delete);
		return "home";

	}

}
