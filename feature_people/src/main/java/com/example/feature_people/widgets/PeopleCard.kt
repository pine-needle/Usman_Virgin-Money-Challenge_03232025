package com.example.feature_people.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.domain.models.people.VMPeopleResponseItemModel

@Composable
fun PeopleCard(person: VMPeopleResponseItemModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFC40202))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar Image
            AsyncImage(
                model = person.avatar,
                contentDescription = "${person.firstName}'s avatar",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f), // Allow text to expand
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "${person.firstName} ${person.lastName}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.White
                )

                Text(text = "Job Title: ${person.jobtitle}", fontSize = 14.sp, color = Color.LightGray)

                Text(text = "Email: ${person.email}", fontSize = 14.sp, color = Color.White)

                person.data?.let { data ->
                    Text(text = "Phone: ${data.title}", fontSize = 14.sp, color = Color.White)

                    Text(text = "Body: ${data.body}", fontSize = 14.sp, color = Color.White)
                }

                Text(text = "Favorite Color: ${person.favouriteColor}", fontSize = 14.sp, color = Color.White)
            }
        }
    }
}