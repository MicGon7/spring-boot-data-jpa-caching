package com.luv2code.springboot.cruddemo.dao

import com.luv2code.springboot.cruddemo.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Int>
// Provides CRUD features automatically

