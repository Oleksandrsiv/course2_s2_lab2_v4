package com.siv.repository

import com.siv.model.Airline
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AirlineRepository : JpaRepository<Airline, Long>