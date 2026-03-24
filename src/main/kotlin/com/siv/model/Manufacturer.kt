package com.siv.model

import jakarta.persistence.*

@Entity
@Table(name = "manufacturers")
class Manufacturer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

    var country: String = ""
)