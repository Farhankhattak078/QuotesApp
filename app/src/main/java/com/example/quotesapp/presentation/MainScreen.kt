package com.example.quotesapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.quotesapp.viewmodel.QuotesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: QuotesViewModel,
               navController: NavController) {
    val quotelist=viewModel.state.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Quotes")
            },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                ))
        },
        bottomBar = {
            BottomAppBar(containerColor = BottomAppBarDefaults.containerColor)
            {

                NavigationBar() {
                    NavigationBarItem(modifier = Modifier.weight(1f), selected = false,
                        onClick = {
                        navController.popBackStack()
                        },
                        icon = {
                            Icon(Icons.Default.Home,contentDescription = null)
                        },
                        label = {Text("Home")})

                    NavigationBarItem(selected = false,
                        onClick = {
                        navController.navigate("FavoriteScreen")

                        }
                        ,
                        icon = {
                            Icon(Icons.Default.Favorite,contentDescription = null)
                        },
                        label = {Text("Favorite")})

                }
            }
        }
    ) { padding->
        if (quotelist.quotes.isEmpty())
        {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center)
            { CircularProgressIndicator() }
        }
        else
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(quotelist.quotes.size)
            {
                    index->



                val quote=quotelist.quotes[index]
                val isFavorite=quote in viewModel.state.collectAsState().value.favorites
                QuotesCard(
                    quote = quote,
                    isFavorite = isFavorite,
                    onFavoriteClick = {
                        viewModel.toggleFavorite(quote)
                    },
                )
            }
        }

    }
}