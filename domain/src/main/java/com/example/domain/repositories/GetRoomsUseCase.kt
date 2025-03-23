package com.example.domain.repositories


import com.example.domain.models.rooms.VMRoomsResponseItemModel
import com.example.domain.utils.UiStatus
import kotlinx.coroutines.flow.Flow

interface GetRoomsUseCase {
    //get rooms data
    suspend fun getRoomsData() : Flow<UiStatus<ArrayList<VMRoomsResponseItemModel>>>
}