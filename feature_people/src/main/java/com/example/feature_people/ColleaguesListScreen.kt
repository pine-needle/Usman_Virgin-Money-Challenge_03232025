package com.example.feature_people

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.collectAsState
import com.example.core.utils.UiStatus
import com.example.core.vm.VMViewModel
import com.example.feature_people.widgets.PeopleCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColleaguesListScreen(viewModel: VMViewModel = hiltViewModel()) {
    val peopleData by viewModel.peopleData.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Colleagues List",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFC40202)
                )
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            when (peopleData) {
                is UiStatus.LOADING -> {
                    Text("Loading People...", modifier = Modifier.padding(16.dp))
                }
                is UiStatus.SUCCESS -> {
                    val people = (peopleData as UiStatus.SUCCESS).data
                    if (people.isEmpty()) {
                        Text("No People Found", modifier = Modifier.padding(16.dp))
                    } else {
                        LazyColumn(contentPadding = PaddingValues(bottom = 8.dp)) {
                            items(people) { person ->
                                PeopleCard(person = person)
                            }
                        }
                    }
                }
                is UiStatus.ERROR -> {
                    val errorMessage = (peopleData as UiStatus.ERROR).message
                    Text("Error loading people: $errorMessage", modifier = Modifier.padding(16.dp))
                }

                else -> {}
            }
        }
    }
}
