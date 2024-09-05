package com.example.moviesapp.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.moviesapp.screens.MainViewModel

@Composable
@Preview(showBackground = true)
fun MovieImageLazyRow(mainViewModel: MainViewModel = hiltViewModel()) {
    val movieImages = mainViewModel.trendingImagesList.collectAsState()
    if(movieImages.value.isLoading){
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)) {
            items(listOf("", "", "")) { movieImage ->
                MovieImageCard(movieImage)
            }
        }
    }else{
        Log.d("TAG", "MovieImageLazyRow: ${movieImages.value.data}")
        LazyRow(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)) {
            items(movieImages.value.data.orEmpty()) { movieImage ->
                MovieImageCard(movieImage)
            }
        }
    }
}
