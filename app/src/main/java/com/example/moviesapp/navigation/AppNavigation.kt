package com.example.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.screens.HomeScreen
import com.example.moviesapp.screens.SplashScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.name){
        composable(AppScreens.SplashScreen.name){
            SplashScreen()
        }
        composable(AppScreens.HomeScreen.name){
            HomeScreen(navController, hiltViewModel())
        }
    }
}