package com.luv2code.springboot.cruddemo.error

import java.lang.RuntimeException

class EmployeeNotFoundException(override val message: String?) : RuntimeException(message)
