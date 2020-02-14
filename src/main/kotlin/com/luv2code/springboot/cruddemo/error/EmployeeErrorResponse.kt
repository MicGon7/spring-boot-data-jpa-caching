package com.luv2code.springboot.cruddemo.error

import com.fasterxml.jackson.annotation.JsonProperty

data class EmployeeErrorResponse(
        @JsonProperty("status")
        val status: Int,
        @JsonProperty("message")
        val message: String,
        @JsonProperty("timeStamp")
        val timeStamp: Long
)
