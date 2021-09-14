package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.EmployeeService;

public interface CompensationService {
    Compensation create(String id);
    Compensation read(String id);
}
