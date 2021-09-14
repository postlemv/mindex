package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CompensationServiceImplTest {
	
	private String compensationCreateUrl;
	private String compensationReadUrl;
	private String employeeCreateUrl;

	@Autowired
	private CompensationService compensationService;
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setup() {
		this.compensationCreateUrl = "http://localhost:" + port + "/compensation/create/{id}";
		this.compensationReadUrl = "http://localhost:" + port + "/compensation/read/{id}";
		this.employeeCreateUrl = "http://localhost:" + port + "/employee";
	}

	@Test
	public void testCreateRead() {
		Employee testEmployee = new Employee();
		testEpmployee.setFirstName("John");
		testEmployee.setLastName("Doe");
		testEmployee.setDepartment("Engineering");
		testEmployee.setPosition("Developer");

		//Create Employee to create Compensation off of
		Employee createdEmployee = restTemplate.postForEntity(employeeCreateUrl, testEmployee, Employee.class).getBody();
	
		Compensation testCompensation = new Compensation(createdEmployee.getEmployeeId());

		//Create Compensation Checks
		Compensation createCompensation = restTemplate.postForEntity(compensationCreateUrl, /*Compensation.class, */createdEmployee.getEmployeeId()).getBody();		

		assertNotNull(createCompensation.getEmployee());
		assertCompensationEquivalence(testCompensation, createCompensation);

		//Read Compensation Checks
		Compensation readCompensation = restTemplate.getForEntity(compensationReadUrl, /*Compensation.class,*/ createdEmployee.getEmployeeId()).getBody();

		assertCompensationEquivalence(createCompensation, readCompensation);
	}

	private static void assertCompensationEquivalence(Compensation expected, Compensation actual) {
		assertEquals(expected.getEmpoyee(), actual.getEmployee());
		assertEquals(expected.getSalary(), actual.getSalary());
		assertEquals(expected.getEffectiveDate(), actual.getEffectiveDate());
	}
}









