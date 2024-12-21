package com.example.quotesapp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quotesapp.viewmodel.QuotesViewModel

@Composable
fun NavGraph(modifier: Modifier = Modifier,
             viewModel: QuotesViewModel) {
    val navcontroller= rememberNavController()
    NavHost(navController = navcontroller,
        startDestination = "MainScreen")
    {
        composable(route = "MainScreen")
        {
            MainScreen(viewModel =viewModel,
                navController = navcontroller)
        }
        composable(route = "FavoriteScreen")
        {
            FavoriteScreen(viewModel)
        }
    }
}