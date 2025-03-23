package com.example.domain.models.people


import com.google.gson.annotations.SerializedName

data class VMPeopleResponseItemModel(
    val avatar: String = "",
    val createdAt: String = "",
    val `data`: PeopleDataModel? = null,
    val email: String = "",
    val favouriteColor: String = "",
    val firstName: String = "",
    val fromName: String? = null,
    val id: String = "",
    val jobtitle: String = "",
    val lastName: String = "",
    val name: String? = null,
    val size: String? = null,
    val to: String? = null,
    val type: String? = null,
    @SerializedName("{}")
    val x: String? = null
)