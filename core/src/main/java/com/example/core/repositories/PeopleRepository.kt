package com.example.core.repositories


import com.example.core.utils.UiStatus
import com.example.domain.models.people.VMPeopleResponseItemModel
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    //get people data
    suspend fun getPeopleData() : Flow<UiStatus<ArrayList<VMPeopleResponseItemModel>>>
}