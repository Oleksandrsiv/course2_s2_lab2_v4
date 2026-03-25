package com.siv

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AirlineCrudApplication

fun main(args: Array<String>) {
    runApplication<AirlineCrudApplication>(*args)
}