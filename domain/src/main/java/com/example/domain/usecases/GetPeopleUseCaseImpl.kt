package com.example.domain.usecases


import com.example.domain.models.people.VMPeopleResponseItemModel
import com.example.domain.utils.UiStatus
import com.example.domain.repositories.GetPeopleUseCase
import kotlinx.coroutines.flow.Flow

class GetPeopleUseCaseImpl(private val peopleRepository: GetPeopleUseCase) : GetPeopleUseCase {
    override suspend fun getPeopleData(): Flow<UiStatus<ArrayList<VMPeopleResponseItemModel>>> {
        return peopleRepository.getPeopleData()
    }

}