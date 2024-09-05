package com.example.moviesapp.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.moviesapp.utils.Constants

//.shadow(5.dp, RoundedCornerShape(20.dp),
//ambientColor = Color(0xFFF0CE59),
//spotColor = Color(0xFFF0CE59)
//),
@Composable
fun MovieImageCard(movieImage:String){
    Surface(
        modifier = Modifier.width(180.dp).height(280.dp),
        color = Color.LightGray,
        shape = RoundedCornerShape(20.dp)
    ) {
        if(movieImage.isNotEmpty()){
            AsyncImage(
                model = movieImage,
                contentDescription = "Movie Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
            )
        }
    }
}
