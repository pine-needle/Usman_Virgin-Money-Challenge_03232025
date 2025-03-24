package com.example.core.repositories


import com.example.core.api.ApiDetails
import com.example.core.utils.UiStatus
import com.example.domain.models.rooms.VMRoomsResponseItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class RoomsRepositoryImpl @Inject constructor(private val apiDetails: ApiDetails) :
    RoomsRepository {
    override suspend fun getRoomsData(): Flow<UiStatus<ArrayList<VMRoomsResponseItemModel>>> = flow {
        emit(UiStatus.LOADING)
        try {
            val response: Response<List<VMRoomsResponseItemModel>> = apiDetails.getRoomsData()
            if (response.isSuccessful) {
                val roomsList = response.body() ?: emptyList()
                emit(UiStatus.SUCCESS(ArrayList(roomsList)))
            } else {
                emit(UiStatus.ERROR(response.message()))
            }
        } catch (e: Exception) {
            emit(UiStatus.ERROR(e.message ?: "An unexpected error occurred."))
        }
    }
}