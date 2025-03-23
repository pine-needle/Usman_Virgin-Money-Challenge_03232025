package com.example.data.api


import com.example.domain.models.people.PeopleDataModel
import com.example.domain.models.rooms.VMRoomsResponseItemModel
import retrofit2.http.GET

interface ApiDetails {
    //Get all people
    @GET(ApiReference.PEOPLE_END_POINT)
    suspend fun getPeopleData(): PeopleDataModel

    //Get room data
    @GET(ApiReference.ROOMS_END_POINT)
    suspend fun getRoomsData(): VMRoomsResponseItemModel
}