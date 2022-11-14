package com.khalilgithub.examplemvvm.di

import com.khalilgithub.data.network.NetworkClient
import com.khalilgithub.data.team.dataSource.TeamsApi
import com.khalilgithub.data.team.repository.TeamsRepository
import com.khalilgithub.data.team.repository.TeamsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Reusable
    fun providesGetTeamApi(): TeamsApi =
        NetworkClient().getRetrofit().create(TeamsApi::class.java)

    @Provides
    @Reusable
    fun providesGetTeamRepository(teamsApi: TeamsApi):
            TeamsRepository =
        TeamsRepositoryImpl(teamsApi)
}
