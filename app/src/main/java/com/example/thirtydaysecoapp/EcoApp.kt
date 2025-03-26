package com.example.thirtydaysecoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EcoApp() {
    val tips = DayTipData.tips


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F8E9))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Text(
                text = "Green Quest: 30 Days to a Better Planet",
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2E7D32)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(tips) { tip ->
                    DayTipCard(dayTip = tip)
                }
            }
        }
    }
}

@Composable
fun DayTipCard(dayTip: DayTip) {

    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF59D)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = "Day ${dayTip.dayNumber}",
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF33691E)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { isExpanded = !isExpanded }
            )


            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))


                Text(
                    text = dayTip.title,
                    style = TextStyle(
                        fontFamily = FontFamily.Serif,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF4E342E)
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))


                Image(
                    painter = painterResource(id = dayTip.imageResId),
                    contentDescription = dayTip.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(8.dp))
                )

                Spacer(modifier = Modifier.height(8.dp))


                Text(
                    text = dayTip.description,
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )
            }
        }
    }
}
