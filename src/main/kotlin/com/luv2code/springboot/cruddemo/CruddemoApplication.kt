package com.luv2code.springboot.cruddemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class CruddemoApplication

fun main(args: Array<String>) {
	runApplication<CruddemoApplication>(*args)
}

