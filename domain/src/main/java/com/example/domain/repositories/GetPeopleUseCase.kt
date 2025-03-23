package com.example.domain.repositories


import com.example.domain.models.people.VMPeopleResponseItemModel
import com.example.domain.utils.UiStatus
import kotlinx.coroutines.flow.Flow

interface GetPeopleUseCase {
    //get people data
    suspend fun getPeopleData() : Flow<UiStatus<ArrayList<VMPeopleResponseItemModel>>>
}