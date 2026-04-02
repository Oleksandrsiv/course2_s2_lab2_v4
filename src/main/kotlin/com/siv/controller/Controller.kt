package com.siv.controller

import com.siv.service.AirplaneService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/")
class AirplaneController (private val airplaneService: AirplaneService) {

    // show all airplanes (main page)
    @GetMapping
    fun listAirplanes(model: Model): String {
        model.addAttribute("airplanes", airplaneService.getAllAirplanes())
        return "index" // return name of HTML-template (index.html)
    }

    // show form for creating new airplane
    @GetMapping("/new")
    fun showCreateForm(model: Model): String {
        model.addAttribute("manufacturers", airplaneService.getAllManufacturers())
        model.addAttribute("airlines", airplaneService.getAllAirlines())
        return "create_form"
    }

    // save plane to DB
    @PostMapping("/save")
    fun saveAirplane(
        @RequestParam model: String,
        @RequestParam capacity: Int,
        @RequestParam manufacturerId: Long,
        @RequestParam airlineId: Long
    ): String {
        airplaneService.createAirplane(model, capacity, manufacturerId, airlineId)
        return "redirect:/"
    }

    // show edit form
    @GetMapping("/edit/{id}")
    fun showEditForm(@PathVariable id: Long, model: Model): String {
        model.addAttribute("airplane", airplaneService.getAirplaneById(id))
        model.addAttribute("manufacturers", airplaneService.getAllManufacturers())
        model.addAttribute("airlines", airplaneService.getAllAirlines())
        return "edit_form"
    }

    // update plane in DB
    @PostMapping("/update/{id}")
    fun updateAirplane(
        @PathVariable id: Long,
        @RequestParam model: String,
        @RequestParam capacity: Int,
        @RequestParam manufacturerId: Long,
        @RequestParam airlineId: Long
    ): String {
        airplaneService.updateAirplane(id, model, capacity, manufacturerId, airlineId)
        return "redirect:/"
    }

    // delete plane from DB
    @GetMapping("/delete/{id}")
    fun deleteAirplane(@PathVariable id: Long): String {
        airplaneService.deleteAirplane(id)
        return "redirect:/"
    }
}