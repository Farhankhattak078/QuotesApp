package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quotesapp.model.QuoteapiInstance
import com.example.quotesapp.model.repositary.offlineQuoteRepositary
import com.example.quotesapp.presentation.MainScreen
import com.example.quotesapp.presentation.NavGraph
import com.example.quotesapp.presentation.QuotesCard
import com.example.quotesapp.viewmodel.QuotesViewModel


class MainActivity : ComponentActivity() {
    val viewModel by viewModels<QuotesViewModel>(factoryProducer ={
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return QuotesViewModel(offlineQuoteRepositary(QuoteapiInstance.quoteapi))
                as T
            }
        }
    } )
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

           val quotelist=viewModel.state.collectAsState().value
            NavGraph(viewModel=viewModel)



        }
    }
}

