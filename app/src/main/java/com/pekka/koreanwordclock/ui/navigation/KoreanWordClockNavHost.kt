package com.pekka.koreanwordclock.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pekka.koreanwordclock.ui.home.HomeScreen
import com.pekka.koreanwordclock.ui.home.HomeViewModel

@Composable
fun KoreanWordClockNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = "home",
    ) {
        composable("home") {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(viewModel)
        }
    }
}
