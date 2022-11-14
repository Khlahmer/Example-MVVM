package com.khalilgithub.domain.team.useCases

import com.khalilgithub.data.team.models.TeamsModelData
import com.khalilgithub.data.team.repository.TeamsRepository
import com.khalilgithub.domain.common.TeamModelFromDataToDomain
import com.khalilgithub.domain.team.models.TeamsModelDomain
import javax.inject.Inject

class TeamsUseCases @Inject constructor(
    private val repository: TeamsRepository
) {
    private val mapper = TeamModelFromDataToDomain()
    suspend fun getTeams(): List<TeamsModelDomain> {
        val data: List<TeamsModelData> = repository.getTeams()
        return mapper.toDomain(data)
    }
}
