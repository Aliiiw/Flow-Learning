package com.example.mymvvpapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RandomPersonViewModel : ViewModel() {
    private val personList = listOf("ali", "mohammad", "akbar", "hossein")

    //state flow
    private val _stateFlowPerson = MutableStateFlow("")
    val stateFlowPerson = _stateFlowPerson.asStateFlow()

    //shared flow
    private val _sharedFlowPerson = MutableSharedFlow<String>()
    val sharedFlowPerson = _sharedFlowPerson.asSharedFlow()

    fun getRandomPerson() {
        viewModelScope.launch {
            val person = personList.random()
            _stateFlowPerson.emit(person)
            _sharedFlowPerson.emit(person)
        }
    }

}