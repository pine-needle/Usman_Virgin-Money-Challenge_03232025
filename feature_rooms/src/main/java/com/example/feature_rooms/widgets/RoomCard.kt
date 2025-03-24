package com.example.feature_rooms.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.models.rooms.VMRoomsResponseItemModel

@Composable
fun RoomCard(room: VMRoomsResponseItemModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFC40202))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Room Number: ${room.id}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = "Max Occupancy: ${room.maxOccupancy}",
                fontSize = 14.sp,
                color = Color.White
            )

            Text(
                text = "Status: ${if (room.isOccupied) "OCCUPIED" else "AVAILABLE"}",
                fontSize = 14.sp,
                color = Color.White
            )

            Text(text = "Created At: ${room.createdAt}", fontSize = 14.sp, color = Color.White)
        }
    }
}