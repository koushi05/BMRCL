package com.example.metrodemo.EmpControler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.metrodemo.Emp_Entity.TicketCounterData;
import com.example.metrodemo.Emp_Repo.TicketCounterRepo;

@Controller
@RequestMapping("/ticket/")
public class TicketControler {

	@Autowired
	private TicketCounterRepo ticketcounterrepo;
	
	@GetMapping("tedit/{id}")
	public String showUpdatedTicket(@PathVariable ("id") long id, Model model) {
		TicketCounterData ticketCounterData= this.ticketcounterrepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Ticket id : " + id));

		model.addAttribute("ticketCounterData", ticketCounterData);
		return "updateticket";
	}

	
	@RequestMapping(value="tupdate/{id}", method = RequestMethod.POST)
	public String updateTicketProcess(@PathVariable("id") long id,TicketCounterData ticketCounterData, BindingResult result, Model model) {
		if(result.hasErrors()) {
			ticketCounterData.setTid(id);
			return "updateticket";
		}

		// update employee
		ticketcounterrepo.save(ticketCounterData);

		// get all employees ( with update)
		model.addAttribute("ticketCounterData", this.ticketcounterrepo.findAll());
		return "home";
	}

	@GetMapping("tdelete/{id}")
	public String deleteTicket(@PathVariable ("id") long id, Model model) {

		TicketCounterData ticketCounterData = this.ticketcounterrepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Ticket id : " + id));

		this.ticketcounterrepo.delete(ticketCounterData);
		model.addAttribute("ticketCounterData", this.ticketcounterrepo.findAll());
		return "home";

	}

}
