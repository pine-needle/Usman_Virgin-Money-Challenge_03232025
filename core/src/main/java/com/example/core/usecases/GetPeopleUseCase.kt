package com.example.core.usecases


import com.example.core.utils.UiStatus
import com.example.domain.models.people.VMPeopleResponseItemModel
import kotlinx.coroutines.flow.Flow

interface GetPeopleUseCase {
    suspend fun getPeopleData(): Flow<UiStatus<ArrayList<VMPeopleResponseItemModel>>>
}