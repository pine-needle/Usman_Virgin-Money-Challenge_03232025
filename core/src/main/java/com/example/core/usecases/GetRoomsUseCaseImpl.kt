package com.example.core.usecases


import com.example.core.repositories.RoomsRepository
import com.example.domain.models.rooms.VMRoomsResponseItemModel
import com.example.core.utils.UiStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRoomsUseCaseImpl @Inject constructor(private val roomsRepository: RoomsRepository) :
    GetRoomsUseCase {
    override suspend fun getRoomsData(): Flow<UiStatus<ArrayList<VMRoomsResponseItemModel>>> {
        return roomsRepository.getRoomsData()
    }
}