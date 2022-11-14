package com.khalilgithub.examplemvvm.di

import com.khalilgithub.data.team.repository.TeamsRepository
import com.khalilgithub.domain.common.TeamModelFromDataToDomain
import com.khalilgithub.domain.team.useCases.TeamsUseCases
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class DomainModule {
    @Provides
    @Reusable
    fun providesFetchTeamsUseCase(
        repository: TeamsRepository,
    ): TeamsUseCases = TeamsUseCases(
        repository = repository,
    )
}
