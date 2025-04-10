package com.example.core.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.people.VMPeopleResponseItemModel
import com.example.domain.models.rooms.VMRoomsResponseItemModel
import com.example.core.usecases.GetPeopleUseCase
import com.example.core.usecases.GetRoomsUseCase
import com.example.core.utils.UiStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VMViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val getRoomsUseCase: GetRoomsUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _peopleData = MutableStateFlow<UiStatus<ArrayList<VMPeopleResponseItemModel>>>(
        UiStatus.LOADING)
    val peopleData: StateFlow<UiStatus<ArrayList<VMPeopleResponseItemModel>>> = _peopleData

    private val _roomsData = MutableStateFlow<UiStatus<ArrayList<VMRoomsResponseItemModel>>>(
        UiStatus.LOADING)
    val roomsData: StateFlow<UiStatus<ArrayList<VMRoomsResponseItemModel>>> = _roomsData

    init {
        fetchPeopleData()
        fetchRoomsData()
    }

    private fun fetchPeopleData() {
        viewModelScope.launch(dispatcher) {
            getPeopleUseCase.getPeopleData().collect {
                _peopleData.value = it
            }
        }
    }

    private fun fetchRoomsData() {
        viewModelScope.launch(dispatcher) {
            getRoomsUseCase.getRoomsData().collect {
                _roomsData.value = it
            }
        }
    }
}