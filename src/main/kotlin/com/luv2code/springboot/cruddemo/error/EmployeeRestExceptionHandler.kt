package com.luv2code.springboot.cruddemo.error

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

// centralized location for handling exceptions
@ControllerAdvice
class EmployeeRestExceptionHandler {

    // @ExceptionHandle: Handler method, @StudentNotFoundException: Exception type to handle/catch,
    // @StudentErrorResponse: Type of response body
    @ExceptionHandler
    fun handleException(exc: EmployeeNotFoundException): ResponseEntity<EmployeeErrorResponse> {
        // create a StudentErrorResponse
        val error = EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(), exc.localizedMessage, System.currentTimeMillis())

        // return a ResponseEntity
        // Jackson will convert this to the appropriate Json
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    // add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    fun handleException(exc: Exception): ResponseEntity<EmployeeErrorResponse> {
        // create a StudentErrorResponse
        val error = EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.localizedMessage, System.currentTimeMillis())

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}