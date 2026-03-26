package com.siv.service

import com.siv.model.Airplane
import com.siv.repository.AirlineRepository
import com.siv.repository.AirplaneRepository
import com.siv.repository.ManufacturerRepository
import org.springframework.stereotype.Service

@Service
class AirplaneService(
    private val airplaneRepository: AirplaneRepository,
    private val manufacturerRepository: ManufacturerRepository,
    private val airlineRepository: AirlineRepository
) {

    fun getAllAirplanes(): List<Airplane> {
        return airplaneRepository.findAll()
    }

    fun getAirplaneById(id: Long): Airplane {
        return airplaneRepository.findById(id)
            .orElseThrow { IllegalArgumentException("Plane with ID $id not found!") }
    }

    fun createAirplane(model: String, capacity: Int, manufacturerId: Long, airlineId: Long): Airplane {
        val manufacturer = manufacturerRepository.findById(manufacturerId)
            .orElseThrow { IllegalArgumentException("Manufacturer not found!") }
        val airline = airlineRepository.findById(airlineId)
            .orElseThrow { IllegalArgumentException("Airline not found!") }

        // if ok => create airplane
        val airplane = Airplane(
            model = model,
            capacity = capacity,
            manufacturer = manufacturer,
            airline = airline
        )

        // save to DB
        return airplaneRepository.save(airplane)
    }

    fun updateAirplane(id: Long, model: String, capacity: Int, manufacturerId: Long, airlineId: Long): Airplane {
        val airplane = getAirplaneById(id)
        val manufacturer = manufacturerRepository.findById(manufacturerId)
            .orElseThrow { IllegalArgumentException("Manufacturer not found!") }
        val airline = airlineRepository.findById(airlineId)
            .orElseThrow { IllegalArgumentException("Airline not found!") }

        // update fields
        airplane.model = model
        airplane.capacity = capacity
        airplane.manufacturer = manufacturer
        airplane.airline = airline

        return airplaneRepository.save(airplane)
    }

    fun deleteAirplane(id: Long) {
        if (!airplaneRepository.existsById(id)) {
            throw IllegalArgumentException("Plane with ID $id not found!!")
        }
        airplaneRepository.deleteById(id)
    }

    // methods for select operation
    fun getAllManufacturers() = manufacturerRepository.findAll()
    fun getAllAirlines() = airlineRepository.findAll()
}