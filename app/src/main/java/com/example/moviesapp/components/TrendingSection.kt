package com.example.moviesapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.KeyboardArrowRight
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun TrendingSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Trending Now", style = TextStyle(
                    fontSize = 20.sp,
                    color = Color(0xFFE3E3DA)
                )
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "See all", style = TextStyle(
                        fontSize = 18.sp,
                        color = Color(0xFFA1AA91)
                    )
                )
                Icon(imageVector = Icons.AutoMirrored.Sharp.KeyboardArrowRight,
                    contentDescription = "Money Icon",
                    tint = Color.Gray)
            }

        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        MovieImageLazyRow()
    }
}
