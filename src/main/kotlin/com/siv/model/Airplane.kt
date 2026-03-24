package com.siv.model

import jakarta.persistence.*

@Entity
@Table(name = "airplanes")
class Airplane(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var model: String = "",

    var capacity: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    var manufacturer: Manufacturer? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable = false)
    var airline: Airline? = null
)