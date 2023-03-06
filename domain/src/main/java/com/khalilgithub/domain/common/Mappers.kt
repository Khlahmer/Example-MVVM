package com.khalilgithub.domain.common

import com.khalilgithub.data.team.models.TeamsModelData
import com.khalilgithub.domain.team.models.TeamsModelDomain

abstract class DataToDomainMapper<INPUT : Any, OUTPUT : Any> {
    fun toDomain(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw MappingException("Could not map ${input::class.simpleName}", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

fun List<TeamsModelData>.toDomain(): List<TeamsModelDomain> {
    val list = ArrayList<TeamsModelDomain>()
    for (team in this) {
        list.add(
            TeamsModelDomain(
                abbreviation = team.abbreviation,
                city = team.city,
                conference = team.conference,
                division = team.division,
                full_name = team.full_name,
                id = team.id,
                name = team.name
            )
        )
    }
    return list
}

class TeamModelFromDataToDomain() :
    DataToDomainMapper<List<TeamsModelData>, List<TeamsModelDomain>>() {
    override fun map(input: List<TeamsModelData>): List<TeamsModelDomain> {
        return input.toDomain()
    }
}