package com.siv.repository

import com.siv.model.Airplane
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AirplaneRepository : JpaRepository<Airplane, Long>