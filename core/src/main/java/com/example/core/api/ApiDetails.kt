package com.example.core.api


import com.example.domain.models.people.VMPeopleResponseItemModel
import com.example.domain.models.rooms.VMRoomsResponseItemModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiDetails {
    //Get all people
    @GET(ApiReference.PEOPLE_END_POINT)
    suspend fun getPeopleData(): Response<List<VMPeopleResponseItemModel>>

    //Get room data
    @GET(ApiReference.ROOMS_END_POINT)
    suspend fun getRoomsData(): Response<List<VMRoomsResponseItemModel>>
}