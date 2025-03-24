package com.example.feature_rooms

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.core.utils.UiStatus
import com.example.core.vm.VMViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_rooms.widgets.RoomCard


@Composable
fun AvailableRoomsScreen(viewModel: VMViewModel = hiltViewModel()) {
    val roomsData by viewModel.roomsData.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

    when (roomsData) {
        is UiStatus.LOADING -> {
            Text("Loading Rooms...")
        }
        is UiStatus.SUCCESS -> {
            val rooms = (roomsData as UiStatus.SUCCESS).data
            if (rooms.isEmpty()) {
                Text("No Rooms Found")
            } else {
                LazyColumn(modifier = Modifier.padding(innerPadding)) {
                    items(rooms) { room ->
                        RoomCard(room = room)
                    }
                }
            }
        }
        is UiStatus.ERROR -> {
            val errorMessage = (roomsData as UiStatus.ERROR).message
            Text("Error loading rooms: $errorMessage")
        }
     }
   }
}


