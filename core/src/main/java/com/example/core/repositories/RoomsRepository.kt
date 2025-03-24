package com.example.core.repositories


import com.example.core.utils.UiStatus
import com.example.domain.models.rooms.VMRoomsResponseItemModel
import kotlinx.coroutines.flow.Flow

interface RoomsRepository {
    //get rooms data
    suspend fun getRoomsData() : Flow<UiStatus<ArrayList<VMRoomsResponseItemModel>>>
}