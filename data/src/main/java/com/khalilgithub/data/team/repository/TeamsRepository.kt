package com.khalilgithub.data.team.repository

import com.khalilgithub.data.team.models.TeamsModelData

interface TeamsRepository {

    suspend fun getTeams(): List<TeamsModelData>
}