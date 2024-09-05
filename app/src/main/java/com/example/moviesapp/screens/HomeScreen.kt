package com.example.moviesapp.screens

import CustomInputField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.components.TrendingSection

@Composable
@Preview(showBackground = true)
fun HomeScreen(
    navController: NavController = rememberNavController(),
    mainViewModel: MainViewModel = hiltViewModel()
) {

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomInputField()
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            TrendingSection()
        }
    }
//    val moviesState = mainViewModel.moviesList.collectAsState()
//
//    if (moviesState.value.isLoading) {
//        // Show a loading indicator while data is being loaded
//        Text(text = "Loading...")
//    } else {
//        // Display the movies in a LazyColumn
//        moviesState.value.data?.let { movies ->
//            LazyColumn {
//                items(movies) { movie: MovieEntity ->
//                    Text(text = movie.original_title)
//                }
//            }
//        } ?: run {
//            // Handle the case where the list is null or empty
//            Text(text = "No movies found")
//        }
//    }
}