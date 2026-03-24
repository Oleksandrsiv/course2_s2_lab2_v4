package com.siv.model

import jakarta.persistence.*

@Entity
@Table(name = "airlines")
class Airline(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

    var iataCode: String = ""
)