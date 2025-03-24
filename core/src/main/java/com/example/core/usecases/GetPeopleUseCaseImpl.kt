package com.example.core.usecases


import com.example.domain.models.people.VMPeopleResponseItemModel
import com.example.core.utils.UiStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPeopleUseCaseImpl @Inject constructor(private val peopleRepository: com.example.core.repositories.PeopleRepository) :
    GetPeopleUseCase {
    override suspend fun getPeopleData(): Flow<UiStatus<ArrayList<VMPeopleResponseItemModel>>> {
        return peopleRepository.getPeopleData()
    }
}