package com.khalilgithub.data.team.dataSource

import com.khalilgithub.data.team.models.ResponseModelData
import retrofit2.http.GET

interface TeamsApi {
    @GET("5de8d40d31000074006b1487")
    fun getTeams(
    ): ResponseModelData
}