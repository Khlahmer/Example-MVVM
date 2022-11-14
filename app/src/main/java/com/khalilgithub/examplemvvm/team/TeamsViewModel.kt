package com.khalilgithub.examplemvvm.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khalilgithub.domain.team.models.TeamsModelDomain
import com.khalilgithub.domain.team.useCases.TeamsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(private val useCases: TeamsUseCases) : ViewModel() {
    private var _info = MutableLiveData<List<TeamsModelDomain>>()
    val info: LiveData<List<TeamsModelDomain>> = _info

    fun fetchTeams() = viewModelScope.launch {
        val result = useCases.getTeams()
        _info.value = result
    }
}
