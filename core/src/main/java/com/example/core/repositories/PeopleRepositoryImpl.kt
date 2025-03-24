package com.example.core.repositories


import com.example.core.api.ApiDetails
import com.example.core.utils.UiStatus
import com.example.domain.models.people.VMPeopleResponseItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(private val apiDetails: ApiDetails) :
    PeopleRepository {
    override suspend fun getPeopleData(): Flow<UiStatus<ArrayList<VMPeopleResponseItemModel>>> = flow {
        emit(UiStatus.LOADING)
        try {
            val response: Response<List<VMPeopleResponseItemModel>> = apiDetails.getPeopleData()
            if (response.isSuccessful) {
                val peopleList = response.body() ?: emptyList()
                emit(UiStatus.SUCCESS(ArrayList(peopleList)))
            } else {
                emit(UiStatus.ERROR(response.message()))
            }
        } catch (e: Exception) {
            emit(UiStatus.ERROR(e.message ?: "An unexpected error occurred."))
        }
    }
}