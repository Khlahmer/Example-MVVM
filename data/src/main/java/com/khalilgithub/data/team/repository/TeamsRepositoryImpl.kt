package com.khalilgithub.data.team.repository

import com.khalilgithub.data.team.dataSource.TeamsApi
import com.khalilgithub.data.team.models.ResponseModelData
import com.khalilgithub.data.team.models.TeamsModelData
import javax.inject.Inject

class TeamsRepositoryImpl @Inject constructor(private val teamsApi: TeamsApi) : TeamsRepository {

    override suspend fun getTeams(): List<TeamsModelData> {
        return try {
            val data: ResponseModelData = teamsApi.getTeams()
            data.data

        } catch (e: Exception) {
            emptyList()
        }

    }


}