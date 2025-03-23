package com.example.domain.models.rooms


data class VMRoomsResponseItemModel(
    val createdAt: String = "",
    val id: String = "",
    val isOccupied: Boolean = false,
    val maxOccupancy: Int = 0
)