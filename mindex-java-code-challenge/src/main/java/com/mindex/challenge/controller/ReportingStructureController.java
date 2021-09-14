package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReportingStructureController {
	//private static final Logger LOG = LOggerFactory.getLogger(ReportingStructureController.class);

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/reportingstructure/{id}")
	public ReportingStructure create(@PathVariable String id) {
		//LOG.debug("Received request to create reporting structure with employee id [{}]", id);
		ReportingStructure reportingStructure = new ReportingStructure (employeeService.read(id));
		reportingStructure.setNumOfReports();
		return reportingStructure;
	}
}
