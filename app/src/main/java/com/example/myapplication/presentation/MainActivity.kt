package com.example.myapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.coin_detail.CoinDetailScreen
import com.example.myapplication.presentation.coin_list.CoinListScreen
import com.example.myapplication.presentation.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyApplicationTheme {
                NavHost(navController = navController, startDestination = Screen.CoinListScreen.route)
                {
                    composable(
                        route = Screen.CoinListScreen.route
                    )
                    {
                        CoinListScreen(navController)
                    }

                    composable(
                        route = Screen.CoinDetailScreen.route + "/{coinId}"
                    )
                    {
                        CoinDetailScreen()
                    }
                }
            }
        }
    }
}
