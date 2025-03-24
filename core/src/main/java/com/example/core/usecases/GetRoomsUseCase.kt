package com.example.core.usecases

import com.example.core.utils.UiStatus
import com.example.domain.models.rooms.VMRoomsResponseItemModel
import kotlinx.coroutines.flow.Flow

interface GetRoomsUseCase {
    suspend fun getRoomsData(): Flow<UiStatus<ArrayList<VMRoomsResponseItemModel>>>
}