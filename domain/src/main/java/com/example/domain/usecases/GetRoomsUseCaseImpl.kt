package com.example.domain.usecases


import com.example.domain.models.rooms.VMRoomsResponseItemModel
import com.example.domain.utils.UiStatus
import com.example.domain.repositories.GetRoomsUseCase
import kotlinx.coroutines.flow.Flow

class GetRoomsUseCaseImpl(private val roomsRepository: GetRoomsUseCase) : GetRoomsUseCase {

    override suspend fun getRoomsData(): Flow<UiStatus<ArrayList<VMRoomsResponseItemModel>>> {
        return roomsRepository.getRoomsData()
    }
}