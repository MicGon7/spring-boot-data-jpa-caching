package com.luv2code.springboot.cruddemo.service

import com.luv2code.springboot.cruddemo.CacheUtil
import com.luv2code.springboot.cruddemo.dao.EmployeeRepository
import com.luv2code.springboot.cruddemo.entity.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service // service is a specialize @component that will also scan the class path for required classes
@CacheConfig(cacheNames = ["employees"])
class EmployeeServiceImpl(val employeeRepository: EmployeeRepository) : EmployeeService {

    // Removed @Transactional since JpaRepository provides this functionality automatically
    @Override
    @Cacheable
    override fun findAll(): List<Employee>? {
        CacheUtil.simulateSlowService()
        return employeeRepository.findAll()
    }

    @Override
    @Cacheable
    override fun findById(id: Int): Employee? {
        CacheUtil.simulateSlowService()
        return employeeRepository.findById(id).get() // throws no such element exception
    }

    @Override
    @CacheEvict(allEntries = true)
    override fun save(employee: Employee) {
        employeeRepository.save(employee)
    }

    @Override
    @CacheEvict(allEntries = true)
    override fun deleteById(id: Int) {
        employeeRepository.deleteById(id)
    }
}