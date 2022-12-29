package com.ust.EmplyoeeRegistration.Repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.EmplyoeeRegistration.model.Employee;

@Repository
public interface EmployeeRepost extends JpaRepository<Employee ,Integer >{

}
